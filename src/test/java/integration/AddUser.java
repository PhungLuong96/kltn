package integration;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;

public class AddUser {
    AddPatient addUser = new AddPatient();
    @Step(" Add a new user <data_table> ")
    public void addUser(Table database_User) throws InterruptedException {
        addUser.addPatient(database_User);
    }
}
