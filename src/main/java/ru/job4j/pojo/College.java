package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Троценко Дмитрий Анатольевич");
        student.setGroupName("ГМФ 1-2");
        student.setDateOfEnrollment("20 августа 2016 г.");
        System.out.println("ФИО студента: " + student.getFullName()
                + "\nНазвание группы: " + student.getGroupName()
                + "\nДата поступления: " + student.getDateOfEnrollment());

    }
}
