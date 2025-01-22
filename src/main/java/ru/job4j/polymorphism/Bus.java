package ru.job4j.polymorphism;

import ru.job4j.cast.Vehicle;

public class Bus implements Transport, Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " ездит по скоростным трассам");
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
