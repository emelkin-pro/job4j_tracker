package ru.job4j.oop;

public class Surgeon extends Doctor {
    private boolean isKnowHumansOrgans;

    public Surgeon(String name, String surname, String education,
                   String birthday, String numberOfDoctorLicense) {
        super(name, surname, education, birthday, numberOfDoctorLicense);
        this.isKnowHumansOrgans = isKnowHumansOrgans;
    }

    public PatientsHeart healPatientHeart(PatientsHeart sickPatientsHeart) {
        PatientsHeart healthPatientsHeart = new PatientsHeart();
        return healthPatientsHeart;
    }
}
