package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
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

    public boolean isPageOpened() {
        return isExist(USER_MENU_IMAGE);
    }

    public void openProjectsPage() {
        open("/projects");
    }

    public void checkProject(Project project) {
        SEARCH_INPUT.setValue(project.getTitle());
        $(byXpath(String.format(locatorProjectName, project.getTitle()))).shouldBe(Condition.visible);
    }

    public void clickButtonCreateNewProject() {
        $(CREATE_NEW_PROJECT_BUTTON).click();
    }

    public ProjectDetailsPage openProjectDetailsPage(Project project) {
        $(byText(project.getTitle())).click();
        return new ProjectDetailsPage();
    }

    public void checkProjectIsDeleted(Project project) {
        SEARCH_INPUT.setValue(project.getTitle());
        $(byXpath(String.format(locatorProjectName, project.getTitle()))).shouldNotBe(Condition.visible);
    }
}
