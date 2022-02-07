package helpers;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

public class TestSteps {
    @Step("Кликаем 'OK' на панели устройства")
    public void submitOk() {
        $(MobileBy.id("android:id/button1")).click();
    }

    @Step("Кликаем по меню в правом верхнем углу")
    public void clickOnMainMenu() {
        $(MobileBy.xpath("//*[@text='Menu']")).click();
    }

    @Step("Выбираем пункт 'Entities'")
    public void clickOnEntities() {
        $(MobileBy.xpath("//*[@text='Entities']")).click();
    }

    @Step("Выбираем пункт 'Currencies'")
    public void clickOnCurrencies() {
        $(MobileBy.xpath("//*[@text='Currencies']")).click();
    }

    @Step("Кликаем кнопку '+' в подразделе приложения")
    public void clickAddButton() {
        $(MobileBy.id("com.bluecatsoftware.financisto:id/bAdd")).click();
    }

    @Step("Выбираем валюту по умолчанию")
    public void selectCurrency() {
        $(MobileBy.xpath("//*[@text='AMD (Armenian dram)']")).click();
    }

    @Step("Переходим на вкладку Accounts")
    public void clickOnAccounts() {
        $(MobileBy.xpath("//*[@text='Accounts']")).click();
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
}

