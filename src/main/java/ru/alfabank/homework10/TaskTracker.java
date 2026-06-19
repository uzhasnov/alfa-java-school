package ru.alfabank.homework10;

import java.util.ArrayList;
import java.util.List;

public class TaskTracker {

    private final List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Добавлена задача: " + task);
    }

    public void printAllTasks() {
        System.out.println("Список задач:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public Task findTask(String taskName) {
        for (Task task : tasks) {
            if (task.getName().equals(taskName)) {
                System.out.println(task);
                return task;
            } else {
                System.out.println("Задача не найдена");
            }
        }
        return null;
    }

    public Task setTaskAsDone(String taskName) {
        Task taskToSetDone = findTask(taskName);
        taskToSetDone.setTaskAsDone();
        System.out.printf("Задача %s помечена как выполненная", taskToSetDone.getName());
        return taskToSetDone;
    }

    public void printStatistics() {
        int tasksTotalCount = tasks.size();
        int tasksDoneCount = 0;
        int tasksNotDoneCount;

        for (Task task : tasks) {
            if (task.getStatus().equals("[x]")) {
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
