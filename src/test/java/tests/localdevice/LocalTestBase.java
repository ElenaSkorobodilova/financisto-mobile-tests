package tests.localdevice;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.LocalMobileDriver;
import helpers.Attach;
import org.junit.jupiter.api.BeforeEach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import tests.TestSteps;

import static com.codeborne.selenide.Selenide.*;

public class LocalTestBase {

    TestSteps mySteps = new TestSteps();

    @BeforeAll
    public static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = LocalMobileDriver.class.getName();
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
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
    }
}