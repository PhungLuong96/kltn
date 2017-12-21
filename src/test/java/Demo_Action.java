import org.openqa.selenium.WebDriver;

public class Demo_Action extends Action{
    public Demo_Action(WebDriver driver) {
        super(driver);
    }
    public void Input(String locator, String data){
        driver.findElement(getBy(locator)).sendKeys(data);
    }
    public void Select(String locator, String data){
        driver.findElement(getBy(locator)).click();
        driver.findElement(getBy(data)).click();
    }
    public void check(String locator){
        driver.findElement(getBy(locator)).click();
    }
}
