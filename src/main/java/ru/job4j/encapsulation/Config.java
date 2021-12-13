package ru.job4j.encapsulation;

public class Config {
    private String name; //4
    private int position; // 1
    private String[] properties; // 2

    public void Config(String name) { // тут же , вроде , void Должен быть, метод же ничего не возвращает, но почем IDEA не ругалась ?)
        this.name = name;
    }

    public void print() { // 3
        System.out.println(position);
    }

    public String getProperty(String key) {
        return search(key);
    }

    private String search(String key) {
        return key;
    }
}