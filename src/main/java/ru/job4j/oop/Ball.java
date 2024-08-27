package ru.job4j.oop;

public class Ball {
    public boolean tryRun(boolean condition) {
        if (!condition) {
            System.out.println("Колобок убежал");
        } else {
            System.out.println("Rолобок съеден");
        }
        return condition;
    }
}
