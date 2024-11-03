
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.List;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.ListIterator;
import java.util.stream.Stream;

public class SequentialPreview {

    private ListIterator<String> solutionFileIterator;
    private String basePath;

    public SequentialPreview() {
        loadSequentialPreview();
    }

    public void loadSequentialPreview() {
        Scanner sc = new Scanner(System.in);
        basePath = "./STUDENTS/";
        System.out.println("Enter the name of the student to show his solution");
        String specificStudentName = sc.nextLine();
        findStudentSolutions(basePath, specificStudentName);
    }

    private void findStudentSolutions(String basePath, String studentName) {
        Path studentPath = Paths.get(basePath, studentName);
        if (!Files.exists(studentPath) || !Files.isDirectory(studentPath)) {
            System.out.println("The directory does not exist or it is not a directory");
            return;
        }

        System.out.println("Enter the task name to show its solution");
        Scanner sc = new Scanner(System.in);
        String taskName = sc.nextLine();

        Path specificTaskPath = studentPath.resolve(taskName);
        if (!Files.exists(specificTaskPath) || !Files.isDirectory(specificTaskPath)) {
            System.out.println("The specific task directory does not exist or it is not a directory");
            return;
        }

        try (Stream<Path> taskStream = Files.list(specificTaskPath)) {
            List<String> studentSolution = taskStream
                    .map(path -> Paths.get(studentName, taskName, path.getFileName().toString()).toString())
                    .collect(Collectors.toList());

            solutionFileIterator = studentSolution.listIterator();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String moveToNextFile() {
        if (solutionFileIterator != null && solutionFileIterator.hasNext()) {
            return solutionFileIterator.next();
        } else {
            return null;
        }
    }

    public String moveToPreviousFile() {
        if (solutionFileIterator != null && solutionFileIterator.hasPrevious()) {
            return solutionFileIterator.previous();
        } else {
            return null;
        }
    }


    public boolean isSolutionFileIteratorNull() {
        return this.solutionFileIterator == null;
    }
}

