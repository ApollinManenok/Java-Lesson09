package by.itacademy.lesson09.domain;

import java.time.format.DateTimeFormatter;

public class PatientDateFormat {
    public static final PatientDateFormat INSTANCE = new PatientDateFormat();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");

    public DateTimeFormatter format() {
        return formatter;
    }

}
