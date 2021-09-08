package client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestClient {

    public Response sendGetRequestWithParameter(String uri, String requestPayload) {
        return given().when().get(uri + "&" + requestPayload.replace("\"", "")).then().contentType(ContentType.JSON).extract().response();
    }

    public Response sendPostRequest(String uri, Object requestPayload) {
        return given().contentType(ContentType.JSON).when().body(requestPayload).post(uri);
    }

    public Response sendPatchRequest(String uri, Object requestPayload) {
        return given().contentType(ContentType.JSON).when().body(requestPayload).patch(uri);
    }

    public Response sendPutRequest(String uri, Object requestPayload) {
        return given().contentType(ContentType.JSON).when().body(requestPayload).put(uri);
    }

    public Response sendDeleteRequest(String uri) {
        return given().when().get(uri);
    }
}

