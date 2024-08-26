package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public String sound() {
        String voice = "may-may";
        return voice;
    }

    public void show() {
        System.out.println(this.food);
        System.out.println(this.name);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        Cat sparky = new Cat();
        Cat gav = new Cat();
        Cat black = new Cat();
        String say = peppy.sound();
        System.out.println("Peppy says " + say);
        System.out.println("There is gav's food.");
        gav.eat("cutlet");
        gav.giveNick("gav");
        gav.show();
        System.out.println("There is black's food.");
        black.eat("fish");
        black.giveNick("black");
        black.show();
    }
}
