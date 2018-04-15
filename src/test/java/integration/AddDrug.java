package integration;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import java.io.IOException;

public class AddDrug {
    AddPatient addDrug = new AddPatient();
    @Step("Add a drug <database_Drug>")
    public void addDrug(Table database_Drug) throws InterruptedException {
        addDrug.addPatient(database_Drug);
    }
}
