package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        return eng;
    }

    public static void main(String[] args) {
        DummyDic word = new DummyDic();
        String unknownWord = word.engToRus("Hello");
        System.out.println("Неизвестное слово: " + unknownWord);
    }
}
