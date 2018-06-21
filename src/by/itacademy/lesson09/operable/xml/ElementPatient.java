package by.itacademy.lesson09.operable.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ElementPatient {
    Document doc;

    public ElementPatient(Document doc) {
        this.doc = doc;
    }

    public Element create(String[] properties) {
        Element patient = doc.createElement("Patient");
        String[] tags = {"Name", "Surname", "Birth", "Status"};
        for (int i = 0; i < tags.length; i++) {
            patient.appendChild(execute(tags[i], properties[i]));
        }
        return patient;
    }

    private Element execute(String tag, String value) {
        Element element = doc.createElement(tag);
        element.setTextContent(value);
        return element;
    }
}
