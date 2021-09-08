package pojos.company;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
@JsonDeserialize(builder = CompanyBody.CompanyBodyBuilder.class)

public class CompanyBody {

    public String name;
    public String type;
    public String inn;
    public String ogrn;
    public String kpp;
    public String phone;
    public String adress;
    public List<String> users;

    @JsonPOJOBuilder(withPrefix = "")
    public static class CompanyBodyBuilder {
    }
}







