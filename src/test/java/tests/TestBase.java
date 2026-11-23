package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.Configuration;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public abstract class TestBase {
    @BeforeAll
    static void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", Map.of(
                "profile.default_content_setting_values.geolocation", 1
        ));
        Configuration.browserCapabilities = options;
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadTimeout = 20000;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://fix-price.com";
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true).savePageSource(true));
    }
    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Last screenshot");
        Attach.browserConsoleLogs();
        Attach.pageSource();
        closeWebDriver();
    }
}
