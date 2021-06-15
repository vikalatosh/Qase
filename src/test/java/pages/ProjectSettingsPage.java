package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import models.Project;
import models.ProjectFactory;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static pages.ProjectListPage.*;

public class ProjectSettingsPage extends BasePage {
    public static final SelenideElement PROJECT_NAME_LABEL = $(byText("Project name"));
    public static final SelenideElement DELETE_PROJECT_BUTTON = $(byXpath("//*[contains(text(), 'Delete project')]"));
    public static final SelenideElement UPDATE_SETTINGS_BUTTON = $(byXpath("//*[contains(text(), 'Update settings')]"));
    public static final String FLASH_MESSAGE = ".flash-message";
    public static final String HEADER_TEXT = "//*[@class='sub-menu ']//*[@class='header']";
    String alertMessage = " Project settings were successfully updated!";

    @Override
    public boolean isPageOpened() {
        return isExist(PROJECT_NAME_LABEL);
    }

    public void clickDeleteProject() {
        DELETE_PROJECT_BUTTON.click();
    }

    public void clickUpdateSettings() {
        UPDATE_SETTINGS_BUTTON.click();
    }

    public ProjectSettingsPage changeProjectData() {
        Project project = ProjectFactory.get();
        PROJECT_NAME_INPUT.clear();
        PROJECT_NAME_INPUT.sendKeys(project.getTitle());
        PROJECT_CODE_INPUT.clear();
        PROJECT_CODE_INPUT.sendKeys(project.getCode());
        DESCRIPTION_INPUT.clear();
        DESCRIPTION_INPUT.sendKeys(project.getDescription());
        return this;
    }

    public ProjectSettingsPage projectIsUpdated() {
        $(FLASH_MESSAGE).shouldBe(Condition.visible).shouldHave(Condition.text(alertMessage));
        return this;
    }
}
