package tests;

import adapters.ProjectAdapter;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import models.Project;
import models.ResponseProject;
import models.ResponseStatus;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.testng.Assert.assertEquals;

public class ApiTest {

//    @Test
//    public void projectTest() {
//        String response = new ProjectAdapter().create("{}", 200);
//        assertEquals(response, "{\n" +
//                "    \"status\": false,\n" +
//                "    \"errorMessage\": \"Data is invalid\",\n" +
//                "    \"errorFields\": [\n" +
//                "        {\n" +
//                "            \"field\": \"title\",\n" +
//                "            \"error\": \"Title is required\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"field\": \"code\",\n" +
//                "            \"error\": \"Project code is required\"\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}");
//    }

    @Test(description = "Project should be created")
    public void projectTest2() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        Project project = Project.builder()
                .title(fakeValuesService.regexify("[A-Z]{10}"))
                .code(fakeValuesService.regexify("[A-Z]{10}"))
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getCode(), project.getCode());
    }

    @Test(description = "Project should be created")
    public void projectTest3() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        Project project = Project.builder()
                .title(fakeValuesService.regexify("[A-Z]{10}"))
                .code(fakeValuesService.regexify("[A-Z]{10}"))
                .description(fakeValuesService.regexify("[A-Za-z1-9]{20}"))
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getCode(), project.getCode());
    }

    @Test(description = "Project should be created")
    public void projectTest4() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        Project project = Project.builder()
                .title(fakeValuesService.regexify("[A-Z]{10}"))
                .code(fakeValuesService.regexify("[A-Z]{10}"))
                .description(fakeValuesService.regexify("[A-Za-z1-9]{20}"))
                .access("all")
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getCode(), project.getCode());
    }

    @Test(description = "Get Project data")
    public void get() {
        ResponseProject project = new ProjectAdapter().getProject("TESTTEST");
        System.out.println(project);
    }

//    @Test(description = "Project should be deleted")
//    public void projectShouldBeDeleted() {
//        String title = "tests.ProjectTest";
//        String code = "PROJECT";
//        given().
//                header("Token", "833f6af6f92e76d0f3c9b9af42f3c3f176a1950c").
//                header("Content-Type", "application/json").
//                body("{\"title\": \"" + title + "\", \"code\": \"" + code + "\"}").
//        when().
//                post("https://api.qase.io/v1/project").
//        then().
//                statusCode(200).
//                body("status", equalTo(true));
////                body("result/code", equalTo(code));
//        given().
//                header("Token", "833f6af6f92e76d0f3c9b9af42f3c3f176a1950c").
//                header("Content-Type", "application/json").
//        when().
//                delete("https://api.qase.io/v1/project/PROJECT").
//        then().
//                statusCode(200).
//                body("status", equalTo(true));
//    }
}
