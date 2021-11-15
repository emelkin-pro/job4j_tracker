package ru.job4j.oop;

public class Surgeon extends Doctor {
    private boolean isKnowHumansOrgans;

    public PatientsHeart healPatientHeart(PatientsHeart sickPatientsHeart){
        PatientsHeart HealthPatientsHeart = new PatientsHeart();
        return HealthPatientsHeart;
    }

    public Surgeon(String name, String surname,String education,String birthday,String numberOfDoctorLicense){
        super(name, surname, education, birthday, numberOfDoctorLicense);
        this.isKnowHumansOrgans = isKnowHumansOrgans;
    }
}
