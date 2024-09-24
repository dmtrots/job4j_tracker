package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {

    private static final String TOMATOES = " + extra tomatoes";

    public PizzaExtraCheeseExtraTomato() {
        super();
    }

    @Override
    public String name() {
        return super.name() + TOMATOES;
    }
}
