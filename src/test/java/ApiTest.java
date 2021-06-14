import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    @Test
    public void projectTest() {
        given().
                header("Token", "833f6af6f92e76d0f3c9b9af42f3c3f176a1950c").
                header("Content-Type", "application/json").
                body("{}").
        when().
                post("https://api.qase.io/v1/project").
        then().
                statusCode(200).
                body("errorMessage", equalTo("Data is invalid"));
    }

    @Test
    public void projectShouldBeDeleted() {
        String title = "ProjectTest";
        String code = "PROJECT";
        given().
                header("Token", "833f6af6f92e76d0f3c9b9af42f3c3f176a1950c").
                header("Content-Type", "application/json").
                body("{\"title\": \"" + title + "\", \"code\": \"" + code + "\"}").
        when().
                post("https://api.qase.io/v1/project").
        then().
                statusCode(200).
                body("status", equalTo(true));
//                body("result/code", equalTo(code));
        given().
                header("Token", "833f6af6f92e76d0f3c9b9af42f3c3f176a1950c").
                header("Content-Type", "application/json").
        when().
                delete("https://api.qase.io/v1/project/PROJECT").
        then().
                statusCode(200).
                body("status", equalTo(true));
    }
}
