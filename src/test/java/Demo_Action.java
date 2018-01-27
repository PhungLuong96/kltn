import org.openqa.selenium.WebDriver;

public class Demo_Action extends Action{
    public Demo_Action(WebDriver driver) {
        super(driver);
    }
    public void Input(String locator, String data) throws InterruptedException {
        driver.findElement(getBy(locator)).clear();
        driver.findElement(getBy(locator)).sendKeys(data);
//        Thread.sleep(5000);
    }

    public void Select(String locator, String data) throws InterruptedException {
        driver.findElement(getBy(locator)).click();
        Thread.sleep(1000);
        driver.findElement(getBy(data)).click();
    }
    public void check(String locator){
        driver.findElement(getBy(locator)).click();
    }
}
