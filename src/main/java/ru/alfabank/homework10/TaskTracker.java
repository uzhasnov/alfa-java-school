package ru.alfabank.homework10;

import java.util.ArrayList;
import java.util.List;

public class TaskTracker {

    private final List<Task> tasks = new ArrayList<>();

    public void addTask(String taskName) {
        Task taskToAdd = new Task(taskName);
        tasks.add(taskToAdd);
        System.out.printf("Добавлена задача \"%s\"\n", taskToAdd);
    }

    public void printAllTasks() {
        System.out.println("\nСписок задач:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public Task findTask(String taskName) {
        System.out.printf("\nПоиск задачи с названием \"%s\"\n", taskName);
        for (Task task : tasks) {
            if (task.getName().equals(taskName)) {
                System.out.printf("Найдена задача \"%s\"\n", task);
                return task;
            }
        }
        System.out.println("Задача не найдена");
        return null;
    }

    public Task setTaskAsDone(String taskName) {
        Task taskToSetDone = findTask(taskName);
        if (taskToSetDone != null) {
            taskToSetDone.setTaskAsDone();
            System.out.printf("Задача помечена как выполненная: \"%s\"\n", taskToSetDone);
            return taskToSetDone;
        } else throw new IllegalArgumentException("Задача не найдена");

    }

    public void printStatistics() {
        int tasksTotalCount = tasks.size();
        int tasksDoneCount = 0;
        int tasksNotDoneCount;

        for (Task task : tasks) {
            if (task.getStatus()) {
                tasksDoneCount++;
            }
        }
        tasksNotDoneCount = tasksTotalCount - tasksDoneCount;

        System.out.printf(
                   """
                   \nВсего задач: %d
                   Выполнено: %d
                   Открыто: %d
                   """,
                   tasksTotalCount,
                   tasksDoneCount,
                   tasksNotDoneCount
        );
    }
}
