package pojos.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@JsonDeserialize(builder = UserResponse.UserBuilder.class)
public class UserResponse {

    String name;
    String avatar;
    String password;
    Date birthday;
    String email;
    String gender;
    Date date_start;
    String hobby;

    @JsonPOJOBuilder(withPrefix = "")
    public static class UserBuilder {
    }
}
