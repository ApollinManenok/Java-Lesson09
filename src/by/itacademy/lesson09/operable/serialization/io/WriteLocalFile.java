package by.itacademy.lesson09.operable.serialization.io;

import by.itacademy.lesson09.domain.Patient;
import by.itacademy.lesson09.domain.Registry;
import by.itacademy.lesson09.operable.serialization.WritePatients;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteLocalFile extends WritePatients {
    private static final Logger LOGGER = Logger.getLogger(WriteLocalFile.class.getName());

    public WriteLocalFile(Registry registry, String source) {
        super(registry, source);
    }

    @Override
    public void operation() {
        try (DataOutputStream writeLocalFile = new DataOutputStream(new FileOutputStream(file))) {
            for (Patient element : registry) {
                writeLocalFile.writeUTF(makeStr(element));
            }
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Can't find file " + file, e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Can't write to file " + file, e);
        }
    }

    private String makeStr(Patient patient) {
        LocalDate date = patient.getBirth();
        String dateStr = String.valueOf(date.getDayOfMonth()) + "." +
                String.valueOf(date.getMonthValue()) + "." +
                String.valueOf(date.getYear());
        return patient.getName() + ";" + patient.getSurname() + ";" + dateStr + ";" + String.valueOf(patient.isStatus()) + "\n";
    }

    @Override
    public String typo() {
        return "Write patients info into local file";
    }
}
