package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.Locators;

import java.rmi.Remote;

public class LangSelect {

    WebDriver browser;

    public LangSelect(WebDriver browser) {
        this.browser = browser;
    }

    public YaTrMain clickLangButton() {
        WebElement langButton = browser.findElement(Locators.LangSelect.LANG_BUTTON);
        langButton.click();
        return new YaTrMain(browser);
    }
}
