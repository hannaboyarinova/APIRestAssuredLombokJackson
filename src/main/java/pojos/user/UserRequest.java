package pojos.user;

import lombok.Data;
import utils.TestDataGenerator;

import static utils.TestDataGenerator.emailString;
import static utils.TestDataGenerator.nameString;

@Data
public class UserRequest {

    String name;
    String password;
    String email;

    public UserRequest() {
        setName(nameString());
        setEmail(emailString(getName()));
        setPassword(TestDataGenerator.charsAndDigitsString(8));
    }
}
