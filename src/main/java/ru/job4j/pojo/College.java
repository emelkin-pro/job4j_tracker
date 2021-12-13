package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Емельянов Олег");
        student.setGroup("БИ211");
        student.setDateOfAdmission(new Date());

        System.out.println("Студент: " + student.getFio() + " Зачислен в группу " + student.getGroup() + ", дата зачисления: " + student.getDateOfAdmission());
    }
}
