package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        System.out.println("Неизвестное слово. " + eng);
        return eng;
    }

    public static void main(String[] args) {
        DummyDic word = new DummyDic();
        String unknownWord = "Hello";
        word.engToRus(unknownWord);
    }
}
