package integration;
import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver web = Driver.webDriver;

    @Step("Đăng nhập với <username> và <password>")
    public void Login(String user, String pass) throws InterruptedException {
        web.get("http://methadone2.cloudapp.net/signin");
        web.findElement(By.name("email")).sendKeys(user);
        web.findElement(By.name("password")).sendKeys(pass);
        web.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(5000);
    }
}

