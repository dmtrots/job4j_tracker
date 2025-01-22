package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Автобус едет");
    }

    @Override
    public int passengers(int count) {
        return count;
    }

    @Override
    public int refuel(int fuel) {
        return fuel;
    }
}
