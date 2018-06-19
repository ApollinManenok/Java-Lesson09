package by.itacademy.lesson09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            urlRegistry = new URL("https://raw.githubusercontent.com/PManenok/Java-Lesson09-Text/master/Registry.txt");
        } catch (MalformedURLException e) {
            LOGGER.log(Level.SEVERE, "Url Exception", e);
        }
    }

    @Override
    public void operation(Registry registry) {
        try {
            HttpURLConnection urlCon = (HttpURLConnection) urlRegistry.openConnection();
            //urlCon.setRequestMethod("GET");
            //urlCon.setReadTimeout(15 * 1000);
            urlCon.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
            StringBuilder strBuild = new StringBuilder();
            String str;
            while ((str = reader.readLine()) != null) {
                strBuild.append(str + "\n");
            }
            System.out.println(strBuild.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
