package ru.job4j.oop;

public class Battery {
    private int load;
    public void exchange(Battery another){
        another.load = this.load + another.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery();
        Battery second = new Battery();
        first.load = 100;
        first.exchange(second);
        System.out.println("first :" + first.load + " second:" + second.load);
    }
}
