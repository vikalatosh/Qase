package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class LoginTest extends BaseTest {

    @Test(description = "Login should be successful")
    public void login() {
        loginPage.openLoginPage();
        loginPage.isPageOpened();
        loginPage.login(user, password);
        projectsPage.isPageOpened();
    }
}
