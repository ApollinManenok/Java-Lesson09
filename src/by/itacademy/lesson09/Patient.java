package by.itacademy.lesson09;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Patient implements Comparable<Patient> {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
    private String name;
    private String surname;
    private LocalDate birth;
    private boolean status;

    public Patient(String name, String surname, LocalDate birth, boolean status) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.status = status;

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public int compareTo(Patient another) {
        int result = name.compareTo(another.name);
        if (result != 0) {
            return result;
        }
        result = surname.compareTo(another.surname);
        if (result != 0) {
            return result;
        }
        return birth.compareTo(another.birth);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birth=" + birth +
                ", status=" + status +
                '}';
    }
}
