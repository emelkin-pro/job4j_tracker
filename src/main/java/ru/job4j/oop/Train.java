package ru.job4j.oop;

public class Train implements Vehicle {
    private String name;

    public void move() {
        System.out.println("Едет по рельсам");
    }

    public void refuel() {
        System.out.println("Заправляется охапкой дров");
    }

    public Train(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
