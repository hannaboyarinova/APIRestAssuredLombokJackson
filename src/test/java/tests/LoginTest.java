package tests;

import pojos.user.UserRequest;
import org.junit.Test;
import request.RequestFactory;
import utils.TestDataGenerator;

import static org.hamcrest.CoreMatchers.equalTo;

public class LoginTest {
    RequestFactory requestFactory = new RequestFactory();

    @Test
    public void verifyLoginSuccessTest() {
        UserRequest user = new UserRequest();
        requestFactory.doRegister(user);
        requestFactory.doLogin(user).then().body("result", equalTo(true));
    }

    @Test
    public void verifyLoginWithWrongPasswordTest() {
        UserRequest user = new UserRequest();
        requestFactory.doRegister(user);
        user.setPassword(TestDataGenerator.charsAndDigitsString(4));
        requestFactory.doLogin(user).then().body("result", equalTo(false));
    }
}
