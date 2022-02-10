package helpers;

import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBaseClass {
    public final TestSteps mySteps = new TestSteps();

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
        back();
        mySteps.clickOnAccounts();
        mySteps.clickAddButton();
        mySteps.inputTextInField("My First Account");
        mySteps.clickOnCurrencyField();
        mySteps.submitSelection();
        mySteps.submitActions();
    }

}
