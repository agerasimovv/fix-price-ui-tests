package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

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
            buttonInput = $(".courier-form .buttons button"),
            cookiesInput = $(byText("Понятно")),
            buttonPrimaryInput = $(".button.normal.primary"),
            closeButton = $("#modal .close"),
            checkProductInput = $(".page-content"),
            cityButton = $(".button.small.secondary"),
            cityInput = $("[data-test='currentCity']"),
            cityOption = $(".city"),
            cityObtain =$(".geo"),
            changeCityButton = $(byText("Изменить город"));
    private final ElementsCollection
            wrapperInput = $$(".courier-form .wrapper");

    public PageObjectLocal selectCity(String cityName) {
        step("Выбираем город " + cityName, () -> {
            cityButton.click();
            cityInput.setValue(cityName);
            cityOption.click();
            changeCityButton.click();
        });
        return this;
    }
    public PageObjectLocal checkCity(String cityName){
        step("Проверяем выбранный город" + cityName, () ->
                cityObtain.shouldHave(exactText(cityName)));
        return this;
    }

    public PageObjectLocal prepareSite(String cityName) {
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
                cookiesInput.click();
            }
        });
        return this;
    }

    public PageObjectLocal openPage() {
        step("Открываем страницу " + TEST_URL, () ->
                open(TEST_URL));
        return this;
    }

    public PageObjectLocal setProduct() {
        step("Ищем товар по названию ", () ->
                setProductInput.setValue("Контейнер").pressEnter());
        return this;
    }

    public PageObjectLocal addProduct() {
        step("Добавляем товар в корзину", () ->
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
            //Временная задержка для стабилизации выбора адреса
            sleep(5000);
            dropdownInput.$(byText("г Екатеринбург, ул Щорса, д 64"))
                    .shouldBe(visible, Duration.ofSeconds(15)).click();
            $(byText("Расширенный каталог")).shouldBe(visible, Duration.ofSeconds(20));
            $(byText("от 1 дня")).shouldBe(visible, Duration.ofSeconds(20));
            $(byText("Адрес не определен")).shouldBe(hidden, Duration.ofSeconds(20));

            deliveryAddressInput.shouldHave(value("г Екатеринбург, ул Щорса, д 64"));
            wrapperInput.get(0).$("input").setValue("2");
            wrapperInput.get(1).$("input").setValue("1");
            wrapperInput.get(2).$("input").setValue("5");
        });
        return this;

    }

    public PageObjectLocal deliveryDayProduct() {
        step("Выбираем доставку от 1 дня ", () ->
                toggleWrapInput.shouldBe(clickable).click());
        return this;
    }

    public PageObjectLocal confirmDelivery() {
        step("Подтверждаем доставку ", () ->
                buttonInput
                        .shouldBe(visible, Duration.ofSeconds(20))
                        .shouldBe(enabled, Duration.ofSeconds(20))
                        .shouldHave(exactText("Доставить сюда")).click());
        return this;
    }

    public PageObjectLocal infoDelivery() {
        step("Подтверждаем информационное окно", () ->
                buttonPrimaryInput.click());
        return this;
    }

    public PageObjectLocal checkProduct() {
        step("Проверяем отображение товара", () ->
                checkProductInput.shouldHave(text("Контейнер квадратный")));
        return this;
    }

}

