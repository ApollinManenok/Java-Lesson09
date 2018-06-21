package by.itacademy.lesson09.operable.xml;

import by.itacademy.lesson09.Registry;
import by.itacademy.lesson09.operable.BaseRegistryOperation;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ReadRemoteStAX extends BaseRegistryOperation {
    private String source;

    public ReadRemoteStAX(Registry registry, String source) {
        super(registry);
        this.source = source;
    }

    @Override
    public void operation() {
        try {
            InputStream xmlSource = new BufferedInputStream(new URL(source).openConnection().getInputStream());
            XMLStreamReader xmlReader = XMLInputFactory.newInstance().createXMLStreamReader(xmlSource);
            while(xmlReader.hasNext()){
                xmlReader.next();
                if(xmlReader.isStartElement() && xmlReader.getLocalName().equalsIgnoreCase("NAME")) {

                }
            }
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String typo() {
        return null;
    }
}
