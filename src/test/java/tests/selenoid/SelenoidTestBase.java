package tests.selenoid;

import com.codeborne.selenide.Configuration;
import drivers.SelenoidMobileDriver;
import helpers.Attach;
import helpers.TestBaseClass;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.getSessionId;

public class SelenoidTestBase extends TestBaseClass {
    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = SelenoidMobileDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }


    @AfterEach
    public void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
    }
}
