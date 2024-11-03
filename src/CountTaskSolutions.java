import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CountTaskSolutions {
    public CountTaskSolutions(){
        countTaskSolutions();
    }
    public void countTaskSolutions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the task you want to check:");
        String taskName = scanner.nextLine();

        File studentsDir = new File("./STUDENTS/");
        if (!studentsDir.exists() || !studentsDir.isDirectory()) {
            System.out.println("Students directory not found!");
            return;
        }

        int totalFileCount = 0;
        for (File studentFolder : studentsDir.listFiles()) {
            if (studentFolder.isDirectory()) {
                System.out.println("Checking student directory: " + studentFolder.getName());
                Path taskFolder = Paths.get(studentFolder.getAbsolutePath(), taskName);
                File taskDirFile = taskFolder.toFile();
                if (taskDirFile.exists() && taskDirFile.isDirectory()) {
                    System.out.println( taskFolder.getFileName() + " is submitted.");
                    totalFileCount++;
                } else {
                    System.out.println( "No solutions was found.");
                }
            }
        }

        System.out.println("Received solutions for task " + taskName + ": " + totalFileCount);
    }
}
