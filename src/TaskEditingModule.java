import java.util.Scanner;

public  class TaskEditingModule {
     Scanner scanner = new Scanner(System.in);

    public void execute() {
        while (true) {
            System.out.println("You have selected Task Creation Module.");
            System.out.println("Enter \"create\" to create a file");
            System.out.println("Enter \"edit\" to edit a file");
            System.out.println("Enter \"show\" to show the contents of a file");
            System.out.println("Enter \"quit\" to come back to the main menu");
            String oper = scanner.nextLine();
            if (Operation.StringToEnum(oper) == Operation.QUITE) {
                System.out.println("You are leaving the module.");
                break;
            } else if (Operation.StringToEnum(oper) == null) {
                System.out.println("Invalid operation , please try again");
                continue;
            }
            switch (Operation.StringToEnum(oper)) {
                case CREATE -> {
                    FileTaskCreator a = new FileTaskCreator();
                    a.createFile();
                    while(true) {
                        System.out.println("Do you want to continue? Yes / No");
                        String userResponse = scanner.nextLine();

                        if ("No".equalsIgnoreCase(userResponse)) {
                            System.out.println("You are leaving this operation.");
                            break;
                        } else if ("Yes".equalsIgnoreCase(userResponse)) {
                            a.createFile();
                        } else {
                            System.out.println("Invalid option, please try again.");
                        }
                    }
                }
                case EDIT -> {
                    FileTaskEditor editor = new FileTaskEditor();

                    editor.editFile();
                    while(true) {
                        System.out.println("Do you want to continue? Yes / No");
                        String userResponse = scanner.nextLine();

                        if ("No".equalsIgnoreCase(userResponse)) {
                            System.out.println("You are leaving this operation.");
                            break;
                        } else if ("Yes".equalsIgnoreCase(userResponse)) {
                            editor.editFile();
                        } else {
                            System.out.println("Invalid option, please try again.");
                        }
                    }
                }
                case SHOW -> {
                    FileTaskViewer viewer = new FileTaskViewer();

                    viewer.show();
                    while(true) {
                        System.out.println("Do you want to continue? Yes / No");
                        String userResponse = scanner.nextLine();

                        if ("No".equalsIgnoreCase(userResponse)) {
                            System.out.println("You are leaving this operation.");
                            break;
                        } else if ("Yes".equalsIgnoreCase(userResponse)) {
                            viewer.show();
                        } else {
                            System.out.println("Invalid option, please try again.");
                        }
                    }
                }

            }

        }
    }


}
