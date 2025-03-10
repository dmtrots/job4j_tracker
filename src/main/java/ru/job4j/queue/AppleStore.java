package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        for (int i = 0; i < queue.size(); i++) {
            if (queue.size() == count) {
                break;
            }
            queue.poll();
        }
        return queue.peek().name();
    }

    public String getFirstUpsetCustomer() {
        for (int i = 0; i < queue.size(); i++) {
            if (queue.size() - count == -1) {
                break;
            }
            queue.poll();
        }
        return queue.peek().name();
    }
}