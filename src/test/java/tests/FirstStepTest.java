package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.PageObjectLocal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class FirstStepTest extends TestBase {
    PageObjectLocal pageObject = new PageObjectLocal();

    @Feature("Входим на сайт")
    @Story("Настроиваем местопложение,cookies")
    @Owner("agerasimovv")
    @Link(name = "AutoTest(FirstStep)", url = "https://fix-price.com/")
    @Test
    public void openSite() {
        pageObject.openPage();
        step("Закрываем рекламу", () ->
                pageObject.closeAdIfVisible());

        step("Соглашаемся на обработку файлов cookie", () ->
                pageObject.closeCookiesIfVisible());

        step("Выбираем город", () -> {
     $(".button.small.secondary").click();
     $(".input").setValue("Екатеринбург");
     $(".city").click();
     $(byText("Изменить город")).click();});
    }














}
