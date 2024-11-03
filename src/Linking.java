import java.io.File;
import java.util.*;

public class Linking {

    public List<String> pathToLinkedFiles = new ArrayList<>();
    public static Map<String, List<String>> linkedFiles = new HashMap<>();
    public static List<File> basePath = new ArrayList<>();

    public Linking(String fileName) {
        String fileNameWithoutExtension = fileName.substring(0, fileName.lastIndexOf('.'));

        int numb=0;
        File Students = new File("./STUDENTS/");
        basePath = Arrays.asList(Students.listFiles());
        for (File studentDir : basePath) {

            File taskFile = new File(studentDir, fileNameWithoutExtension);
            if (taskFile.exists() && taskFile.isDirectory()) {
                String path = studentDir + "\\" + fileNameWithoutExtension + "\\" + fileName;
                pathToLinkedFiles.add(path);
                linkedFiles.put(fileNameWithoutExtension, pathToLinkedFiles);
                numb++;
            }

        }
        if(numb==0) {
            System.out.println("The task folder do not exists. The task can not be linked.");
            return;
        }


        System.out.println("The task is successfully linked!");
        System.out.println("The paths of all linked tasks.");
        for (Map.Entry<String, List<String>> entry : linkedFiles.entrySet()) {
            System.out.println("Task: " + entry.getKey() + ", Path = " + entry.getValue());
        }


    }
}
