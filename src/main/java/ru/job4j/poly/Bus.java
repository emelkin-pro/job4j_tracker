package ru.job4j.poly;

public class Bus implements Transport{
    private int passengers ;
    private float fuel;
    private boolean drive = false;

    @Override
    public void drive() {
        drive = !drive;
    }

    @Override
    public void passengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public float refuel(float fuel) {
        this.fuel = fuel;
        return fuel * 1.5f;
    }
}
