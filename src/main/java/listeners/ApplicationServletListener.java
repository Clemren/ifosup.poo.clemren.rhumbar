package listeners;

import com.mysql.cj.xdevapi.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ApplicationServletListener implements ServletContextListener {
    private static String countries;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String countriesString = null;
        try {
            countriesString = new String(Files.readAllBytes(Paths.get(servletContextEvent.getServletContext().getContextPath() +"/data/countries.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject obj = new JSONObject(countriesString);


    }

    public static String getCountries(){
        return countries;
    }
}