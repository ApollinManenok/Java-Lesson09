package by.itacademy.lesson09.operable.xml;

import by.itacademy.lesson09.Patient;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.Set;

public class PatientHandler extends DefaultHandler {
    Set<Patient> patients = new HashSet<>();
    String[] properties;


    boolean name = false;
    boolean surname = false;
    boolean birth = false;
    boolean status = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws
            SAXException {
        if (qName.equalsIgnoreCase("NAME")) {
            name = true;
        } else if (qName.equalsIgnoreCase("SURNAME")) {
            surname = true;
        } else if (qName.equalsIgnoreCase("BIRTH")) {
            birth = true;
        } else if (qName.equalsIgnoreCase("STATUS")) {
            status = true;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (name) {
            properties[0] = new String(ch, start, length);
        } else if (surname) {
            properties[1] = new String(ch, start, length);
        } else if (birth) {
            properties[2] = new String(ch, start, length);
        } else if (status) {
            properties[3] = new String(ch, start, length);
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("NAME")) {
            name = false;
        } else if (qName.equalsIgnoreCase("SURNAME")) {
            surname = false;
        } else if (qName.equalsIgnoreCase("BIRTH")) {
            birth = false;
        } else if (qName.equalsIgnoreCase("STATUS")) {
            status = false;
        }
    }
}
