package PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    public SelenideElement

    increaseProductQuantity = $(byClassName("fa-plus"), 0),
    decreaseProductQuantity = $(byClassName("fa-minus"), 0),
    deleteProduct = $(byClassName("fa-times")),
    deleteAllProducts = $(byText("კალათის გასუფთავება")),
    emptyCartText = $(byText("კალათა ცარიელია")),
    continueBtn = $(byClassName("continue"));

    public Double
    originalSum, productPriceCart, productQuantityInCart;

}
