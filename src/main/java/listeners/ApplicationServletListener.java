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
import java.util.Properties;

public class ApplicationServletContextListener implements ServletContextListener {
    private static String countries;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        try (FileReader reader = new FileReader(servletContextEvent.getServletContext()+ "/data/countries.json"))
        {
            JsonParser jsonParser = new JSONParser();
            //Read JSON file
            Object obj = jsonParser.pa(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);

            //Iterate over employee array
            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject obj = new JSONObject(jsonString);
        properties.load(new FileInputStream(cfgfile));
        //Some code..
        properties.getProperty("dbUser");
    }

    public static Properties getCountries(){
        return properties;
    }
}