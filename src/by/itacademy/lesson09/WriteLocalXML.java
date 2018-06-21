package by.itacademy.lesson09;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteLocalXML extends BaseRegistryOperation {
    private static final Logger LOGGER = Logger.getLogger(WriteLocalFile.class.getName());
    private File file;
    private Document document;

    public WriteLocalXML(Registry registry, String source) {
        super(registry);
        this.file = new File(source);
    }

    @Override
    public void operation() {
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Node root = document.createElement("Registry");
            document.appendChild(root);
            for (Patient element : registry) {
                root.appendChild(createPatient(element.getProperties()));
            }
            writeDoc();
        } catch (ParserConfigurationException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private Element createPatient(String[] properties) {
        Element patient = document.createElement("Patient");
        Element[] elements = {document.createElement("Name"), document.createElement("Surname"),
                document.createElement("Birth"), document.createElement("Status")};
        for (int i = 0; i < elements.length; i++) {
            elements[i].setTextContent(properties[i]);
            patient.appendChild(elements[i]);
        }
        return patient;
    }

    private void writeDoc() {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileOutputStream(file));
            transformer.transform(source, result);
        } catch (TransformerException | FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @Override
    public String typo() {
        return "Write patients info into local XML file";
    }
}
