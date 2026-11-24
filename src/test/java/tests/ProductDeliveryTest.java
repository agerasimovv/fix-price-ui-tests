package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PageObjectLocal;

public class ProductDeliveryTest extends TestBase {
    PageObjectLocal pageObject = new PageObjectLocal();

    @Feature("Корзина и доставка")
    @Story("Добавление товара с выбором доставки")
    @Owner("agerasimovv")
    @DisplayName("Проверка добавления товара и настройки доставки")
    @Link(url = "https://fix-price.com/")
    @Test
    void shouldConfigureProductDelivery(){
        pageObject.prepareSite("Екатеринбург");
        pageObject.setProduct()
                .addProduct()
                .choiceDeliveryProduct()
                .deliveryAddress()
                .deliveryDayProduct()
                .confirmDelivery()
                //.infoWindow()
                .infoDelivery()
                .checkProduct();
    }
}
