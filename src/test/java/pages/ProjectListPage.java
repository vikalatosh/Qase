package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ProjectListPage extends BasePage {
    public static final SelenideElement NEW_PROJECT_TEXT = $(byText("New Project"));
    public static final SelenideElement PROJECT_NAME_INPUT = $("#inputTitle");
    public static final SelenideElement PROJECT_CODE_INPUT = $("#inputCode");
    public static final SelenideElement DESCRIPTION_INPUT = $("#inputDescription");
    public static final SelenideElement CHECK_INPUT = $("#public-access-type");

    @Step("Check that ProjectList page is opened")
    public boolean isPageOpened() {
        log.info("ProjectList page is opened");
        return isExist(NEW_PROJECT_TEXT);
    }

    @Step("Create Project")
    public void createProject(Project project) {
        log.info("Input data to create new Lead");
        PROJECT_NAME_INPUT.sendKeys(project.getTitle());
        PROJECT_CODE_INPUT.sendKeys(project.getCode());
        DESCRIPTION_INPUT.sendKeys(project.getDescription());
        CHECK_INPUT.click();
        PROJECT_NAME_INPUT.submit();
    }
}
