package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            if (matches == 0) {
                System.out.println("Вы не взяли ни одной спички");
                System.out.println("Количество оставшихся спичек: " + count);
            } else if (matches >= 1 && matches <= 3) {
                count -= matches;
                System.out.println("Количество оставшихся спичек: " + count);
                turn = !turn;
            } else if (matches < 0) {
                System.out.println("Количество взятых спичек должно быть больше 0");
            } else  {
                System.out.println("Вы взяли больше трех спичек");
                System.out.println("Количество оставшихся спичек: " + count);
            }
        }
            if (!turn) {
                System.out.println("Выиграл первый игрок");
            } else {
                System.out.println("Выиграл второй игрок");
            }
    }
}