package integration;

import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.*;
import java.io.FileReader;
import java.io.IOException;

public class EditName {
    WebDriver driver = Driver.webDriver;
    EnterAction enter = new EnterAction();
    CheckSelector chkSelector = new CheckSelector();
    @Step("Check edit value of Name field <fileEditName> and <url>")
    public void checkEditName(String fileEditName, String url) throws InterruptedException {
        Thread.sleep(2000);
        driver.get(url);
        Thread.sleep(2000);
        JSONParser par = new JSONParser();
        try {
            JSONArray data = (JSONArray)par.parse(new FileReader(fileEditName));
            JSONObject objEdit = (JSONObject) data.get(0);
            String madal = (String)objEdit.get("madal");
            for (int i = 1 ; i < data.size() ; i++){
                JSONObject fieldTest = (JSONObject) data.get(i);
                String action = (String) fieldTest.get("action");
                String selector = (String) fieldTest.get("selector");
                JSONArray arrDataTest = (JSONArray) fieldTest.get("data");
                for (int j = 0 ; j < arrDataTest.size(); j++){
                    if(!madal.equals("")){
                        driver.findElement(chkSelector.getBy(madal)).click();
                    }
                    Thread.sleep(3000);
                    driver.findElement(chkSelector.getBy(selector)).clear();
                    JSONObject dataEdit = (JSONObject) arrDataTest.get(j);
                    String value = (String) dataEdit.get("value");
                    String message = (String) dataEdit.get("assert");
                    switch (action){
                        case "input":
                            enter.input(selector,value);
                            break;
                        case "select":
                            enter.select(selector, value);
                            break;
                        case "check":
                            enter.check(selector);
                            break;
                    }
                    driver.findElement(By.cssSelector("button[type='submit']")).click();
                    Thread.sleep(2000);
                    Assert.assertTrue(driver.getPageSource().contains(message));
                    Thread.sleep(2000);
                    driver.get(url);
                    Thread.sleep(2000);
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        catch (ParseException e1) {
            e1.printStackTrace();
        }
    }
}
