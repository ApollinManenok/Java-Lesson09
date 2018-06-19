package by.itacademy.lesson09;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Registry implements Iterable<Patient> {
    private Set<Patient> patients;

    public Registry() {
        this.patients = new TreeSet<Patient>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }


    @Override
    public String toString() {
        return "Registry{" +
                "patients=" + patients +
                '}';
    }

    @Override
    public Iterator<Patient> iterator() {
        return patients.iterator();
    }
}
