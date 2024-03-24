package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.Locators;

public class YaTrMain {

    WebDriver browser;

    public YaTrMain(WebDriver browser) {
        this.browser = browser;
    }

    public LangSelect clickSourceLanguageButton() {
        WebElement sourceLanguageButton = browser.findElement(Locators.YaTrMain.sourceLanguageButton);
        sourceLanguageButton.click();
        return new LangSelect(browser);
    }

    public String getCurrentSourceLanguage() {
        WebElement currentSourceLanguage = browser.findElement(Locators.YaTrMain.currentSourceLanguage);
        return currentSourceLanguage.getText();
    }

    public String getCurrentDestinationLanguage() {
        WebElement currentDestinationLanguage = browser.findElement(Locators.YaTrMain.currentDestinationLanguage);
        return currentDestinationLanguage.getText();
    }

    public YaTrMain clickSwitchLanguagesButton() {
        WebElement switchLanguagesButton = browser.findElement(Locators.YaTrMain.switchLanguagesButton);
        switchLanguagesButton.click();
        return new YaTrMain(browser);
    }

    public YaTrMain inputText(String text) {
        WebElement textBox = browser.findElement(Locators.YaTrMain.SourceTextArea);
        textBox.sendKeys(text);
        return new YaTrMain(browser);
    }

    public String getCurrentSourceText() {
        WebElement currentSourceText = browser.findElement(Locators.YaTrMain.SourceTextArea);
        return currentSourceText.getText();
    }

    public String getCurrentDestinationText() {
        WebElement currentDestinationText = browser.findElement(Locators.YaTrMain.DestinationTextArea);
        return currentDestinationText.getText();
    }

    public YaTrMain clickClearButton() {
        WebElement clearButton = browser.findElement(Locators.YaTrMain.clearButton);
        clearButton.click();
        return new YaTrMain(browser);
    }

    public String getFirstHistoryRecordsItemText() {
        WebElement firstHistoryRecordsItemText = browser.findElement(Locators.YaTrMain.firstHistoryRecordsItemText);
        return firstHistoryRecordsItemText.getText();
    }

    public String getFirstHistoryRecordsItemTranslation() {
        WebElement firstHistoryRecordsItemTranslation = browser.findElement(Locators.YaTrMain.firstHistoryRecordsItemTranslation);
        return firstHistoryRecordsItemTranslation.getText();
    }

    public void clickCopyDestinationButton() {
        WebElement copyDestinationButton = browser.findElement(Locators.YaTrMain.copyDestinationButton);
        copyDestinationButton.click();
    }
}
