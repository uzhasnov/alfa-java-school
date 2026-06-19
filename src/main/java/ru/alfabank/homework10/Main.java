package ru.alfabank.homework10;

public class Main {

    public static void main(String[] args) {

        TaskTracker taskTracker = new TaskTracker();

        taskTracker.addTask("Покормить кота");
        taskTracker.addTask("Приготовить завтрак");
        taskTracker.addTask("Выполнить домашнее задание");
        taskTracker.printAllTasks();
        taskTracker.setTaskAsDone("Покормить кота");
        taskTracker.findTask("Выполнить домашнее задание");
        taskTracker.findTask("Приготовить ужин");
        taskTracker.printAllTasks();
        taskTracker.printStatistics();
    }
}
