package ru.job4j.tracker;
import java.time.LocalDateTime;

public class Item {
    private int id;
    private int oldID;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Item(){
    }

    public Item(String name){
        this.name = name;
    }

    public Item(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated(){
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public int getOldID() {
        return oldID;
    }

    public void setOldID(int oldID) {
        this.oldID = oldID;
    }
}