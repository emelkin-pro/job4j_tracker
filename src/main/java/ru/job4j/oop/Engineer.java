package ru.job4j.oop;

public class Engineer extends Profession {
    private boolean isKnowLinux;
    private boolean isKnowHowToRepairPrinter;

    public Engineer(String name, String surname, String education,
                    String birthday, boolean isKnowHowToRepairPrinter) {
        super(name, surname, education, birthday);
        this.isKnowHowToRepairPrinter = isKnowHowToRepairPrinter;
    }

    public boolean getIsKnowLinux() {
        return isKnowLinux;
    }

    public boolean getIsKnowHowToRepairPrinter() {
        return isKnowHowToRepairPrinter;
    }

    public boolean setIsKnowLinux() {
        return isKnowLinux;
    }

    public boolean setIsKnowHowToRepairPrinter() {
        return isKnowHowToRepairPrinter;
    }

    public boolean repairPC() {
        return true;
    }

    public boolean repairPC(boolean knowLinux) {
        return true;
    }

    public boolean repairPC(boolean knowLinux, boolean knowHowToRepairPrinter) {
        return true;
    }
}
