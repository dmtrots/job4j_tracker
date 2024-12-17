package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 412);
        Book classic = new Book("Crime and punishment", 592);
        Book fiction = new Book("Moby Dick", 576);
        Book science = new Book("A brief history of time", 272);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = classic;
        books[2] = fiction;
        books[3] = science;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPages());
        }
        System.out.println("Поменять местами первый и четвертый элементы");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPages());
        }
        System.out.println("Вывести только Clean code");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getPages());
            }
        }
    }
}
