package by.itacademy.lesson09;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleAddPatient extends BaseRegistryOperation {
    private static final Logger LOGGER = Logger.getLogger(ConsoleAddPatient.class.getName());

    public ConsoleAddPatient(Registry registry) {
        super(registry);
    }

    @Override
    public void operation() {
        try {
            String name = new Insert<>(new StringInput()).get("Enter patient name");
            String surname = new Insert<>(new StringInput()).get("Enter patient surname");
            LocalDate birth = new Insert<>(new DateInput()).get("Enter patient date of birth");
            Boolean status = new Insert<>(new BoolInput()).get("Enter patient status");
            registry.addPatient(new Patient(name, surname, birth, status));
        }catch (DateTimeParseException | InputMismatchException e){
            LOGGER.log(Level.SEVERE, "Can't add patient with wrong data", e);
        }
    }

    @Override
    public String typo() {
        return "Adding patient from console";
    }
}
