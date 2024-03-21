package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Locators;

public class LangSelect {

    private WebDriver browser;

    public LangSelect(WebDriver browser) {
        this.browser = browser;
    }

    public YaTrMain clickLangButton() {
        WebElement langButton = browser.findElement(Locators.LangSelect.LANG_BUTTON);
        langButton.click();
        return new YaTrMain(browser);
    }
}
