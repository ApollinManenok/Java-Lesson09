package by.itacademy.lesson09;

import java.time.LocalDate;
import java.util.Scanner;

public class DateInput implements Inputable<LocalDate> {
    @Override
    public LocalDate input() {
        String date = new Scanner(System.in).nextLine();
        return LocalDate.parse(date, Patient.formatter);
    }
}
