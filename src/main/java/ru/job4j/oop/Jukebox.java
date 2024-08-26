package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
       String result = switch (position) {
            case 1 ->  "Пусть бегут неуклюже";
            case 2 ->  "Спокойной ночи";
            default -> "Песня не найдена";
        };
        System.out.println(result);
    }

    public static void main(String[] args) {
        Jukebox name = new Jukebox();
         name.music(1);
         name.music(2);
         name.music(3);
    }
}
