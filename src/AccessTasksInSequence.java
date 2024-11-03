
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class AccessTasksInSequence {
    private File[] tasks;
    private int currentTaskIndex;

    public AccessTasksInSequence() {
        setupTasks();
        startTaskProcessingLoop();
    }


    private void setupTasks() {

        File tasksDir = new File("./Tasks/");
        if (!tasksDir.exists() || !tasksDir.isDirectory()) {
            System.err.println("Tasks directory not found!");
            return;
        }


        tasks = tasksDir.listFiles(File::isFile);


        Arrays.sort(tasks);
        currentTaskIndex = 0;
    }

    private void startTaskProcessingLoop() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            loadTaskToFileViewer();
            System.out.println("Type 'move' to move to next task or 'exit' to return to the Checking module menu.");
            String command = scanner.nextLine();
            if ("move".equalsIgnoreCase(command)) {
                nextTask();
            } else if ("exit".equalsIgnoreCase(command)) {
                return;
            }
        }
    }

    private void loadTaskToFileViewer() {
        if (currentTaskIndex < tasks.length) {
            File currentTask = tasks[currentTaskIndex];
            System.out.println("You are in task: " + currentTask.getName());
        } else {
            System.out.println("No more tasks.");
        }
    }

    public void nextTask() {
        if (currentTaskIndex < tasks.length) {
            currentTaskIndex++;
        }
    }

}
