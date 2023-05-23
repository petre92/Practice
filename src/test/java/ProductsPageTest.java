import StepObject.ProductsPageSteps;
import Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsPageTest extends ChromeRunner {

    ProductsPageSteps productsPageSteps = new ProductsPageSteps();

    @Test
    @Description("4. Approve message appears after adding product to Cart")
    @Severity(SeverityLevel.NORMAL)
    public void AddToCartMessageTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder();
        Assert.assertTrue(productsPageSteps.approveMessage.is(Condition.not(Condition.visible)) ,
                "Approve message is not visible");
                productsPageSteps.AddThirdProductToCart();
        Assert.assertTrue(productsPageSteps.approveMessage.is(Condition.visible),
                "Approve message is visible");
    }
    @Test
    @Description("5. Verifying product's name is shown correctly in Cart")
    @Severity(SeverityLevel.CRITICAL)
    public void CompareProductName() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart();
        String productsNameInList = productsPageSteps.itemTitle.getText();
        productsPageSteps.ClickOnCart();
        String productsNameInCart = productsPageSteps.itemTitleInCart.getText();
        Assert.assertEquals(productsNameInCart, productsNameInList,
                "Product's name in Cart is the same as in List" );
    }
    @Test
    @Description("6. Verifying product's color is shown correctly in Cart")
    @Severity(SeverityLevel.NORMAL)
    public void CompareProductColor() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .ClickOnDropDown()
                .ChooseBlackColor()
                .AddFirstProductToCart()
                .ClickOnCart();
       Assert.assertTrue(productsPageSteps.blackColor.is(Condition.visible),
               "Black product color is shown in Cart");
       Assert.assertTrue(productsPageSteps.redColor.is(Condition.not(Condition.visible)),
               "Red product color is not shown in Cart");
    }
    @Test
    @Description("7. Verifying product's code is shown correctly in Cart")
    @Severity(SeverityLevel.NORMAL)
    public void CompareProductCode() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart();
        String productsCodeInList = productsPageSteps.itemCode.getText();
        productsPageSteps.ClickOnCart();
        String productsCodeInCart = productsPageSteps.itemCodeInCart.getText();
        Assert.assertEquals(productsCodeInCart, productsCodeInList,
                "Product's code in Cart is the same as in List" );
    }
    @Test
    @Description("8. Verifying product's quantity is shown correctly in Cart")
    @Severity(SeverityLevel.NORMAL)
    public void CompareProductQuantity() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .IncreaseProductQuantity()
                .AddThirdProductToCart();
        String productQuantityInList = productsPageSteps.itemsQuantityInList.getValue();
        productsPageSteps.ClickOnCart();
        String productsQuantityInCart = productsPageSteps.itemsQuantityInCart.getValue();
        Assert.assertEquals(productsQuantityInCart, productQuantityInList,
                "Product's quantity in Cart is the same as in List");
    }
    @Test
    @Description("9. Verifying product's price is shown correctly in Cart")
    @Severity(SeverityLevel.CRITICAL)
    public void CompareProductPrice() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .SavePrice()
                .ClickOnCart()
                .SavePriceInCart();
        System.out.println(productsPageSteps.productPriceInList);
        System.out.println(productsPageSteps.productsPriceInCart);
        Assert.assertEquals(productsPageSteps.productPriceInList, productsPageSteps.productsPriceInCart,
                "Product's price in Cart is the same as in List");
    }
    @Test
    @Description("10. Verifying product's price sum is shown correctly in Cart")
    @Severity(SeverityLevel.CRITICAL)
    public void CompareProductSum() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .SavePrice();
        System.out.println(productsPageSteps.productPriceInList);
        productsPageSteps
                .ClickOnCart()
                .SavePriceSumInCart();
        System.out.println(productsPageSteps.productPriceSumInCart);
        Assert.assertEquals(productsPageSteps.productPriceInList, productsPageSteps.productPriceSumInCart,
                "Product's price sum in Cart is the same as in List");
    }

}
