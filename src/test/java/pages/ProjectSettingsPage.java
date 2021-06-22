package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;
import models.ProjectFactory;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static pages.ProjectListPage.*;

@Log4j2
public class ProjectSettingsPage extends BasePage {
    public static final SelenideElement PROJECT_NAME_LABEL = $(byText("Project name"));
    public static final SelenideElement DELETE_PROJECT_BUTTON = $(byXpath("//*[contains(text(), 'Delete project')]"));
    public static final SelenideElement UPDATE_SETTINGS_BUTTON = $(byXpath("//*[contains(text(), 'Update settings')]"));
    public static final String FLASH_MESSAGE = ".flash-message";
    public static final String HEADER_TEXT = "//*[@class='sub-menu ']//*[@class='header']";
    String alertMessage = " Project settings were successfully updated!";

    @Step("Check that ProjectSettings page is opened")
    public boolean isPageOpened() {
        log.info("ProjectSettings page is opened");
        return isExist(PROJECT_NAME_LABEL);
    }

    @Step("Click the button DELETE PROJECT")
    public void clickDeleteProject() {
        log.info("Click the button DELETE PROJECT");
        DELETE_PROJECT_BUTTON.click();
    }

    @Step("Click the button UPDATE SETTINGS")
    public void clickUpdateSettings() {
        log.info("Click the button UPDATE SETTINGS");
        UPDATE_SETTINGS_BUTTON.click();
    }

    @Step("Change Project data")
    public ProjectSettingsPage changeProjectData() {
        log.info("Change Project data");
        Project project = ProjectFactory.get();
        PROJECT_NAME_INPUT.clear();
        PROJECT_NAME_INPUT.sendKeys(project.getTitle());
        PROJECT_CODE_INPUT.clear();
        PROJECT_CODE_INPUT.sendKeys(project.getCode());
        DESCRIPTION_INPUT.clear();
        DESCRIPTION_INPUT.sendKeys(project.getDescription());
        return this;
    }

    @Step("Check that Project is updated")
    public ProjectSettingsPage projectIsUpdated() {
        log.info("Project is updated");
        $(FLASH_MESSAGE).shouldBe(Condition.visible).shouldHave(Condition.text(alertMessage));
        return this;
    }
}
