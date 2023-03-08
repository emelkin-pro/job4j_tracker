package ru.job4j.oop;

public class Programmer extends Engineer {
    private boolean isKnowJavaLanguage;

    public Programmer(String name, String surname,
                      String education, String birthday,
                      boolean isKnowHowToRepairPrinter, boolean isKnowJavaLanguage) {
        super(name, surname, education, birthday, isKnowHowToRepairPrinter);
        this.isKnowJavaLanguage = isKnowJavaLanguage;
    }

    public Magic makeMagic(Nothin someNothin) {
        Magic trueMagic = new Magic();
        return trueMagic;
    }
}
