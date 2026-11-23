package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.PageObjectLocal;

import static com.codeborne.selenide.CollectionCondition.exactTexts;

import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static testdata.FooterTestData.*;

public class ValidationTest extends TestBase {
    PageObjectLocal pageObject = new PageObjectLocal();

    @Feature("Входим на сайт")
    @Story("Валидация заголовков и разделов сайта")
    @Owner("agerasimovv")
    @Link(name = "AutoTest(Validation)", url = "https://fix-price.com/")
    @Test
    void Validation(){
        pageObject.prepareSite("Екатеринбург");
        step("Проверка валидации шапки ", () ->
        $$(".middle-wrapper").shouldHave(exactTexts(
                HEADERS_TEXTS)));
        step(" Проверка валадиции верхнего раздела заголовков ", () ->
        $$(".bottom-wrapper").shouldHave(exactTexts(
                BOTTOM_WRAPPER_TEXTS)));
        step("Поверка валидации нижнего раздела заголовков", () ->
        $$(".menu-column:not(.social.menu-column)").shouldHave(exactTexts(
                FOOTER_TEXTS)));

    }
}
