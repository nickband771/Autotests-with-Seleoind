import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.YaTrMain;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class TestCasesYaTr {

    WebDriver browser;

    @Before
    public void precondition() throws URISyntaxException, MalformedURLException {

        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "121.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            /* How to enable video recording */
            put("enableVideo", true);
        }});

        //browser = new ChromeDriver();
        browser = new RemoteWebDriver(new URI("http://localhost:4444/wd/hub").toURL(), options);
        browser.get("https://translate.yandex.ru/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        browser.manage().window().maximize();

    }

    @Test
    // Тест-кейс 1 "Ввод текста, перевод на другой язык"
    public void checkTranslator() {

        YaTrMain yaTrMain = new YaTrMain(browser);

        String originalSourceLanguage = yaTrMain.getCurrentSourceLanguage();
        Assert.assertEquals("АНГЛИЙСКИЙ",originalSourceLanguage);

        String originalSourceTextArea = yaTrMain.getCurrentSourceText();
        Assert.assertEquals("", originalSourceTextArea);

        yaTrMain.
                inputText("Dog");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        String newSourceTextArea = yaTrMain.getCurrentSourceText();
        Assert.assertEquals("Dog", newSourceTextArea);

        String newDestinationTextArea = yaTrMain.getCurrentDestinationText();
        Assert.assertEquals("Собака", newDestinationTextArea);
    }

    @Test
    // Тест-кейс 2 "Выбор языка перевода, переключение между языками"
    public void checkLangChanger() {

        YaTrMain yaTrMain = new YaTrMain(browser);

        String originalSourceLanguage = yaTrMain.getCurrentSourceLanguage();
        Assert.assertEquals("АНГЛИЙСКИЙ",originalSourceLanguage);

        String expectedLanguage = "АФРИКААНС";

        yaTrMain
                .clickSourceLanguageButton()
                .clickLangButton();

        String newLanguage = yaTrMain.getCurrentSourceLanguage();

        Assert.assertEquals(expectedLanguage, newLanguage);
    }

    @Test
    // Тест-кейс 3 "Два выбранных языка меняются друг на друга"
    public void checkLangSwitcher() {

        YaTrMain yaTrMain = new YaTrMain(browser);

        String originalSourceLanguage = yaTrMain.getCurrentSourceLanguage();
        String originalDestinationLanguage = yaTrMain.getCurrentDestinationLanguage();

        Assert.assertEquals("АНГЛИЙСКИЙ",originalSourceLanguage);
        Assert.assertEquals("РУССКИЙ",originalDestinationLanguage);

        yaTrMain
                .clickSwitchLanguagesButton();

        String newSourceLanguage = yaTrMain.getCurrentSourceLanguage();
        String newDestinationLanguage = yaTrMain.getCurrentDestinationLanguage();

        Assert.assertEquals(originalDestinationLanguage, newSourceLanguage);
        Assert.assertEquals(originalSourceLanguage, newDestinationLanguage);
    }

    @Test
    // Тест-кейс 4 "Удаление текста из окна ввода текста для перевода"
    public void checkClearButton() {

        YaTrMain yaTrMain = new YaTrMain(browser);

        String currentSourceTextArea = yaTrMain.getCurrentSourceText();
        Assert.assertEquals("", currentSourceTextArea);

        yaTrMain
                .inputText("Бобер");

        currentSourceTextArea = yaTrMain.getCurrentSourceText();
        Assert.assertEquals("Бобер", currentSourceTextArea);

        yaTrMain
                .clickClearButton();

        currentSourceTextArea = yaTrMain.getCurrentSourceText();
        Assert.assertEquals("", currentSourceTextArea);
    }

//    @Test
//    // Тест-кейс 5 "Скопировать текст из окна результата перевода"
//    public void checkCopyDestinationButton() {
//
//        YaTrMain yaTrMain = new YaTrMain(browser);
//
//        yaTrMain
//                .inputText("Собака");
//
//        String currentSourceTextArea = yaTrMain.getCurrentSourceText();
//        Assert.assertEquals("Собака", currentSourceTextArea);
//
//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException ex) {
//            throw new RuntimeException(ex);
//        }
//
//        yaTrMain
//                .clickCopyDestinationButton();
//
//        String copiedText = yaTrMain.getCurrentDestinationText();
//
//        yaTrMain
//                .clickClearButton();
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException ex) {
//            throw new RuntimeException(ex);
//        }
//
//        Actions actions = new Actions(browser);
//
//        String selectAll = Keys.chord(Keys.LEFT_CONTROL, "v");
//        actions.sendKeys(selectAll);
//
//        currentSourceTextArea = yaTrMain.getCurrentSourceText();
//        Assert.assertEquals(copiedText, currentSourceTextArea);
//    }

    @Test
    // Тест-кейс 5 "История переводов, добавление нового элемента в историю"
    public void checkHistoryRecords() {

        YaTrMain yaTrMain = new YaTrMain(browser);

        yaTrMain
                .inputText("Бобер");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        String currentSourceTextArea = yaTrMain.getCurrentSourceText();
        Assert.assertEquals("Бобер", currentSourceTextArea);

        String currentDestinationTextArea = yaTrMain.getCurrentDestinationText();
        Assert.assertEquals("Beaver", currentDestinationTextArea);

        yaTrMain
                .clickClearButton();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        String firstHistoryRecordsItemText = yaTrMain.getFirstHistoryRecordsItemText();
        String firstHistoryRecordsItemTranslation = yaTrMain.getFirstHistoryRecordsItemTranslation();

        Assert.assertEquals(currentSourceTextArea, firstHistoryRecordsItemText);
        Assert.assertEquals(currentDestinationTextArea, firstHistoryRecordsItemTranslation);
    }

    @After
    public void closeBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        browser.quit();
    }
}
