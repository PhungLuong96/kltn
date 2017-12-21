package driver;

import com.thoughtworks.gauge.AfterSpec;
import com.thoughtworks.gauge.BeforeSpec;
import org.junit.After;
import org.openqa.selenium.WebDriver;

public class Driver {
    public static WebDriver webDriver;
    @BeforeSpec
    public void open(){
        webDriver = DriverFactory.getDriver();
    }
//    @AfterSpec
//    public void close(){
//        webDriver.quit();
//    }
}
