package ru.job4j.oop;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private String birthday;

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getEducation(){
        return education;
    }
    public String getBirthday(){
        return birthday;
    }

    public String setName(){
        return name;
    }
    public String setSurname(){
        return surname;
    }
    public String setEducation(){
        return education;
    }
    public String setBirthday(){
        return birthday;
    }

    public Profession(String name, String surname,String education,String birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public Profession() {
    }
}
