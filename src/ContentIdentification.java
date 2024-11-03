import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentIdentification {

    private final Pattern LATEX_PATTERN = Pattern.compile("\\$.*?\\$", Pattern.DOTALL);
    private final Pattern IMAGE_PATTERN = Pattern.compile("\\\\href\\{(.*?)\\}");

    private Map<String, List<Content>> fileContents = new HashMap<>();

    public void identifyContent(String filename, StringBuilder content) {
        List<Content> contents = fileContents.computeIfAbsent(filename, k -> new ArrayList<>());

        contents.addAll(extractLatexContent(content));
        contents.addAll(extractImageContent(content));

        String[] lines = content.toString().split("\\n");
        for (String line : lines) {
            String trimmedLine = line.trim();
            if (trimmedLine.startsWith("-") || !trimmedLine.isEmpty()) {
                contents.add(new StringContent(trimmedLine));
            }
        }
    }

    private List<Content> extractLatexContent(StringBuilder content) {
        return extractContent(content, LATEX_PATTERN, "Latex");
    }

    private List<Content> extractImageContent(StringBuilder content) {
        return extractContent(content, IMAGE_PATTERN, "Image");
    }

    private List<Content> extractContent(StringBuilder content, Pattern pattern, String type) {
        List<Content> contents = new ArrayList<>();
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            String matchResult = matcher.group();//returns the actual matched sequence as a string
            switch (type) {
                case "Latex":
                    contents.add(new LatexFormulaContent(matchResult));
                    break;

                case "Image":
                    contents.add(new Image(matchResult));
                    break;
            }
            replaceWithSpaces(content, matcher.start(), matcher.end());
        }

        return contents;
    }

    private void replaceWithSpaces(StringBuilder content, int start, int end) {
        for (int i = start; i < end; i++) {
            content.setCharAt(i, ' ');
        }
    }
    public void displayContentList(String filename) {
        List<Content> contents = fileContents.get(filename);
        if (contents != null) {
            contents.forEach(content -> {
                System.out.println("Detected [" + content.getContentType() + "]: " + content.getContent());
            });
        } else {
            System.out.println("No contents for filename " + filename);
        }
    }



}
