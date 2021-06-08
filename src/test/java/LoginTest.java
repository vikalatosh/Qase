import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        loginPage.openLoginPage();
        loginPage.isPageOpened();
        loginPage.login(user, password);
        projectsPage.isPageOpened();
    }
}
