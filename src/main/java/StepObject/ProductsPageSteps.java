package StepObject;
import PageObject.ProductsPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import java.time.Duration;

public class ProductsPageSteps extends ProductsPage {
    @Step("Click on Products button")
    public ProductsPageSteps ClickProducts() {
        productsCategory.click();
        return this;
    }
    @Step("Click on first category")
    public ProductsPageSteps ChooseFirstCategory() {
        firstCategory.click();
        return this;
    }
    @Step("Click on Binder button")
    public ProductsPageSteps ChooseBinder() {
        binder.click();
        return this;
    }
    @Step("Add third product to cart")
    public ProductsPageSteps AddThirdProductToCart() {
        addProductToCart.click();
        approveMessage.shouldBe(Condition.visible, Duration.ofMillis(2000));
        return this;
    }
    @Step("Go to Cart")
    public ProductsPageSteps ClickOnCart() {
        cart.click();
        return this;
    }
    @Step("Click on first product's color dropdown")
    public ProductsPageSteps ClickOnDropDown() {
        dropdown.click();
        return this;
    }
    @Step("Choose black product color")
    public ProductsPageSteps ChooseBlackColor() {
        blackColor.click();
        return this;
    }
    @Step("Add first product to cart")
    public ProductsPageSteps AddFirstProductToCart() {
        firstProduct.click();
        approveMessage.shouldBe(Condition.visible, Duration.ofMillis(2000));
        return this;
    }
    @Step("Increase product's quantity by one")
    public ProductsPageSteps IncreaseProductQuantity() {
        plusItemQuantity.click();
        return this;
    }
    @Step("Save product's price in products list")
    public ProductsPageSteps SavePrice() {
        productPriceInList = Double.parseDouble
                (itemsPrice
                .innerText()
                .replace(" ", "")
                .replace("A", ""));
        return this;
    }
    @Step("Save product's price in Cart")
    public ProductsPageSteps SavePriceInCart() {
        productsPriceInCart = Double.parseDouble
                (itemsPriceInCart
                        .innerText()
                        .replace(" ", "")
                        .replace("A", ""));
        return this;
    }
    @Step("Save product's price sum in Cart")
    public ProductsPageSteps SavePriceSumInCart() {
        productPriceSumInCart = Double.parseDouble
                (itemsPriceSum
                        .innerText()
                        .replace(" ", "")
                        .replace("A", ""));
        return this;
    }
}
