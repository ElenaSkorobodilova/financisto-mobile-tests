package tests.localdevice;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.LocalMobileDriver;
import helpers.Attach;
import helpers.TestBaseClass;
import helpers.TestSteps;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class LocalTestBase {
    public final TestSteps mySteps = new TestSteps();
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
        back();
    }

    private void prepareApp() {
        mySteps.submitOk();
        mySteps.clickOnMainMenu();
        mySteps.clickOnEntities();
        mySteps.clickOnCurrencies();
        mySteps.clickAddButton();
        mySteps.selectCurrency();
        mySteps.submitOk();
        back();
   //     back();
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