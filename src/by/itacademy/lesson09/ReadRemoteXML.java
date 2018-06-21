package by.itacademy.lesson09;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadRemoteXML extends BaseRegistryOperation {
    private static final Logger LOGGER = Logger.getLogger(ReadURL.class.getName());
    private String source;
    private String[] properties = new String[4];

    public ReadRemoteXML(Registry registry, String source) {
        super(registry);
        this.source = source;
    }

    @Override
    public void operation() {
        try {
            InputStream remote = new BufferedInputStream(new URL(source).openConnection().getInputStream());
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
                boolean name = false;
                boolean surname = false;
                boolean birth = false;
                boolean status = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
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
                        name = false;
                    } else if (surname) {
                        properties[1] = new String(ch, start, length);
                        surname = false;
                    } else if (birth) {
                        properties[2] = new String(ch, start, length);
                        birth = false;
                    } else if (status) {
                        properties[3] = new String(ch, start, length);
                        registry.addPatient(new Patient(properties));
                        status = false;
                    }
                }
            };
            saxParser.parse(remote, handler);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        } catch (DateTimeParseException | InputMismatchException e) {
            LOGGER.log(Level.SEVERE, "Wrong patient info from source " + source, e);
        }
    }

    @Override
    public String typo() {
        return "Read patients info from remote XML file";
    }
}
