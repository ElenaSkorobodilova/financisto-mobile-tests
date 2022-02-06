package tests.localdevice;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.LocalMobileDriver;
import helpers.Attach;
import io.appium.java_client.MobileBy;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LocalTestBase {
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
        step("Кликаем 'OK'", () -> {
            $(MobileBy.id("android:id/button1")).click();
        });
        step("Кликаем по меню в правом верхнем углу", () -> {
            $(MobileBy.xpath("//*[@text='Menu']")).click();
        });
        step("Выбираем пункт 'Entities'", () -> {
            $(MobileBy.xpath("//*[@text='Entities']")).click();
        });
        step("Выбираем пункт 'Currencies'", () -> {
            $(MobileBy.xpath("//*[@text='Currencies']")).click();
        });
        step("Кликаем '+'", () -> {
            $(MobileBy.id("com.bluecatsoftware.financisto:id/bAdd")).click();
        });
        step("Выбираем российский рубль", () -> {
            $(MobileBy.xpath("//*[@text='AMD (Armenian dram)']")).click();
        });
        step("Кликаем 'OK'", () -> {
            $(MobileBy.id("android:id/button1")).click();
        });

        step("Переходим на вкладку Accounts", () -> {
            back();
            back();
            $(MobileBy.xpath("//*[@text='Accounts']")).click();
        });
        step("Кликаем '+'", () -> {
            $(MobileBy.id("com.bluecatsoftware.financisto:id/bAdd")).click();
        });
        step("Кликаем '+'", () -> {
            $(MobileBy.className("android.widget.EditText")).sendKeys("My First Account");
        });
        step("Кликаем '+'", () -> {
            $(MobileBy.id("com.bluecatsoftware.financisto:id/data")).click();
        });
        step("Подтверждаем выбор умолчательной валюты", () -> {
            $(MobileBy.id("android:id/text1")).click();
        });
        step("Кликаем 'OK'", () -> {
            $(MobileBy.id("com.bluecatsoftware.financisto:id/bOK")).click();
        });
    }

    @AfterEach
    public void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
    }
}