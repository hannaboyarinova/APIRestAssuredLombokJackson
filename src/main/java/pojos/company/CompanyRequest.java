package pojos.company;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import utils.TestDataGenerator;

import static utils.TestDataGenerator.companyTypeString;
import static utils.TestDataGenerator.nameString;

@Data
public class CompanyRequest {

    @JsonProperty("company_name")
    String companyName;
    @JsonProperty("company_type")
    String companyType;
    @JsonProperty("company_users")
    String[] companyUsers;
    @JsonProperty("email_owner")
    String emailOwner;

    public CompanyRequest() {
        setCompanyName(nameString() + " company");
        setCompanyType(companyTypeString());
    }
}

