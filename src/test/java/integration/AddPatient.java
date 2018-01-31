package integration;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import driver.Driver;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class AddPatient {
    WebDriver driver = Driver.webDriver;
    ReadFile data = new ReadFile(driver);
    @Step("Tài khoản bác sĩ <database>")
    public void Common_1( Table database) throws InterruptedException, IOException {
        for(TableRow row : database.getTableRows()) {
            Thread.sleep(5000);
            String url = row.getCell("url");
            driver.get(url);
            String TestData = row.getCell("TestData");
            String DataPrepare = row.getCell("DataPrepare");
            data.executeFile(DataPrepare,TestData,url);
        }
    }

}
