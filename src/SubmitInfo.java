import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class SubmitInfo {
    private int solutions;

    public SubmitInfo() {
        getInfo();
    }

    public void getInfo() {
        Scanner sc = new Scanner(System.in);

        String path = "./STUDENTS/";
        List<String> student = new ArrayList<>();



        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Path.of(path));) {
            for (Path entry : stream) {
                student.add(entry.getFileName().toString());
            }
        } catch (IOException e) {
            System.out.println("Student not found");
        }


        boolean continueRunning = true;
        while (continueRunning) {
            System.out.println("Write the name of the student to preview his/her submitted task");
            String specificName = sc.nextLine();
            if (!student.contains(specificName)) {
                System.out.println("Student does not exist.");
                continue;
            }
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(Path.of(path));) {
                for (Path entry : stream) {
                    boolean studentExists = false;
                    for (String name : student) {
                        if (name.equals(specificName)) {
                            studentExists = true;
                            if (entry.getFileName().toString().equals(specificName)) {
                                DirectoryStream<Path> stream1 = Files.newDirectoryStream(entry);
                                for (Path file : stream1) {
                                    solutions++;
                                }
                                System.out.println("Student: " + specificName + " submitted " + solutions + " tasks");
                                solutions = 0;

                            }
                        }
                    }
                    if (!studentExists) {
                        System.out.println("Student does not exists.");
                    }
                }
            } catch (IOException e) {
                System.out.println("Student not found");
            }
            System.out.println("Do you want to continue? (yes/no)");
            String userInput = sc.nextLine();
            if ("no".equalsIgnoreCase(userInput.trim())) {
                continueRunning = false;
            }
        }

    }
}
