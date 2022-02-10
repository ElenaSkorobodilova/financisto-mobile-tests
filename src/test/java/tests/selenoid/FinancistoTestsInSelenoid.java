package tests.selenoid;

import helpers.Constants;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.localdevice.LocalTestBase;

public class FinancistoTestsInSelenoid extends LocalTestBase {

    @Test
    @Tag("local")
    @AllureId("7208")
    @Epic("UsersStory")
    @Feature("Accounts")
    @Story("Transactions")
    @DisplayName("Выполнение проводки по счёту")
    @Owner("allure8")
    public void addTransactionTest() {
        mySteps.clickOnFirstAccount();
        mySteps.selectTransaction();
        mySteps.clickMinusToPlus(Constants.minusXpath);
        mySteps.amountInput("650");
        mySteps.saveChanges();
        mySteps.checkSumma("650.00 Dhs.");
    }

    @Test
    @AllureId("7209")
    @Epic("UsersStory")
    @Feature("Accounts")
    @Story("Create")
    @DisplayName("Добавление счёта c ненулевым остатком")
    @Owner("allure8")
    @Tag("local")
    public void addAccountTest() {
        mySteps.clickAddButton();
        mySteps.inputTextInField("Test account");
        mySteps.clickOnCurrencyField();
        mySteps.submitSelection();
        mySteps.amountInput("2000");
        mySteps.submitActions();
        mySteps.checkAccountExist("Test account");
        mySteps.checkSumma("2,000.00 Dhs.");
    }

    @Test
    @AllureId("7200")
    @Epic("UsersStory")
    @Feature("Accounts")
    @Story("Create")
    @DisplayName("Добавление счёта c нулевым остатком")
    @Owner("allure8")
    @Tag("local")
    public void addEmptyAccountTest() {
        mySteps.clickAddButton();
        mySteps.inputTextInField("Test account");
        mySteps.clickOnCurrencyField();
        mySteps.submitSelection();
        mySteps.submitActions();
        mySteps.checkAccountExist("Test account");
        mySteps.checkSumma("0.00 Dhs.");
    }

    @Test
    @AllureId("7210")
    @Epic("UsersStory")
    @Feature("Reports")
    @Story("Gets")
    @DisplayName("Получение отчёта по счёту. За период")
    @Owner("allure8")
    @Tag("local")
    public void reportTest() {
        mySteps.clickOnFirstAccount();
        mySteps.selectTransaction();
        mySteps.clickMinusToPlus(Constants.minusXpath);
        mySteps.amountInput("1500");
        mySteps.saveChanges();
        mySteps.clickOnReports();
        mySteps.clickOnByPeriod();
        mySteps.checkReportPageTitle(Constants.reportPageTitle);
        mySteps.checkReportSelection("+1,500.00 Dhs.");
    }

    @Test
    @AllureId("7205")
    @Epic("UsersStory")
    @Feature("Accounts")
    @Story("Edit")
    @DisplayName("Редактирование счёта. Изменение названия")
    @Owner("allure8")
    @Tag("local")
    public void editNameAccountTest() {
        mySteps.clickOnFirstAccount();
        mySteps.selectEdit();
        mySteps.inputTextInField("_2");
        mySteps.submitActions();
        mySteps.checkAccountExist("My First Account_2");
    }

    @Test
    @AllureId("7206")
    @Epic("UsersStory")
    @Feature("Accounts")
    @Story("Edit")
    @DisplayName("Редактирование счёта. Изменение начальной суммы")
    @Owner("allure8")
    @Tag("local")
    public void editAmountTest() {
        mySteps.clickOnFirstAccount();
        mySteps.selectBalance();
        mySteps.clickMinusToPlus(Constants.minusInAmountBalance);
        mySteps.amountInput("1000");
        mySteps.saveChanges();
        mySteps.checkSumma("1,000.00 Dhs.");
    }

    @Test
    @AllureId("7201")
    @Epic("UsersStory")
    @Feature("Accounts")
    @Story("Delete")
    @DisplayName("Удаление счёта")
    @Owner("allure8")
    @Tag("local")
    public void deleteAccountTest() {
        mySteps.clickOnFirstAccount();
        mySteps.selectDelete();
        mySteps.submitOk();
        mySteps.checkAccountNotExist();
    }
}
