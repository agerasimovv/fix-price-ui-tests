package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PageObjectLocal;

import static com.codeborne.selenide.CollectionCondition.exactTexts;

import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static testdata.FooterTestData.*;

public class NavigationContentTest extends TestBase {
    PageObjectLocal pageObject = new PageObjectLocal();

    @Feature("Навигация сайта")
    @Story("Отображение элементов навигации")
    @Owner("agerasimovv")
    @DisplayName("Заголовки, меню и футер отображаются корректно")
    @Link(url = "https://fix-price.com/")
    @Test
    void shouldDisplayExpectedNavigationAndFooterTexts(){
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
