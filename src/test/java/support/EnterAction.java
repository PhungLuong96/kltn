package support;

import org.openqa.selenium.WebDriver;

public class EnterAction extends CheckSelector{
    public EnterAction(WebDriver driver) {
        super(driver);
    }
    public void input(String locator, String data) throws InterruptedException {
        driver.findElement(getBy(locator)).sendKeys(data);
    }

    public void select(String locator, String data) throws InterruptedException {
        driver.findElement(getBy(locator)).click();
        Thread.sleep(1000);
        driver.findElement(getBy(data)).click();
    }
    public void check(String locator){
        driver.findElement(getBy(locator)).click();
    }
}
