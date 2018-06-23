package by.itacademy.lesson09.operable.serialization.xml;

import by.itacademy.lesson09.domain.Patient;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.Set;

public class PatientHandler extends DefaultHandler {
    private Set<Patient> patients = new HashSet<>();
    private String[] properties = new String[4];
    private boolean name = false;
    private boolean surname = false;
    private boolean birth = false;
    private boolean status = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("NAME"))
            name = true;
        else if (qName.equalsIgnoreCase("SURNAME"))
            surname = true;
        else if (qName.equalsIgnoreCase("BIRTH"))
            birth = true;
        else if (qName.equalsIgnoreCase("STATUS"))
            status = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("NAME"))
            name = false;
        else if (qName.equalsIgnoreCase("SURNAME"))
            surname = false;
        else if (qName.equalsIgnoreCase("BIRTH"))
            birth = false;
        else if (qName.equalsIgnoreCase("STATUS"))
            status = false;
        else if (qName.equalsIgnoreCase("PATIENT"))
            patients.add(new Patient(properties));
    }

    @Override
    public void characters(char ch[], int start, int length) {
        if (name)
            properties[0] = new String(ch, start, length);
        else if (surname)
            properties[1] = new String(ch, start, length);
        else if (birth)
            properties[2] = new String(ch, start, length);
        else if (status)
            properties[3] = new String(ch, start, length);
    }

    public Set<Patient> getPatients() {
        return patients;
    }
}
