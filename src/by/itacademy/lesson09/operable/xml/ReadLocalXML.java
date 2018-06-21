package by.itacademy.lesson09.operable.xml;

import by.itacademy.lesson09.Patient;
import by.itacademy.lesson09.Registry;
import by.itacademy.lesson09.operable.BaseRegistryOperation;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadLocalXML extends BaseRegistryOperation {
    private static final Logger LOGGER = Logger.getLogger(ReadLocalXML.class.getName());
    private File local;

    public ReadLocalXML(Registry registry, String source) {
        super(registry);
        local = new File(source);
    }

    @Override
    public void operation() {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(local);
            NodeList patients = document.getDocumentElement().getChildNodes();
            for (int i = 0; i < patients.getLength(); i++) {
                registry.addPatient(new Patient(getStrProperties(patients.item(i))));
            }
        } catch (SAXException | ParserConfigurationException | IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        } catch (DateTimeParseException | InputMismatchException e) {
            LOGGER.log(Level.SEVERE, "Wrong patient info from file " + local, e);
        }
    }

    private String[] getStrProperties(Node patient) {
        NodeList properties = patient.getChildNodes();
        String[] strProperties = new String[4];
        for (int j = 0; j < properties.getLength(); j++) {
            strProperties[j] = properties.item(j).getTextContent();
        }
        return strProperties;
    }

    @Override
    public String typo() {
        return "Read patients info from local XML file";
    }
}
