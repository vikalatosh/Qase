package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProjectDetailsPage extends BasePage {
    public static final SelenideElement PROJECT_ICON = $(".avatar-xxs");
    public static final SelenideElement SETTINGS_TEXT = $(byText("Settings"));

    @Override
    public boolean isPageOpened() {
        return isExist(PROJECT_ICON);
    }

    public void openSettings() {
        SETTINGS_TEXT.click();
    }
}
