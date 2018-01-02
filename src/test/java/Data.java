import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import driver.Driver;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

public class Data {
    WebDriver driver = Driver.webDriver;

    Demo_Action demo = new Demo_Action(driver);

    public Data(WebDriver driver) {
        this.driver = driver;
    }

    public void ReadJson() throws InterruptedException {
        {
            JSONParser par = new JSONParser();
            try {
                JSONArray jsonArray = (JSONArray) par.parse(new FileReader("C:\\Users\\luong96\\IdeaProjects\\Demo_KLTN\\src\\test\\java\\abc.json"));
                for(int i = 0; i < jsonArray.size();i++){
                    JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                    String selector = (String)jsonObject.get("selector");
                    String action = (String)jsonObject.get("action");
                    String data = (String)jsonObject.get("data");
                    switch (action) {
                        case "input":
                            demo.Input(selector, data);
                        case "selector":
                            demo.Select(selector, data);
                        case "check":
                            demo.check(selector);
                    }
                }
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }
            catch (ParseException e1) {
                e1.printStackTrace();
            }
        }
    }
}
