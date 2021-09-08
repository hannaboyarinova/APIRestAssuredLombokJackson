package pojos.employee;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Data;

import java.util.Date;

@Data
@JsonDeserialize(builder = EmployeeResponse.EmployeeBuilder.class)
public class EmployeeResponse {

    String email;
    String name;
    String password;
    String[] tasks;
    int[] companies;
    String hobby;
    String adres;
    String name1;
    String surname1;
    String fathername1;
    String cat;
    String dog;
    String parrot;
    String cavy;
    String hamster;
    String squirrel;
    String phone;
    String inn;
    char gender;
    Date birthday;
    Date date_start;

    @JsonPOJOBuilder(withPrefix = "")
    public static class EmployeeBuilder {
    }
}

