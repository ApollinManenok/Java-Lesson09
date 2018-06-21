package by.itacademy.lesson09;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintPatients extends BaseRegistryOperation {
    private static final Logger LOGGER = Logger.getLogger(PrintPatients.class.getName());
    public PrintPatients(Registry registry) {
        super(registry);
    }

    @Override
    public void operation() {
        for (Patient element : registry) {
            System.out.println(element);
        }
        waiting();
    }

    private void waiting() {
        try {
            TimeUnit.SECONDS.sleep(5); // instead of sleepSec
        } catch (InterruptedException e) {
            LOGGER.log(Level.INFO, "Something interrupted", e);
        }
    }

    @Override
    public String typo() {
        return "Print all patients";
    }
}
