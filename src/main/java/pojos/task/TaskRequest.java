package pojos.task;

import lombok.Data;
import utils.TestDataGenerator;

import static utils.TestDataGenerator.charsAndDigitsString;
import static utils.TestDataGenerator.nameString;

@Data
public class TaskRequest {
    String title;
    String description;

    public TaskRequest(){
        setTitle("Task " + nameString());
        setDescription(charsAndDigitsString(8) + charsAndDigitsString(4));
    }
}
