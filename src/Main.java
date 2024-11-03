import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TaskManagementSystem taskManagementSystem= new TaskManagementSystem() {
            @Override
            public void taskManagement() {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.println("Enter \"1\" to access the Task Creation module.");
                    System.out.println("Enter \"2\" to access the Task Checking module.");
                    System.out.println("Enter \"stop\" to stop the program");
                    String module = scanner.nextLine();

                    if ("stop".equalsIgnoreCase(module)) {
                        System.out.println("Application is stopped...");
                        break;
                    } else if (!"1".equals(module) && !"2".equals(module)) {
                        System.out.println("Invalid option, please try again.");
                        continue;
                    }

                    if ("1".equals(module)) {
                        getCreationModule().execute();
                    } else if ("2".equals(module)) {
                        getCheckingModule().execute();
                    }
                }
            }
        };
        taskManagementSystem.taskManagement();

    }
}