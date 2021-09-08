package pojos.company;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@JsonDeserialize(builder = CompanyResponse.CompanyResponseBuilder.class)
public class CompanyResponse {

    public String type;
    @JsonProperty("id_company")
    public int idCompany;
    public CompanyBody company;

    @JsonPOJOBuilder(withPrefix = "")
    public static class CompanyResponseBuilder {
    }

}

