
import java.io.FileReader;
import java.io.IOException;
import driver.Driver;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class readFile {
    WebDriver driver = Driver.webDriver;

    Demo_Action demo = new Demo_Action(driver);

    public readFile(WebDriver driver) {
        this.driver = driver;
    }

    public void readJson(String fileDataPrepare, String fileDataTestCase) throws InterruptedException {
        {
            JSONParser par = new JSONParser();
            try {
                //read file json
                JSONArray dataPrepare = (JSONArray) par.parse(new FileReader(fileDataPrepare));
                JSONArray dataTestCase = (JSONArray) par.parse(new FileReader(fileDataTestCase));

                for (int i = 0 ; i < dataTestCase.size() ; i++){
                    JSONObject fieldTest = (JSONObject) dataTestCase.get(i);
                    String action = (String) fieldTest.get("action");
                    String selector = (String) fieldTest.get("selector");
                    JSONArray arrDataTest = (JSONArray) fieldTest.get("data");
                    for (int j = 0 ; j < arrDataTest.size(); j++){
                        this.prepareFormData(dataPrepare, selector);
                        JSONObject data = (JSONObject) arrDataTest.get(j);
                        String value = (String) data.get("value");
                        String message = (String) data.get("assert");

                        switch (action) {
                            case "input":
                                demo.Input(selector, value);
                                break;
                            case "select":
                                demo.Select(selector, value);
                                break;
                            case "check":
                                demo.check(selector);
                                break;
                        }
                        driver.findElement(By.cssSelector("button[type='submit']")).click();
                        Assert.assertTrue(driver.getPageSource().contains(message));
                        Thread.sleep(5000);
                        driver.get("http://methadone2.cloudapp.net/main/patients/new");
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

    public void prepareFormData(JSONArray data, String selectorIgnore ) throws InterruptedException{
        for(int i = 0; i < data.size(); i++) {
            JSONObject jsonObject = (JSONObject) data.get(i);
            String action = (String) jsonObject.get("action");
            String selector = (String) jsonObject.get("selector");
            String value = (String) jsonObject.get("data");
            if (!selector.equals(selectorIgnore)) {
                switch (action) {
                    case "input":
                        demo.Input(selector, value);
                        break;
                    case "select":
                        demo.Select(selector, value);
                        break;
                    case "check":
                        demo.check(selector);
                        break;
                }
            }
        }
    }
}
