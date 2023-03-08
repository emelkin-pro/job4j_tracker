package ru.job4j.oop;

public class VehicleUsages {
    public static void main(String[] args) {
        Vehicle firstBus = new Bus("firstBus");
        Vehicle secondBus = new Bus("secondBus");
        Vehicle thirdBus = new Bus("thirdBus");

        Vehicle firstTrain = new Train("firstTrain");
        Vehicle secondTrain = new Train("secondTrain");
        Vehicle thirdTrain = new Train("thirdTrain");

        Vehicle firstAirplane = new Airplane("firstAirplane");
        Vehicle secondAirplane = new Airplane("secondAirplane");
        Vehicle thirdAirplane = new Airplane("thirdAirplane");

        Vehicle[] vehicles = new Vehicle[]{
                firstBus, secondBus, thirdBus,
                firstTrain, secondTrain, thirdTrain,
                firstAirplane, secondAirplane, thirdAirplane
        };
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
            vehicle.move();
            vehicle.refuel();
        }
    }
}
