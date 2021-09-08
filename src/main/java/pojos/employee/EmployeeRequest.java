package pojos.employee;

import pojos.task.TaskRequest;
import lombok.Data;
import utils.TestDataGenerator;

import static utils.TestDataGenerator.emailString;
import static utils.TestDataGenerator.nameString;

@Data
public class EmployeeRequest {

    String email;
    String name;
    TaskRequest[] tasks;
    int[] companies;

    public EmployeeRequest(){
        setName(nameString());
        setEmail(emailString(getName()));
    }
}
