package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import helpers.Attach;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class PageObjectLocal {
    private final String TEST_URL = "https://fix-price.com/";

    private final SelenideElement
            setProductInput = $(".input"),
            addProductInput = $(".button-add-to-cart"),
            deliveryProductInput = $(byText("Доставка")),
            deliveryAddressInput = $(Selectors.byName("address")),
            dropdownInput = $(".dropdown"),
            toggleWrapInput = $(".courier-type-selector-wrapper.wrapper").$$(".toggle").get(0),
            buttonInput =  $(".buttons"),
             cookiesInput = $(byText("Понятно")),
            buttonPrimaryInput = $(".button.normal.primary"),
            closeButton = $("#modal .close"),
            checkProductInput = $(".page-content"),
            cityButton = $(".button.small.secondary"),
            cityInput = $("[data-test='currentCity']"),
            cityOption = $(".city"),
            changeCityButton = $(byText("Изменить город"));
    ElementsCollection
            wrapperInput = $$(".courier-form .wrapper");
    //buttonNormPrimaryInput = $$(".button.normal.primary.full-width");

    public PageObjectLocal selectCity(String cityName) {
        step("Выбираем город " + cityName, () -> {
            cityButton.click();
            cityInput.setValue(cityName);
            cityOption.click();
            changeCityButton.click();
        });
        return this;
    }
    public PageObjectLocal prepareSite (String cityName) {
        openPage();
        closeAdIfVisible();
        closeCookiesIfVisible();
        selectCity(cityName);
        closeAdIfVisible();
        return this;
    }

    public PageObjectLocal closeAdIfVisible() {
        step("Закрываем рекламу, если появилась", () -> {
            if (closeButton.is(visible, Duration.ofSeconds(5))) {
                closeButton.click();
                closeButton.shouldNotBe(visible);
            }
        });
        return this;
    }
    public PageObjectLocal closeCookiesIfVisible() {
        step("Соглашаемся на обработку файлов cookie, если появилась", () -> {
            if (cookiesInput.is(visible)) {
                cookiesInput.click();}
        });
        return this;
    }

    public PageObjectLocal openPage() {
        step("Открываем страницу " + TEST_URL, () ->
                open(TEST_URL));
        return this;
    }
    public PageObjectLocal setProduct() {
        step("Выбираем товар ", () ->
                setProductInput.setValue("Контейнер").pressEnter());
        return this;
    }
    public PageObjectLocal addProduct() {
        step("Добавили товар", () ->
                addProductInput.click());
        return this;
    }
    public PageObjectLocal choiceDeliveryProduct() {
        step("Выбираем способ получения товара", () ->
                deliveryProductInput.click());
        return this;
    }

    public PageObjectLocal deliveryAddress() {
        step("Выбираем адрес", () -> {
            deliveryAddressInput.setValue("Екатеринбург улица Щорса, дом 64");
            dropdownInput.$(byText("г Екатеринбург, ул Щорса, д 64"))
                    .shouldBe(visible,Duration.ofSeconds(15)).click();
            sleep(5000);
            deliveryAddressInput.shouldHave(value("г Екатеринбург, ул Щорса, д 64"),
            Duration.ofSeconds(15));
            wrapperInput.get(0).$("input").setValue("2");
            wrapperInput.get(1).$("input").setValue("1");
            wrapperInput.get(2).$("input").setValue("5");
            Attach.screenshotAs("После выбора адресса");
            $(byText("Адрес не определён")).shouldBe(hidden,Duration.ofSeconds(15));
        });
        return this;

    }
    public PageObjectLocal deliveryDayProduct() {
        step("Выбиаем доставку от 1 дня ", () ->
                toggleWrapInput.shouldBe(clickable).click());
        Attach.screenshotAs("После выбора доставки");
        sleep(120000);
        return this;
    }
    public PageObjectLocal confirmDelivery() {
        step("Подтверждаем доставку ", () ->
                buttonInput.click());
        Attach.screenshotAs("После подтверждения доставки");
        return this;
    }
//    public PageObjectLocal infoWindow() {
//        step("Нажимаем хорошо ", () ->
//                buttonNormPrimaryInput.get(1).click());
//        return this;
//    }
    public PageObjectLocal infoDelivery() {
        step(" Нажимаем хорошо ", () ->
                buttonPrimaryInput.click());
        return this;
    }
    public PageObjectLocal checkProduct() {
        step("Проверяем товар ", () ->
                checkProductInput.shouldHave(text("Контейнер квадратный")));
        return this;
    }

}

