package by.itacademy.lesson09.operable.iostream;

import by.itacademy.lesson09.Patient;
import by.itacademy.lesson09.Registry;
import by.itacademy.lesson09.operable.BaseRegistryOperation;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadLocalFile extends BaseRegistryOperation {
    private static final Logger LOGGER = Logger.getLogger(ReadLocalFile.class.getName());
    private File local;

    public ReadLocalFile(Registry registry, String source) {
        super(registry);
        local = new File(source);
    }

    @Override
    public void operation() {
        try {
            DataInputStream readLocalFile = new DataInputStream(new FileInputStream(local));
            String line = "";
            while (!(line = readLocalFile.readUTF()).equals("")) {
                line = line.substring(0, line.length() - 1);
                registry.addPatient(new Patient(line));
            }
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Can't find file " + local, e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Can't read line from file " + local, e);
        } catch (DateTimeParseException | InputMismatchException e) {
            LOGGER.log(Level.SEVERE, "Wrong patient info from file " + local, e);
        }
    }

    @Override
    public String typo() {
        return "Read patients info from local file";
    }
}
