package by.itacademy.lesson09;

import by.itacademy.lesson09.domain.Registry;
import by.itacademy.lesson09.inputable.Insert;
import by.itacademy.lesson09.inputable.IntegerInput;
import by.itacademy.lesson09.operable.ConsoleAddPatient;
import by.itacademy.lesson09.operable.Operable;
import by.itacademy.lesson09.operable.PrintPatients;
import by.itacademy.lesson09.operable.serialization.io.ReadLocalFile;
import by.itacademy.lesson09.operable.serialization.io.ReadURL;
import by.itacademy.lesson09.operable.serialization.io.WriteLocalFile;
import by.itacademy.lesson09.operable.serialization.xml.ReadLocalXML;
import by.itacademy.lesson09.operable.serialization.xml.ReadRemoteXML;
import by.itacademy.lesson09.operable.serialization.xml.WriteLocalXML;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {
    private static final Logger LOGGER = Logger.getLogger(Menu.class.getName());
    private ArrayList<Operable> operations = new ArrayList<>();
    private Registry registry = new Registry();
    private String sourceURL = "https://raw.githubusercontent.com/PManenok/Java-Lesson09-Text/master/Registry.txt";
    private String remoteXML = "https://raw.githubusercontent.com/PManenok/Java-Lesson09-Text/master/Patients.xml";
    private String localFile = "data.bin";
    private String localXML = "patients.xml";

    {
        operations.add(new PrintPatients(registry));
        operations.add(new ConsoleAddPatient(registry));
        operations.add(new ReadLocalFile(registry, localFile));//read from local file
        operations.add(new WriteLocalFile(registry, localFile)); //save to local file
        operations.add(new ReadURL(registry, sourceURL)); //add from Url
        operations.add(new ReadLocalXML(registry, localXML));//read from local XML file
        operations.add(new WriteLocalXML(registry, localXML)); //save to local XML file
        operations.add(new ReadRemoteXML(registry, remoteXML)); //add from remote XML
    }

    public void list() {
        boolean term = true;
        while (term) {
            System.out.println("Registry menu:\n0. Exit");
            for (int i = 0; i < operations.size(); i++) {
                System.out.println((i + 1) + ". " + operations.get(i).typo());
            }
            try {
                int index = new Insert<>(new IntegerInput()).get("Enter option number");
                term = operate(index);
            } catch (InputMismatchException | RangeException e) {
                LOGGER.log(Level.WARNING, e.getMessage(), e);
            }
        }
    }

    private boolean operate(int index) throws RangeException {
        if (index < 0 || index > this.operations.size())
            throw new RangeException("Option out of list range");
        else if (index == 0)
            return false;
        index -= 1;
        operations.get(index).operation();
        return true;
    }
}
