package ru.alfabank.homework13;

import java.util.LinkedList;

public class AssaultQueue {

    private final LinkedList<String> queue = new LinkedList<>();

    public void addRecruit(String name) {
        queue.add(name);
    }

    public String retireCoward() {
        if (!queue.isEmpty()) {
            return queue.remove();
        } else {
            System.out.println("Очередь пуста");
            return null;
        }
    }

    public void printQueue() {
        System.out.println(queue);
    }

    @Override
    public String toString() {
        return "AssaultQueue{" +
                "queue=" + queue +
                '}';
    }
}
