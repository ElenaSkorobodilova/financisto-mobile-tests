package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;


import static com.codeborne.selenide.Selenide.*;

public class TestSteps {
    @Step("Кликаем 'OK' на панели устройства")
    public void submitOk() {
        $(MobileBy.id("android:id/button1")).click();
    }

    @Step("Кликаем по меню в правом верхнем углу")
    public void clickOnMainMenu() {
        clickOn("Menu");
    }

    @Step("Выбираем пункт 'Entities'")
    public void clickOnEntities() {
        clickOn("Entities");
    }

    @Step("Выбираем пункт 'Currencies'")
    public void clickOnCurrencies() {
        clickOn("Currencies");
    }

    @Step("Нажать \"+\" в левом нижнем углу экрана.")
    public void clickAddButton() {
        $(MobileBy.id("com.bluecatsoftware.financisto:id/bAdd")).click();
    }

    @Step("Выбираем валюту по умолчанию")
    public void selectCurrency() {
        $(MobileBy.xpath(String.format("//*[@text='%s']", Locators.defaultCurrency))).click();
    }

    @Step("Переходим на вкладку Accounts")
    public void clickOnAccounts() {
        clickOn("Accounts");
    }

    @Step("Переходим на вкладку Reports")
    public void clickOnReports() {
        clickOn("Reports");
    }

    @Step("Выбираем пункт 'By Period'")
    public void clickOnByPeriod() {
        clickOn("By Period");
    }

    @Step("Вводим в текстовое поле строку {text}")
    public void inputTextInField(String text) {
        $(MobileBy.className("android.widget.EditText")).sendKeys(text);
    }

    @Step("Кликаем по полю выбора валюты")
    public void clickOnCurrencyField() {
        $(MobileBy.id("com.bluecatsoftware.financisto:id/data")).click();
    }

    @Step("Подтверждаем выбор умолчательной валюты")
    public void submitSelection() {
        $(MobileBy.id("android:id/text1")).click();
    }

    @Step("Кликаем 'OK' в окошке подтверждения")
    public void submitActions() {
        $(MobileBy.id("com.bluecatsoftware.financisto:id/bOK")).click();
    }

    @Step("Щёлкнуть левой кнопкой мыши на \"-\" рядом с полем Amount.")
    public void clickMinusToPlus(String pathTo) {
        $(MobileBy.xpath(pathTo)).click();
    }

    @Step("В списке счетов кликнуть левой кнопкой мыши по счёту \"My First Account\".")
    public void clickOnFirstAccount() {
        clickOn("My First Account");
    }

    @Step("В открывшейся панели доступных действий выбрать \"Transaction\".")
    public void selectTransaction() {
        clickOn("Transaction");
    }

    @Step("В открывшейся панели доступных действий выбрать \"Edit\".")
    public void selectEdit() {
        clickOn("Edit");
    }

    @Step("В открывшейся панели доступных действий выбрать \"Delete account\".")
    public void selectDelete() {
        clickOn("Delete account");
    }

    @Step("В открывшейся панели доступных действий выбрать \"Balance\".")
    public void selectBalance() {
        clickOn("Balance");
    }

    @Step("Щёлкнуть левой кнопкой мыши в поле Amount, ввести {summa}.")
    public void amountInput(String summa) {
        $(MobileBy.id("com.bluecatsoftware.financisto:id/primary")).sendKeys(summa);
    }

    @Step("Нажать кнопку \"Save\".")
    public void saveChanges() {
        $(MobileBy.id("com.bluecatsoftware.financisto:id/bSave")).click();
    }

    public void clickOn(String selection) {
        Assertions.assertTrue(checkElement(selection), "Ошибка! Элемент не найден!");
        $(MobileBy.xpath(String.format("//*[@text='%s']", selection))).click();
    }

    // Методы проверки
    @Step("На вкладке Accounts счёт \"Test Account\" = {summa}")
    public void checkSumma(String summa) {
        $(MobileBy.id("com.bluecatsoftware.financisto:id/right_center"))
                .shouldBe(Condition.exactText(summa));
    }

    @Step("На вкладке Accounts есть счёт {nameAccount}")
    public void checkAccountExist(String nameAccount) {
        $(MobileBy.id("com.bluecatsoftware.financisto:id/center"))
                .shouldBe(Condition.exactText(nameAccount));
    }

    @Step("Заголовок страницы = {title}")
    public void checkReportPageTitle(String title) {
        $(MobileBy.id("android:id/title"))
                .shouldBe(Condition.exactText(title));
    }

    @Step("Сумма в поле отчёта = {summa}")
    public void checkReportSelection(String summa) {
        $(MobileBy.xpath(Locators.xp)).click();
        $(MobileBy.id("com.bluecatsoftware.financisto:id/right_center"))
                .shouldBe(Condition.exactText(summa));
    }

    @Step("На вкладке Accounts нет счёта {nameAccount}")
    public void checkAccountNotExist() {
        $(MobileBy.id("android:id/empty"))
                .shouldBe(Condition.exactText("You should start with creating an account. Tap the '+' at the bottom…"));
    }

    @Step("Возвращаемся на вкладку '{searchName}'")
    public void returnTo(String searchName) {
        boolean result = checkElement(searchName);
        while (!result) {
            back();
            result = checkElement(searchName);
        }
    }

    private boolean checkElement(String searchName) {
        boolean check = false;
        SelenideElement element;
        try {
            element = $(MobileBy.xpath(String.format("//*[@text='%s']", searchName)));
            check =  element.shouldBe(Condition.enabled).exists();
        } catch(Exception e) {
            check = false; //просто ловим Exception до тех пор, пока элемент не найдётся
        } finally {
            return check;
        }
    }

    @Step("Подготовка")
    public void prepareApp() {
        submitOk();
        clickOnMainMenu();
        clickOnEntities();
        clickOnCurrencies();
        clickAddButton();
        selectCurrency();
        submitOk();
        returnTo("Accounts");
        clickOnAccounts();
        clickAddButton();
        inputTextInField("My First Account");
        clickOnCurrencyField();
        submitSelection();
        submitActions();
    }
}

