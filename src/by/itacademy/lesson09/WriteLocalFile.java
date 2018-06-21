package by.itacademy.lesson09;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteLocalFile extends BaseRegistryOperation {
    private static final Logger LOGGER = Logger.getLogger(WriteLocalFile.class.getName());
    private File local;

    public WriteLocalFile(Registry registry, String source) {
        super(registry);
        local = new File(source);
    }

    @Override
    public void operation() {
        try (DataOutputStream writeLocalFile = new DataOutputStream(new FileOutputStream(local))) {
            for (Patient element : registry) {
                writeLocalFile.writeUTF(makeStr(element));
            }
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Can't find file " + local, e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Can't write to file " + local, e);
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
