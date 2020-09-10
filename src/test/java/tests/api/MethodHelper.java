package tests.api;

import entities.BaseEntity;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public abstract class MethodHelper extends BaseApiTest{

    protected Response get(Map<String, Object> params, String partOfUrl){
        return given()
                .spec(reqSpec)
                .queryParams(params)
                .when()
                .log()
                .body(true)
                .get(partOfUrl);
    }

    protected Response get(String partOfUrl){
        return given()
                .spec(reqSpec)
                .when()
                .log()
                .all(true)
                .get(partOfUrl);
    }

    protected Response post(Map<String, Object> body, String partOfUrl){
        return given()
                .spec(reqSpec)
                .body(body)
                .when()
                .log()
                .all(true)
                .get(partOfUrl);
    }

    protected Response post(BaseEntity body, String partOfUrl){
        return given()
                .spec(reqSpec)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .log()
                .all(true)
                .get(partOfUrl);
    }

}
