package ru.job4j.oop;

public class Builder extends Engineer {
    private boolean isKnowStrengthOfMaterials;

    public Builder(String name, String surname, String education, String birthday,
                   boolean isKnowHowToRepairPrinter, boolean isKnowStrengthOfMaterials) {
        super(name, surname, education, birthday, isKnowHowToRepairPrinter);
        this.isKnowStrengthOfMaterials = isKnowStrengthOfMaterials;
    }

    public House buildHouse(Brick bricks) {
        House newHouse = new House();
        return newHouse;
    }

}
