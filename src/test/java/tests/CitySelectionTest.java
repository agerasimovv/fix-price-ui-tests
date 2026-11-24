package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PageObjectLocal;

public class CitySelectionTest extends TestBase {
    private final PageObjectLocal pageObject = new PageObjectLocal();

    @Feature("Настройка региона")
    @Story("Выбор города доставки")
    @Owner("agerasimovv")
    @DisplayName("Проверка настройки региона")
    @Link(url = "https://fix-price.com/")
    @Test
    public void shouldSelectCity() {
        pageObject.prepareSite("Екатеринбург")
                .checkCity("Екатеринбург");
    }














}
