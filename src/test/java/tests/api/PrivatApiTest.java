package tests.api;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class PrivatApiTest extends BaseApiTest{


    @Test
    public void getPrivateExchangeRateArchive(){
        given().param("json")
                .param("date", "01.12.2014").
        when()
                .log()
                .all(true)
                .get("https://api.privatbank.ua/p24api/exchange_rates").
        then()
                .log()
                .all(true)
                .assertThat()
                .statusCode(200)
                .body("baseCurrency", equalTo(980))
                .body("exchangeRate.baseCurrency", everyItem(equalTo("UAH")));
    }

}
