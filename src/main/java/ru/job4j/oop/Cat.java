package ru.job4j.oop;

public class Cat {

    private String food;
    private String nickName;

    public void show() {
        System.out.println(this.food);
        System.out.println(this.nickName);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    private void giveNick(String nick) {
        this.nickName = nick;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("kotleta");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();
    }
}