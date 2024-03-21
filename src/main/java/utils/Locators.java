package utils;

import org.openqa.selenium.By;

public interface Locators {

    public interface YaTrMain {

        By sourceLanguageButton = By.id("srcLangButton");

        By currentSourceLanguage = By.id("srcLangButton");

        By currentDestinationLanguage = By.id("dstLangButton");

        By switchLanguagesButton = By.xpath("//*[@id='langsPanel']/div[@class='wnJW7LPN_ZsOMBoXFamJ']/div[@class='Hh6hKAMd5urP2wyj7mHe']/div[@class='VLslNIbrOTGo2AUzmUh9']/button[@class='gTx50DUfJa1q57Z9sbM6 t3nFXmxYr19rwmJaBoHg yZ0odbAnIl__RMrmbWuA SNvWOiTv0bJTav0uo4Y6 nit1qvNY5o0LAHqo2TZ2 hf9lG6bClwoi5q7Cs1uQ']");

        By SourceTextArea = By.id("fakeArea");

        By DestinationTextArea = By.id("translation");

        By clearButton = By.id("clearButton");

        By copyDestinationButton = By.id("copyDstButton");

        By firstHistoryRecordsItemText = By.xpath("//*[@id='historyRecent']/div[@class='history_records-container']/div[@class='history_records-items_container invisible-horizontal-scrollbar']/div[@class='history_records-item'][1]/div[@class='history_records-item-text']");

        By firstHistoryRecordsItemTranslation = By.xpath("//*[@id='historyRecent']/div[@class='history_records-container']/div[@class='history_records-items_container invisible-horizontal-scrollbar']/div[@class='history_records-item'][1]/div[@class='history_records-item-translation']");
    }

    public interface LangSelect {

        By LANG_BUTTON = By.xpath("//*[@class='langs-column langs-column_count_5']/div[@class='langs-item langs-item_cell langs-item_hasLetterSpace'][5]");
    }
}