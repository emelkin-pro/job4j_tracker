package ru.job4j.oop;

public class Doctor extends Profession{
    private String numberOfDoctorLicense;
    private boolean isKnowHumanBody;
    private boolean isKnowIllness;

    public boolean getIsKnowHumanBody (){
        return isKnowHumanBody;
    }
    public boolean getIsKnowIllness (){
        return isKnowIllness;
    }

    public boolean setIsKnowHumanBody (){
        return isKnowHumanBody;
    }
    public boolean setIsKnowIllness (){
        return isKnowIllness;
    }

    public boolean canHealPeople (){
        return true;
    }
    public Doctor(String name, String surname,String education,String birthday,String numberOfDoctorLicense){
        super(name, surname, education, birthday);
        this.numberOfDoctorLicense = numberOfDoctorLicense;
    }
}
