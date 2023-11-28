package liveProject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class GitHubProjectTest {

    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAINoGjLkdKWIjhMCI1i+HCpAH9zFIEy8UUpK1KtZqrltX";
    int SSHId;

    @BeforeClass
    public void setUp() {
        requestSpec = new RequestSpecBuilder().
                setBaseUri("https://api.github.com/user/keys").
                addHeader("Authorization", "token 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").
                addHeader("content-Type","application/json").
                build();

        responseSpec = new ResponseSpecBuilder().
                expectResponseTime(lessThanOrEqualTo(4000L)).
                expectBody("key",equalTo(sshKey)).
                expectBody("title",equalTo("TestAPIKey")).
                build();
    }

    @Test(priority=1)
    public void postRequestTest() {
        Map<String, String> reqBody = new HashMap<>();
        reqBody.put("title","TestAPIKey");
        reqBody.put("key",sshKey);

        Response response = given().spec(requestSpec).body(reqBody).log().all().when().post();
        SSHId = response.then().extract().path("id");
        response.then().statusCode(201).spec(responseSpec);
        System.out.println(response.getBody().asPrettyString());
    }

    @Test(priority=2)
    public void getRequestTest() {
        given().spec(requestSpec).pathParam("keyId", SSHId).when().get("/{keyId}").
                then().statusCode(200).spec(responseSpec).log().all();
    }

    @Test(priority=3)
    public void deleteRequestTest() {
        given().spec(requestSpec).pathParam("keyId", SSHId).delete("/{keyId}").
                then().statusCode(204).log().all();
    }

}
