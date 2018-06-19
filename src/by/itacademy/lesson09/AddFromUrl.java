package by.itacademy.lesson09;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddFromUrl implements Operable {
    private static final Logger LOGGER = Logger.getLogger(AddFromUrl.class.getName());
    URL urlRegistry;

    {
        try {
            urlRegistry = new URL("https://github.com/PManenok/Java-Lesson09-Text.git");
        } catch (MalformedURLException e) {
            LOGGER.log(Level.SEVERE, "Url Exception", e);
        }
    }

    @Override
    public void operation(Registry registry) {
        try {
            HttpURLConnection urlCon = (HttpURLConnection) urlRegistry.openConnection();
            System.out.println("Метод запроса: " + urlCon.getRequestMethod());
            System.out.println("Ответное сообщение: " + urlCon.getResponseMessage());
            Map<String, List<String>> myMap = urlCon.getHeaderFields();
            Set<String> myField = myMap.keySet();
            System.out.println("\nДалее следует заголовок:");
            for (String k : myField) {
                System.out.println("Ключ: " + k + " Значение: "
                        + myMap.get(k));
            }
            urlCon.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
