package ru.job4j.oop;

public class Bus implements Vehicle {
    private String name;

    public Bus(String name) {
        this.name = name;
    }

    public void move() {
        System.out.println("Едет по шоссе");
    }

    public void refuel() {
        System.out.println("Заправляется бензином");
    }

    @Override
    public String toString() {
        return name;
    }
}
