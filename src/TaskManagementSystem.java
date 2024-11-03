import java.util.Scanner;

public abstract class TaskManagementSystem {
    private final TaskEditingModule creationModule = new TaskEditingModule();
    private final CheckingModule checkingModule = new CheckingModule();

    public TaskEditingModule getCreationModule() {
        return creationModule;
    }

    public CheckingModule getCheckingModule() {
        return checkingModule;
    }

    public abstract void taskManagement();
}
