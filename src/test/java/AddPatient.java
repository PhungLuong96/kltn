import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddPatient {
    WebDriver driver = Driver.webDriver;
        ReadFile read = new ReadFile(driver);
    @Step("Tài khoản bác sĩ")

    public void Common_1() throws InterruptedException, IOException {
//        for(TableRow row : data_1.getTableRows()){
//            String url = row.getCell("path");
        Thread.sleep(3000);
        driver.get("http://methadone2.cloudapp.net/main/patients/new");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.cssSelector("a[href$='/main/patients']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.cssSelector("a[href$='/main/patients/new']")).click();
//        Thread.sleep(3000);
        String filePath = "E:\\KLTN\\GAUGE\\test_common";
        read.Read(filePath, "doctor.xlsx", "Data");
    }
}
