package ru.job4j.polymorphism;

import ru.job4j.cast.Vehicle;

public class Bus implements Transport, Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " ездит по скоростным трассам");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Количество пассажиров: " + count);
    }

    @Override
    public int refuel(int fuel) {
        return fuel;
    }
}
