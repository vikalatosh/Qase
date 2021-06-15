import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    String user, password;
    LoginPage loginPage;
    ProjectsPage projectsPage;
    ProjectListPage projectListPage;
    ProjectDetailsPage projectDetailsPage;
    ProjectSettingsPage projectSettingsPage;

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

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        getWebDriver().quit();
    }
}
