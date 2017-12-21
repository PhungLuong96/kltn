import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Action {
    WebDriver driver = Driver.webDriver;
    public Action(WebDriver driver){
        this.driver = driver;
    }
    public By getBy(String locator){
        By by  = null;
        if(locator.startsWith("id=")){
            locator = locator.substring(3);
            by = By.id(locator);
        }
        else if(locator.startsWith("name=")){
            locator = locator.substring(5);
            by = By.name(locator);
        }
        else if(locator.startsWith("css=")){
            locator = locator.substring(4);
            by = By.cssSelector(locator);
        }
        else if(locator.startsWith("xpath=")){
            locator = locator.substring(6);
            by = By.xpath(locator);
        }
        return by;
    }
}
