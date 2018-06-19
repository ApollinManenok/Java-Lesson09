package by.itacademy.lesson09;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class AddingPatient implements Operable {
    @Override
    public void operation(Registry registry) {
        String name = new Insert<>(new StringInput()).get("Enter patient name");
        String surname=  new Insert<>(new StringInput()).get("Enter patient surname");
        LocalDate birth= new Insert<>(new DateInput()).get("Enter patient date of birth");
        Date date = Date.valueOf(birth);
        System.out.println(date);
        Boolean status= new Insert<>(new BoolInput()).get("Enter patient status");
        registry.addPatient(new Patient(name, surname, birth, status));
    }
}
