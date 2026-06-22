package ru.alfabank.homework10;

public class Task {

    private final String name;
    private boolean isDone;

    public Task(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя задачи не может быть пустым");
        }
        this.name = name;
        this.isDone = false;
    }

    public String getName() {
        return name;
    }

    public Boolean getStatus() {
        return isDone;
    }

    public void setTaskAsDone() {
        isDone = true;
    }

    @Override
    public String toString() {
        String statusIcon = isDone ? "[x]" : "[ ]";
        return String.format("%s %s", statusIcon, name);
    }
}
