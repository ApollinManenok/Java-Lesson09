package by.itacademy.lesson09.operable.serialization.io;

import by.itacademy.lesson09.domain.Patient;
import by.itacademy.lesson09.domain.Registry;
import by.itacademy.lesson09.operable.serialization.ReadPatients;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadLocalFile extends ReadPatients {
    private static final Logger LOGGER = Logger.getLogger(ReadLocalFile.class.getName());

    public ReadLocalFile(Registry registry, String source) {
        super(registry, source);
    }

    @Override
    public void operation() {
        try {
            DataInputStream readLocalFile = new DataInputStream(new FileInputStream(file));
            String line = "";
            while (!(line = readLocalFile.readUTF()).equals("")) {
                line = line.substring(0, line.length() - 1);
                registry.addPatient(new Patient(line));
            }
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Can't find file " + file, e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Can't read line from file " + file, e);
        } catch (DateTimeParseException | InputMismatchException e) {
            LOGGER.log(Level.SEVERE, "Wrong patient info from file " + file, e);
        }
    }

    @Override
    public String typo() {
        return "Read patients info from local file";
    }
}
