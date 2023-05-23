import StepObject.CartPageSteps;
import StepObject.ProductsPageSteps;
import Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends ChromeRunner {

    ProductsPageSteps productsPageSteps = new ProductsPageSteps();
    CartPageSteps cartPageSteps = new CartPageSteps();


    @Test
    @Description("11. Sum price increases according to the product's quantity")
    @Severity(SeverityLevel.NORMAL)
    public void IncreasedSumPriceTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart()
                .SavePriceInCart();
        cartPageSteps
                .IncreaseProductQuantityInCart()
                .SaveQuantityInCart();
        productsPageSteps
                .SavePriceSumInCart();
       double expectedSum = productsPageSteps.productsPriceInCart * cartPageSteps.productQuantityInCart;
        Assert.assertEquals(productsPageSteps.productPriceSumInCart, expectedSum,
                "Expected and actual results are the same");
        System.out.println(productsPageSteps.productPriceSumInCart);
        System.out.println(expectedSum);
    }
    @Test
    @Description("12. Sum price decreases according to the product's quantity")
    @Severity(SeverityLevel.NORMAL)
    public void DecreasedSumPriceTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        cartPageSteps
                .IncreaseProductQuantityInCart()
                .DecreaseProductQuantityInCart();
        productsPageSteps
                .SavePriceSumInCart()
                .SavePriceInCart();
        Assert.assertEquals(productsPageSteps.productPriceSumInCart, productsPageSteps.productPriceSumInCart,
                "Sum price equals to product's price after being decreased");
        System.out.println(productsPageSteps.productPriceSumInCart);
        System.out.println(productsPageSteps.productPriceSumInCart);
    }
    @Test
    @Description("13. One product is deleted from Cart")
    @Severity(SeverityLevel.CRITICAL)
    public void DeleteOneProductTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        Assert.assertTrue(productsPageSteps.itemTitleInCart.is(Condition.visible),
                "Product's name is visible in Cart");
        cartPageSteps.DeleteOneProduct();
        Assert.assertTrue(productsPageSteps.itemTitleInCart.is(Condition.not(Condition.visible)),
                "Product's name is not visible in Cart");
    }
    @Test
    @Description("14. Several products are deleted from Cart")
    @Severity(SeverityLevel.CRITICAL)
    public void DeleteSeveralProductsTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .AddFirstProductToCart()
                .ClickOnCart();
        Assert.assertTrue(productsPageSteps.itemTitleInCart.is(Condition.visible),
                "Product names are visible in Cart");
        cartPageSteps.DeleteAllProducts();
        Assert.assertTrue(productsPageSteps.itemTitleInCart.is(Condition.not(Condition.visible)),
                "Product names are not visible in Cart");
    }
    @Test
    @Description("15. Empty Cart message appears after deleting all products")
    @Severity(SeverityLevel.NORMAL)
    public void EmptyCartMessageTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .AddFirstProductToCart()
                .ClickOnCart();
        Assert.assertTrue(cartPageSteps.emptyCartText.is(Condition.not(Condition.visible)),
                "Empty Cart message is not visible");
        cartPageSteps.DeleteAllProducts();
        Assert.assertTrue(cartPageSteps.emptyCartText.is(Condition.visible),
                "Empty Cart message is visible");
    }
    @Test
    @Description("16. Continue button disappears after deleting all products")
    @Severity(SeverityLevel.NORMAL)
    public void ContinueBtnTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .AddFirstProductToCart()
                .ClickOnCart();
        Assert.assertTrue(cartPageSteps.continueBtn.is(Condition.visible),
                "Continue button is visible");
        cartPageSteps.DeleteAllProducts();
        Assert.assertTrue(cartPageSteps.continueBtn.is(Condition.not(Condition.visible)),
                "Continue button is not visible");
    }
    @Test
    @Description("17. EmptyCart button disappears after deleting all products")
    @Severity(SeverityLevel.NORMAL)
    public void EmptyCartBtnTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .AddFirstProductToCart()
                .ClickOnCart();
        Assert.assertTrue(cartPageSteps.deleteAllProducts.is(Condition.visible),
                "EmptyCart button is visible");
        cartPageSteps.DeleteAllProducts();
        Assert.assertTrue(cartPageSteps.deleteAllProducts.is(Condition.not(Condition.visible)),
                "EmptyCart button is not visible");
    }
}
