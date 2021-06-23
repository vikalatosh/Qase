package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class ProjectsPage extends BasePage {
    public static final SelenideElement USER_MENU_IMAGE = $("#user-menu");
    public static final SelenideElement CREATE_NEW_PROJECT_BUTTON = $("#createButton");
    public static final SelenideElement SEARCH_INPUT = $("[name='title']");

    String locatorProjectName = "//*[text()='%s']";

    @Step("Check that Projects page is opened")
    public boolean isPageOpened() {
        log.info("Projects page is opened");
        return isExist(USER_MENU_IMAGE);
    }

    @Step("Open Projects page")
    public void openProjectsPage() {
        log.info("Open Projects page");
        open("/projects");
    }

    @Step("Check that Project is exist on the Projects page")
    public void checkProject(Project project) {
        log.info("Check that Project is exist on the Projects page");
        SEARCH_INPUT.setValue(project.getTitle());
        $(byXpath(String.format(locatorProjectName, project.getTitle()))).shouldBe(Condition.visible);
    }

    @Step("Click the button 'CREATE NEW PROJECT'")
    public void clickButtonCreateNewProject() {
        log.info("Click the button 'CREATE NEW PROJECT'");
        $(CREATE_NEW_PROJECT_BUTTON).click();
    }

    @Step("Open ProjectDetails page")
    public void openProjectDetailsPage(Project project) {
        log.info("Open ProjectDetails page");
        $(byText(project.getTitle())).click();
    }

    @Step("Check that Project is deleted")
    public void checkProjectIsDeleted(Project project) {
        log.info("Check that Project is deleted");
        SEARCH_INPUT.setValue(project.getTitle());
        $(byXpath(String.format(locatorProjectName, project.getTitle()))).shouldNotBe(Condition.visible);
    }
}
