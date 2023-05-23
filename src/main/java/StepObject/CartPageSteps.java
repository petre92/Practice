package StepObject;
import PageObject.CartPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import java.time.Duration;

public class CartPageSteps extends CartPage {
    ProductsPageSteps productsPageSteps = new ProductsPageSteps();

    @Step("Save product's quantity in Cart")
    public CartPageSteps SaveQuantityInCart() {
      productQuantityInCart = Double.parseDouble(productsPageSteps.itemsQuantityInCart.getValue());
        return this;
    }
    @Step("Increase product quantity in Cart")
    public CartPageSteps IncreaseProductQuantityInCart() {
        increaseProductQuantity.click();
        return this;
    }
    @Step("Decrease product's quantity in Cart")
    public CartPageSteps DecreaseProductQuantityInCart() {
        decreaseProductQuantity.click();
        return this;
    }
    @Step("Delete one product from Cart")
    public CartPageSteps DeleteOneProduct() {
        deleteProduct.click();
        deleteProduct.shouldNotBe(Condition.visible, Duration.ofMillis(2000));
        return this;
    }
    @Step("Delete all products from Cart")
    public CartPageSteps DeleteAllProducts() {
        deleteAllProducts.click();
        deleteProduct.shouldNotBe(Condition.visible, Duration.ofMillis(2000));
        return this;
    }

}
