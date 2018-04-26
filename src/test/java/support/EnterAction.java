package support;

import driver.Driver;
import org.openqa.selenium.WebDriver;

public class EnterAction {
    WebDriver driver = Driver.webDriver;
    CheckSelector checkSel = new CheckSelector();
    public void input(String locator, String data)  {
        driver.findElement(checkSel.getBy(locator)).sendKeys(data);
    }

    public void select(String locator, String data) throws InterruptedException {
        driver.findElement(checkSel.getBy(locator)).click();
        Thread.sleep(1000);
        driver.findElement(checkSel.getBy(data)).click();
    }
    public void check(String locator){
        driver.findElement(checkSel.getBy(locator)).click();
    }
}
