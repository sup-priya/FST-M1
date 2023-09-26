package liveProject;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
    //Declare map i.e headers
    Map<String, String> headers = new HashMap<>();

    //Create Pact
    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        //headers
        headers.put("Content-Type", "application/json");

        //Request & response body
        DslPart requestResponseBody = new PactDslJsonBody().
                numberType("id", 143).
                stringType("firstName", "Supriya").
                stringType("lastName", "MS").
                stringType("email", "sms@fvi.com");

        //Generate pact
        return builder.given("POST Request")
            .uponReceiving("request to create user")
                .method("POST")
                .path("/api/users")
                .headers(headers)
                .body(requestResponseBody)
            .willRespondWith()
                .status(201)
                .body(requestResponseBody)
                .toPact();
    }

    //Run test with mock provider
    @Test
    @PactTestFor(providerName = "UserProvider", port = "8282")
    public void consumerTest() {
        //Request body
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 143);
        reqBody.put("firstName", "Supriya");
        reqBody.put("lastName", "MS");
        reqBody.put("email", "sms@fvi.com");

        //Send request
        given().headers(headers).body(reqBody).log().all().
        when().post("http://localhost:8282/api/users").
        then().statusCode(201).body("firstName", equalTo("Supriya")).log().all();

    }
}