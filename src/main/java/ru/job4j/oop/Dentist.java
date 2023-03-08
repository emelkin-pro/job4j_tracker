package ru.job4j.oop;

public class Dentist extends Doctor {
    private boolean isKnowHumansTeeth;

    public Dentist(String name, String surname, String education,
                   String birthday, String numberOfDoctorLicense, boolean isKnowHumansTeeth) {
        super(name, surname, education, birthday, numberOfDoctorLicense);
        this.isKnowHumansTeeth = isKnowHumansTeeth;
    }

    public PatientsTooth healBadTooth(PatientsTooth patientsBadTooth) {
        PatientsTooth patientsHealthTooth = new PatientsTooth();
        return patientsHealthTooth;
    }
}
