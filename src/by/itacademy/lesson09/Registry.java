package by.itacademy.lesson09;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Registry implements Iterable<Patient> {
    private Set<Patient> patients = new HashSet<>();

    public void addPatient(Patient patient) {
        patients.remove(patient);
        patients.add(patient);
    }

    @Override
    public String toString() {
        return "Patients:\n" + patients;
    }

    @Override
    public Iterator<Patient> iterator() {
        return patients.iterator();
    }
}
