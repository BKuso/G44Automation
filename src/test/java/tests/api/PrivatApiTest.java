package tests.api;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static java.lang.System.getProperty;
import static org.hamcrest.CoreMatchers.*;

public class PrivatApiTest extends BaseApiTest{


    @Test
    public void getPrivateExchangeRateArchive(){
        given()
                .spec(reqSpec)
                .queryParam("coursid", 5).
        when()
                .log()
                .all(true)
                .get("/pubinfo").
        then()
                .log()
                .all(true)
                .spec(resSpec)
                .body(matchesJsonSchema(
                        new File(getProperty("user.dir")
                                + "/src/test/resources/schema-validation/getPubinfoSchema.json")));
    }

}
