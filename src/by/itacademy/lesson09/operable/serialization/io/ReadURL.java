package by.itacademy.lesson09.operable.serialization.io;

import by.itacademy.lesson09.domain.Patient;
import by.itacademy.lesson09.domain.Registry;
import by.itacademy.lesson09.operable.serialization.UploadPatients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadURL extends UploadPatients {
    private static final Logger LOGGER = Logger.getLogger(ReadURL.class.getName());

    public ReadURL(Registry registry, String source) {
        super(registry, source);
    }

    @Override
    public void operation() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                registry.addPatient(new Patient(line));
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        } catch (DateTimeParseException | InputMismatchException e) {
            LOGGER.log(Level.SEVERE, "Wrong patient info from source " + source, e);
        }
    }

    @Override
    public String typo() {
        return "Read patients info from URL";
    }
}
