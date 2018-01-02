import com.thoughtworks.gauge.Step;
        import driver.Driver;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class test {
    WebDriver driver = Driver.webDriver;
    @Step("Kiểm tra")
    public void Check_demo() throws InterruptedException {
        Thread.sleep(10000);
        driver.get("http://methadone2.cloudapp.net/main/patients/new");
        driver.findElement(By.cssSelector("input[ng-model='patient.name']")).sendKeys("luong");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[name='birth_date']")).sendKeys("20/01/2000");
        driver.findElement(By.cssSelector("div[name='gender']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Nữ']")).click();
    }
}
