import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    String user, password;

    @BeforeClass
    public void setUp() {
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL", utils.PropertyReader.getProperty("qase.url"));
        user = System.getenv().getOrDefault("QASE_USER", utils.PropertyReader.getProperty("qase.user"));
        password = System.getenv().getOrDefault("QASE_PASSWORD", utils.PropertyReader.getProperty("qase.password"));
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.headless = true;
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        getWebDriver().quit();
    }
}
