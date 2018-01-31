package integration;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import driver.Driver;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class AddDrug {
    WebDriver driver = Driver.webDriver;
    ReadFile data = new ReadFile(driver);
    @Step("Add a drug <database_Drug>")
    public void addDrug(Table database_Drug) throws InterruptedException, IOException {
        for (TableRow row: database_Drug.getTableRows()){
            String url = row.getCell("url");
            Thread.sleep(3000);
            driver.get(url);
            String DataPrepare = row.getCell("DataPrepare");
            String TestData = row.getCell("TestData");
            data.executeFile(DataPrepare,TestData,url);
        }
    }
}
