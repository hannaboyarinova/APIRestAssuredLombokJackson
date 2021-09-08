package tests;

import org.junit.Test;
import pojos.user.UserRequest;
import request.RequestFactory;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class RegistrationTest {

    RequestFactory requestFactory = new RequestFactory();

    @Test
    public void verifyRegistrationWithCorrectCredsTest() {
        UserRequest user = new UserRequest();

        requestFactory.doRegister(user)
                .then().log().all().statusCode(200);
    }

    @Test
    public void verifyRegistrationWithoutEmailTest() {
        UserRequest user = new UserRequest();
        user.setEmail(null);

        requestFactory.doRegister(user)
                .then().log().all().body("type", equalTo("error")).and()
                .body("message", equalTo("Параметр email является обязательным!"));
    }

    @Test
    public void verifyRegistrationWhenEmailUpperCaseTest() {
        UserRequest user = new UserRequest();
        user.setEmail("EVAWATTIS@QQQ.IN");

        requestFactory.doRegister(user)
                .then().log().all()
                .statusCode(200)
                .body("email", equalToIgnoringCase(user.getEmail()));
    }

    @Test
    public void verifyRegistrationWhenEmailWithNumbersInNameTest() {
        UserRequest user = new UserRequest();
        user.setEmail("1111111@qqq.qw");

        requestFactory.doRegister(user)
                .then().log().all()
                .statusCode(200)
                .body("email", equalToIgnoringCase(user.getEmail()));
    }

    @Test
    public void verifyRegistrationWhenEmailWithNumbersInDomainTest() {
        UserRequest user = new UserRequest();
        user.setEmail("zdsdsd@111.ru");

        requestFactory.doRegister(user)
                .then().log().all()
                .statusCode(200)
                .body("email", equalToIgnoringCase(user.getEmail()));
    }

    @Test
    public void verifyRegistrationWhenEmailWithDashInNameTest() {
        UserRequest user = new UserRequest();
        user.setEmail("zds-dsd@111.in");

        requestFactory.doRegister(user)
                .then().log().all()
                .statusCode(200)
                .body("email", equalToIgnoringCase(user.getEmail()));
    }

    @Test
    public void verifyRegistrationWhenEmailWithDashInDomainTest() {
        UserRequest user = new UserRequest();
        user.setEmail("zdsdsd@1-11.in");

        requestFactory.doRegister(user)
                .then().log().all()
                .statusCode(200)
                .body("email", equalTo(user.getEmail()));
    }

    @Test
    public void verifyRegistrationWhenEmailWithUnderscoreInNameTest() {
        UserRequest user = new UserRequest();
        user.setEmail("zds_dsd@sdsd.in");

        requestFactory.doRegister(user)
                .then().log().all()
                .statusCode(200).body("email", equalToIgnoringCase(user.getEmail()));
    }

    @Test
    public void verifyRegistrationWhenEmailWithUnderscoreInDomainTest() {
        UserRequest user = new UserRequest();
        user.setEmail("zdsdddsd@sd_sd.in");

        requestFactory.doRegister(user)
                .then().log().all()
                .statusCode(200)
                .body("email", equalToIgnoringCase(user.getEmail()));
    }

    @Test
    public void verifyRegistrationWhenEmailWithDotsInNameTest() {
        UserRequest user = new UserRequest();
        user.setEmail("zds.dd.dsd@sdsd.in");

        requestFactory.doRegister(user)
                .then().log().all()
                .statusCode(200).body("email", equalToIgnoringCase(user.getEmail()));
    }

    @Test
    public void verifyRegistrationWhenEmailWithDotsInDomainTest() {
        UserRequest user = new UserRequest();
        user.setEmail("zdsdddsd@sds.dfd.fd.in");

        requestFactory.doRegister(user)
                .then().log().all()
                .statusCode(200).body("email", equalToIgnoringCase(user.getEmail()));
    }

    @Test
    public void verifyRegistrationWhenEmailWithoutDotTest() {
        UserRequest user = new UserRequest();
        user.setEmail("eve0.holt@reqres");

        requestFactory.doRegister(user)
                .then().log().all()
                .body("type", equalTo("error"))
                .body("message", equalTo(" Некоректный  email " + user.getEmail()));
    }

    @Test
    public void verifyRegistrationWhenEmailWithoutAtTest() {
        UserRequest user = new UserRequest();
        user.setEmail("eve0.holtreqres.in");

        requestFactory.doRegister(user)
                .then().log().all()
                .body("type", equalTo("error"))
                .body("message", equalTo(" Некоректный  email " + user.getEmail()));  //уточнить по поводу
        // containsString
    }

    @Test
    public void verifyRegistrationWhenEmailWithBackspaceInAccountTest() {
        UserRequest user = new UserRequest();
        user.setEmail("eve0 holt@reqres.in");

        requestFactory.doRegister(user)
                .then().log().all()
                .body("type", equalTo("error"))
                .body("message", equalTo(" Некоректный  email " + user.getEmail()));
    }

    @Test
    public void verifyRegistrationWhenEmailWithBackspaceInDomainTest() {
        UserRequest user = new UserRequest();
        user.setEmail("evholt@req res.in");

        requestFactory.doRegister(user)
                .then().log().all()
                .body("type", equalTo("error"))
                .body("message", equalTo(" Некоректный  email " + user.getEmail()));
    }

    @Test
    public void verifyRegistrationWhenEmailWithoutNameTest() {
        UserRequest user = new UserRequest();
        user.setEmail("@reqres.in");

        requestFactory.doRegister(user)
                .then().log().all()
                .body("type", equalTo("error"))
                .body("message", equalTo(" Некоректный  email " + user.getEmail()));
    }

    @Test
    public void verifyRegistrationWhenEmailWithoutDomainTest() {
        UserRequest user = new UserRequest();
        user.setEmail("reqres.in@");

        requestFactory.doRegister(user)
                .then().log().all()
                .body("type", equalTo("error"))
                .body("message", equalTo(" Некоректный  email " + user.getEmail()));
    }

    @Test
    public void verifyRegistrationWhenEmailIsCyrilicTest() {
        UserRequest user = new UserRequest();
        user.setEmail("ева.holt@reqres.com");

        requestFactory.doRegister(user).then().log().all().body("type", equalTo("error")).and()
                .body("message", equalTo(" Некоректный  email " + user.getEmail()));
    }
}
