package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active  = active;
        this.status  = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Статус активности: " + active);
        System.out.println("Код ошибки: " + status);
        System.out.println("Ошибка: " + message);
    }

    public static void main(String[] args) {
        Error errorFirst  = new Error();
        Error errorSecond = new Error(true, 10, "Error in initialization");
        Error errorThird  = new Error(true, 5, "Error in definition");
        errorFirst.printInfo();
        errorSecond.printInfo();
        errorThird.printInfo();
    }
}
