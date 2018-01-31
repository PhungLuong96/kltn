package integration;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import driver.Driver;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.EnterAction;

public class ReadFile {
    WebDriver driver = Driver.webDriver;
    EnterAction demo = new EnterAction(driver);

    public ReadFile(WebDriver driver) {
        this.driver = driver;
    }
    public int getRandomInt(int min,int max) {
       Random rd = new Random();
       int range = max - min + 1;
       int randomNum = min + rd.nextInt(range);
       return randomNum;
    }
    String numRandom = String.valueOf(getRandomInt(1,999));
    public void executeFile(String fileDataPrepare, String fileDataTestCase, String url) throws InterruptedException {
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
                        //enter prepare data
                        prepareFormData(dataPrepare, selector);
                        //enter test data
                        JSONObject data = (JSONObject) arrDataTest.get(j);
                        String value = (String) data.get("value");
                        String message = (String) data.get("assert");

                        switch (action) {
                            case "input":
                                demo.input(selector, value);
                                break;
                            case "select":
                                demo.select(selector, value);
                                break;
                            case "check":
                                demo.check(selector);
                                break;
                        }
                        driver.findElement(By.cssSelector("button[type='submit']")).click();
                        Thread.sleep(3000);
                        Assert.assertTrue(driver.getPageSource().contains(message));
                        Thread.sleep(3000);
                        //load lại trang ban đầu để thực hiện testcase tiếp theo
                        driver.get(url);
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
        JSONObject option = (JSONObject)data.get(0);
        String madal = (String)option.get("madal");
        if(!madal.equals("")){
            driver.findElement(demo.getBy(madal)).click();
        }
        Thread.sleep(2000);
        for(int i = 1; i < data.size(); i++) {
            JSONObject jsonObject = (JSONObject) data.get(i);
            String action = (String) jsonObject.get("action");
            String selector = (String) jsonObject.get("selector");
            String value = (String) jsonObject.get("data");
            if (!selector.equals(selectorIgnore)) {
                switch (action) {
                    case "input":
                        demo.input(selector, value);
                        break;
                    case "inputRandom":
                        demo.input(selector, value + numRandom);
                        break;
                    case "select":
                        demo.select(selector, value);
                        break;
                    case "check":
                        demo.check(selector);
                        break;
                }
            }
        }
    }
}
