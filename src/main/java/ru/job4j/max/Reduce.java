package ru.job4j.max;

public class Reduce {
    private int[] mainArray;

    public void to(int[] array) {
        mainArray = array;
    }

    public void print() {
        for (int index = 0; index < mainArray.length; index++) {
            System.out.println(mainArray[index]);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(array);
        reduce.print();
    }
}