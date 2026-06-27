package apiTests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class postRequest {

    @Test
    public void postRequest() {
        JSONObject payload = new JSONObject();
        payload.put("firstname", "Jim");
        payload.put("lastname", "Brown");

        Response response = RestAssured.given()
            .header("Content-Type", "application/json")
            .body(payload.toJSONString())
            .when()
            .post("https://restful-booker.herokuapp.com/booking");

        response.then().statusCode(500).log().all();
    }
}
