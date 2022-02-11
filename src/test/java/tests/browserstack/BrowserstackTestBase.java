package tests.browserstack;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import tests.TestSteps;

import static com.codeborne.selenide.Selenide.*;
import static helpers.Attach.getSessionId;

public class BrowserstackTestBase {

    TestSteps mySteps = new TestSteps();

    @BeforeAll
    public static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = BrowserstackMobileDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }
    @BeforeEach
    public void startDriver() {
        open();
        prepareApp();
    }

    private void prepareApp() {
        mySteps.submitOk();
        mySteps.clickOnMainMenu();
        mySteps.clickOnEntities();
        mySteps.clickOnCurrencies();
        mySteps.clickAddButton();
        mySteps.selectCurrency();
        mySteps.submitOk();
        mySteps.returnTo("Accounts");
        mySteps.clickOnAccounts();
        mySteps.clickAddButton();
        mySteps.inputTextInField("My First Account");
        mySteps.clickOnCurrencyField();
        mySteps.submitSelection();
        mySteps.submitActions();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
        Attach.attachVideo(sessionId);
    }

}
