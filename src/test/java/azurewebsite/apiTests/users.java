package azurewebsite.apiTests;
import azurewebsite.data.schema.baseUrl;
import azurewebsite.payload.user;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Random;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;

public class users {
    baseUrl baseUrl = new baseUrl();
    Response response;

    user userData = new user();
    public Integer user_id;

    @BeforeMethod
    public void Setup() {
        RestAssured.baseURI = baseUrl.getDomain();
    }

    @Test
    public void createUser() {
        response = given()
                .header("Content-Type", "application/json")
                .body(userData.createUsers().toJSONString())
                .when()
                .post("/api/v1/Users")
                .then()
                .log().body()
                .statusCode(200)
                .extract().response();

        user_id = response.getBody().path("id");
        System.out.println(user_id);
    }

    @Test
    public void getUserById() {
        response = given()
                .when()
                .get("/api/v1/Users/" +user_id)
                .then()
                .statusCode(404)
                .extract().response();

        System.out.print(RestAssured.baseURI + "/api/v1/Users/" +user_id);
    }
}
