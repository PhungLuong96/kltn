package driver;

import com.thoughtworks.gauge.*;
import org.junit.After;
import org.openqa.selenium.WebDriver;

public class Driver {
    public static WebDriver webDriver;
    @BeforeSpec
    public void open(){
        webDriver = DriverFactory.getDriver();
    }
//    @AfterStep
//    public void close(){
//        webDriver.quit();
//    }
}
