package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;
    public Error(boolean active,int status,String message){
        this.active = active;
        this.status = status;
        this.message = message;
    }
    public Error(){
    }
    public void errorLog(){
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error error01 = new Error(true , 1, "kek");
        error01.errorLog();
        Error error02 = new Error(false , 2, "lol");
        error02.errorLog();
        Error error03 = new Error(false , 3, "lolkek");
        error03.errorLog();
        Error error322 = new Error();
        error322.errorLog();
    }
}
