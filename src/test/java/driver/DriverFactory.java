package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    public static WebDriver getDriver(){
        String browser = System.getenv("BROWSER");
        if (browser == null){
            return new FirefoxDriver();
        }
        switch (browser){
            case "IE":
                return new InternetExplorerDriver();
            case "CHROME":
                return new ChromeDriver();
            default:
                return new FirefoxDriver();
        }
    }
}
