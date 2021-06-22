package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoSuchElementException;

@Log4j2
public abstract class BasePage {

    public abstract boolean isPageOpened();

    public boolean isExist(SelenideElement element) {
        try {
            element.shouldBe(Condition.visible);
            return true;
        } catch (NoSuchElementException exception) {
            log.fatal(exception.getMessage());
            return false;
        }
    }
}
