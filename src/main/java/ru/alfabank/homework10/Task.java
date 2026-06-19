package ru.alfabank.homework10;

public class Task {

    private final String name;
    private String status;
    private final static String TASK_STATUS_DONE_VALUE = "[x]";
    private final static String TASK_STATUS_NOT_DONE_VALUE = "[ ]";

    public Task(String name) {
        this.name = name;
        this.status = Task.TASK_STATUS_NOT_DONE_VALUE;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setTaskAsDone() {
        status = TASK_STATUS_DONE_VALUE;
    }

    @Override
    public String toString() {
        return status + " " + name;
    }
}
