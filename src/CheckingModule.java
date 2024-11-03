import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CheckingModule {
    private Scanner scanner = new Scanner(System.in);
    private final String NumberOfReceivedSolution = "amount";
    private final String AccessInSequence = "access";
    private final String SubmitInformation = "info";
    private final String PreviewMode = "preview";
    private final String Next = "next";
    private final String Previous = "previous";
    private final String Quit = "quit";
    private SequentialPreview sequentialPreview;
    private String currentFile;


    public void execute() {
        while (true) {
            if (sequentialPreview == null) {
                System.out.println("You have selected Task Checking Module.");
                System.out.println("Enter \"amount\" to get  information about the number of received solutions for a specific task ");
                System.out.println("Enter \"access\" to access to all tasks in sequence");
                System.out.println("Enter \"info\" to get the information about how many tasks were submitted by a student with a specific first name and last name");
                System.out.println("Enter \"preview\" to displaying one file at a time, with the ability to move to the previous/next");
                System.out.println("Enter \"quit\" to leave the checking module");
            } else {
                System.out.println("Enter \"next\" to move to the next file");
                System.out.println("Enter \"previous\" to move to the previous file");
            }


            String oper = scanner.nextLine();
            if (oper.equalsIgnoreCase(Quit)) {
                System.out.println("You are leaving the Checking module.");
                break;
            }
            switch (oper) {
                case NumberOfReceivedSolution -> {
                    new CountTaskSolutions();
                }
                case AccessInSequence -> {
                    new AccessTasksInSequence();
                }
                case SubmitInformation -> {
                    new SubmitInfo();
                }
                case PreviewMode -> {
                    sequentialPreview = new SequentialPreview();
                    if (sequentialPreview.isSolutionFileIteratorNull()) {
                        sequentialPreview = null;
                        System.out.println("Directory does not exist. Returning to checking module options.");
                    }

                }
                case Next -> {
                    if (sequentialPreview != null) {

                        currentFile = sequentialPreview.moveToNextFile();
                        System.out.println("CurrentFile path is " + currentFile);
                        if (currentFile != null) {
                            displayFile();
                        } else {
                            System.out.println("No more files to show. Returning to checking module options.");
                            sequentialPreview = null;
                        }
                    } else {
                        System.out.println("Please enter preview mode to navigate between files.");
                    }
                }
                case Previous -> {
                    if (sequentialPreview != null) {
                        currentFile = sequentialPreview.moveToPreviousFile();
                        currentFile = sequentialPreview.moveToPreviousFile();
                        System.out.println(" CurrentFile path is " + currentFile);
                        currentFile = sequentialPreview.moveToNextFile();
                        if (currentFile != null) {
                            displayFile();
                        } else {
                            System.out.println("No more files to show. Returning to checking module options.");
                            sequentialPreview = null;
                        }
                    } else {
                        System.out.println("Please enter preview mode to navigate between files.");
                    }
                }
                default -> System.out.println("Invalid operation, please try again.");
            }

        }
    }
    private void displayFile() {

        Path fullPath = Paths.get("./STUDENTS/", currentFile);

        if (Files.exists(fullPath)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fullPath.toString()))) {
                String line = reader.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File " + fullPath.toString() + " does not exist.");
        }
    }
}