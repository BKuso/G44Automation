package tests.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;

public abstract class BaseApiTest {

    protected Logger log = LogManager.getLogger(this.getClass().getName());

    protected RequestSpecification reqSpec;
    protected ResponseSpecification resSpec;

    @Before
    public void setUp(){
        this.reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.privatbank.ua/p24api")
                .addQueryParam("exchange")
                .addQueryParam("json")
                .build();
        this.resSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("base_ccy", hasItem(equalTo("UAH")))
                .build();
    }


}
