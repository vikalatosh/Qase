package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ProjectDetailsPage extends BasePage {
    public static final SelenideElement PROJECT_ICON = $(".avatar-xxs");
    public static final SelenideElement SETTINGS_TEXT = $(byText("Settings"));

    @Step("Check that Project page is opened")
    public boolean isPageOpened() {
        log.info("Project page is opened");
        return isExist(PROJECT_ICON);
    }

    @Step("Click the button OPEN SETTINGS")
    public void openSettings() {
        log.info("Click the button OPEN SETTINGS");
        SETTINGS_TEXT.click();
    }
}
