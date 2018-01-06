import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.apache.xpath.SourceTree;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class AddPatient {
    WebDriver driver = Driver.webDriver;
    readFile data = new readFile(driver);
    Demo_Action demo = new Demo_Action(driver);
    @Step("Tài khoản bác sĩ")
    public void Common_1() throws InterruptedException, IOException {
//        for(TableRow row : data_1.getTableRows()){
//            String url = row.getCell("path");
        Thread.sleep(5000);
        driver.get("http://methadone2.cloudapp.net/main/patients/new");
        Thread.sleep(3000);
        data.ReadJson();
    }

}
