package tests;

import pojos.task.TaskRequest;
import pojos.company.CompanyRequest;
import pojos.company.CompanyResponse;
import pojos.employee.EmployeeRequest;
import pojos.user.UserRequest;
import io.restassured.response.Response;
import org.junit.Test;
import request.RequestFactory;

import static org.hamcrest.Matchers.equalTo;

public class UserScenarioTest {

    RequestFactory requestFactory = new RequestFactory();


    @Test
    public void verifyCreationUserAndCompanyAndEmployeeWithTaskTest() {
        UserRequest user = new UserRequest();
        requestFactory.doRegister(user);
        requestFactory.doLogin(user);

        CompanyRequest companyRequest = new CompanyRequest();
        companyRequest.setCompanyUsers(new String[]{user.getEmail()});
        companyRequest.setEmailOwner(user.getEmail());

        Response response = requestFactory.createCompany(companyRequest);
        CompanyResponse companyResponse = response.getBody().as(CompanyResponse.class);
        response.then().body("type", equalTo("success"));

        EmployeeRequest employee = new EmployeeRequest();
        employee.setCompanies(new int[]{companyResponse.getIdCompany()});
        employee.setTasks(new TaskRequest[]{new TaskRequest()});
        requestFactory.createUserWithTask(employee)
                .then().log().all()
                .body("name", equalTo(employee.getName()))
                .and().body("companies.id[0]", equalTo(companyResponse.getIdCompany()))
                .and().body("tasks.name[0]", equalTo(employee.getTasks()[0].getTitle()));


//
//        System.out.println("Owner " + user.getName() + " " + user.getEmail());
//        System.out.println("Created company " + companyResponse.getCompany().getName() + " " + companyResponse.idCompany);
//        System.out.println("Employee " + employee.getName() + " " + employee.getEmail() + " " + employee.getCompanies()[0]);

    }
}

