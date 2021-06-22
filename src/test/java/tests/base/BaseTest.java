package tests.base;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pages.*;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    protected String user;
    protected String password;
    protected LoginPage loginPage;
    protected ProjectsPage projectsPage;
    protected ProjectListPage projectListPage;
    protected ProjectDetailsPage projectDetailsPage;
    protected ProjectSettingsPage projectSettingsPage;

    @Step("Open browser")
    @BeforeClass
    public void setUp() {
        Configuration.baseUrl = utils.PropertyReader.getProperty("QASE_URL", "qase.url");
        user = utils.PropertyReader.getProperty("QASE_USER", "qase.user");
        password = utils.PropertyReader.getProperty("QASE_PASSWORD", "qase.password");
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.headless = true;
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        loginPage = new LoginPage();
        projectListPage = new ProjectListPage();
        projectsPage = new ProjectsPage();
        projectDetailsPage = new ProjectDetailsPage();
        projectSettingsPage = new ProjectSettingsPage();
    }

    @Step("Close browser")
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        getWebDriver().quit();
    }
}
