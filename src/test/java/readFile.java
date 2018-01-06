
import java.io.FileReader;
import java.io.IOException;
import driver.Driver;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

public class readFile {
    WebDriver driver = Driver.webDriver;

    Demo_Action demo = new Demo_Action(driver);

    public readFile(WebDriver driver) {
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
                        case "nhap":
                            demo.Input(selector, data);
                            break;
                        case "chon":
                            demo.Select(selector, data);
                            break;
                        case "check":
                            demo.check(selector);
                            break;
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
