package tests.localdevice;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class FinancistoTestsInLocalEmulator extends LocalTestBase {

    @Test
    @Tag("local")
    @AllureId("7208")
    @DisplayName("Выполнение проводки по счёту")
    @Owner("allure8")
    public void test1() {
        step("В списке счетов кликнуть левой кнопкой мыши по счёту \"My First Account\".");
        step("В открывшейся панели доступных действий выбрать \"Transaction\". ");
        step("Щёлкнуть левой кнопкой мыши на \"-\" рядом с полем Amount. ");
        step("Щёлкнуть левой кнопкой мыши в поле Amount, ввести 650.");
        step("Нажать кнопку \"Save\".");
    }

    @Test
    @AllureId("7209")
    @DisplayName("Добавление счёта c ненулевым остатком")
    @Owner("allure8")
    @Tag("local")
    public void test2() {
        step("Нажать \"+\" в левом нижнем углу экрана.");
        step("В поле Title ввести \"Test account\", в поле Currency в выпадающем списке выбрать валюту RUB. Нажать OK.");
        step("В поле Opening amount ввести 2000.");
    }

    @Test
    @AllureId("7200")
    @DisplayName("Добавление счёта c нулевым остатком")
    @Owner("allure8")
    @Tag("local")
    public void test3() {
        step("Нажать \"+\" в левом нижнем углу экрана.");
        step("В поле Title ввести \"Test account\", в поле Currency в выпадающем списке выбрать валюту RUB. Нажать OK.");
    }

    @Test
    @AllureId("7210")
    @DisplayName("Получение отчёта по счёту. За период")
    @Owner("allure8")
    @Tag("local")
    public void test4() {
        step("В списке счетов кликнуть левой кнопкой мыши по счёту \"My First Account\".");
        step("В открывшейся панели доступных действий выбрать \"Transaction\". ");
        step("Щёлкнуть левой кнопкой мыши на \"-\" рядом с полем Amount. ");
        step("Щёлкнуть левой кнопкой мыши в поле Amount, ввести 1500.");
        step("Нажать кнопку \"Save\".");
        step("Выбрать вкладку \"Reports\".");
        step("Выбрать вкладку \"By Period\".");
    }

    @Test
    @AllureId("7205")
    @DisplayName("Редактирование счёта. Изменение названия")
    @Owner("allure8")
    @Tag("local")
    public void test5() {
        step("В списке счетов кликнуть левой кнопкой мыши по счёту \"My First Account\".");
        step("В открывшейся панели доступных действий выбрать \"Edit\".");
        step("В поле Title ввести \"Test Account\".");
    }

    @Test
    @AllureId("7206")
    @DisplayName("Редактирование счёта. Изменение начальной суммы")
    @Owner("allure8")
    @Tag("local")
    public void test6() {
        step("В списке счетов кликнуть левой кнопкой мыши по счёту \"My First Account\".");
        step("В открывшейся панели доступных действий выбрать \"Balance\". ");
        step("Щёлкнуть левой кнопкой мыши в поле Amount и ввести 1000.");
        step("Нажать кнопку \"Save\".");
    }

    @Test
    @AllureId("7201")
    @DisplayName("Удаление счёта")
    @Owner("allure8")
    @Tag("local")
    public void test7() {
        step("В списке счетов кликнуть левой кнопкой мыши по счёту \"My First Account\".");
        step("В открывшейся панели доступных действий выбрать \"Delete account\". Нажать OK.");
        step("В окне подтверждения операции удаления выбрать \"Yes\".");
    }
}
