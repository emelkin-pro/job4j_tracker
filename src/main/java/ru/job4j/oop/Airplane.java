package ru.job4j.oop;

public class Airplane implements Vehicle{
    private String name;

    public void move(){
        System.out.println("Летит в небе");
    }
    public void refuel(){
        System.out.println("Заправляется самолетным топлевом");
    }

    public Airplane(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
