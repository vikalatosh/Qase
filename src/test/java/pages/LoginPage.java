package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage extends BasePage {
    public static final SelenideElement EMAIL_INPUT = $("#inputEmail");
    public static final SelenideElement PASSWORD_INPUT = $("#inputPassword");
    public static final SelenideElement LOGIN_BUTTON = $("#btnLogin");

    public void openLoginPage() {
        open("/login");
    }

    @Step("Check that Login page is opened")
    public boolean isPageOpened() {
        log.info("Login page is opened");
        return isExist(LOGIN_BUTTON);
    }

    @Step("Login by user")
    public ProjectsPage login(String user, String password) {
        log.info("login by user");
        $(EMAIL_INPUT).sendKeys(user);
        $(PASSWORD_INPUT).sendKeys(password);
        $(LOGIN_BUTTON).click();
        return new ProjectsPage();
    }
}
