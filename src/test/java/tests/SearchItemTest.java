package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.PageObjectLocal;

public class SearchItemTest extends TestBase {
    PageObjectLocal pageObject = new PageObjectLocal();

    @Feature("Добавляем товар в корзину")
    @Story("Выбираем валидные данные доставки")
    @Owner("agerasimovv")
    @Link(name = "AutoTest(AddProduct)", url = "https://fix-price.com/")
    @Test
    void addItem(){
        pageObject.prepareSite("Екатеринбург");
        pageObject.setProduct()
                .addProduct()
                .choiceDeliveryProduct()
                .deliveryAddress()
                .deliveryDayProduct()
                .confirmDelivery()
                .infoWindow()
                .infoDelivery()
                .checkProduct();
    }
}
