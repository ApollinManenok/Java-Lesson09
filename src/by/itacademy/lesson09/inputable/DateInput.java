package by.itacademy.lesson09.inputable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateInput implements Inputable<LocalDate> {
    private DateTimeFormatter format;

    public DateInput(DateTimeFormatter format) {
        this.format = format;
    }

    @Override
    public LocalDate input() {
        String date = new Scanner(System.in).nextLine();
        return LocalDate.parse(date, format);
    }
}
