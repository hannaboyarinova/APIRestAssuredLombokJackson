package request;

import client.RestClient;
import io.restassured.response.Response;

public class RequestFactory {

    RestClient restClient;

    public RequestFactory() {
        restClient = new RestClient();
    }

    public Response doRegister(Object payloadRequest) {
        return restClient.sendPostRequest("http://users.bugred.ru/tasks/rest/doregister", payloadRequest);
    }

    public Response doLogin(Object payloadRequest) {
        return restClient.sendPostRequest("http://users.bugred.ru/tasks/rest/dologin", payloadRequest);
    }

    public Response createCompany(Object payloadRequest) {
        return restClient.sendPostRequest("http://users.bugred.ru/tasks/rest/createcompany", payloadRequest);
    }

    public Response findUser(String payloadRequest) {
        return restClient.sendGetRequestWithParameter("http://users.bugred.ru/tasks/rest/getUser", payloadRequest);
    }

    public Response createUserWithTask(Object payloadRequest) {
        return restClient.sendPostRequest("http://users.bugred.ru/tasks/rest/createuserwithtasks", payloadRequest);
    }

    public Response createTask(Object payloadRequest) {
        return restClient.sendPostRequest("https://users.bugred.ru/tasks/rest/CreateTask", payloadRequest);
    }
}

