package by.itacademy.lesson09;

import java.time.LocalDate;
import java.util.Scanner;

public class DateInput implements Inputable<LocalDate> {
    //private Scanner scan = new Scanner(System.in);

    @Override
    public LocalDate input() {
        String date = new Scanner(System.in).nextLine();//exceptions!!
        return LocalDate.parse(date, Patient.formatter);
    }
}
