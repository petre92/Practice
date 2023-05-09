import StepObject.ProductsPageSteps;
import Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;


public class ProductsPageTest extends ChromeRunner {

    ProductsPageSteps productsPageSteps = new ProductsPageSteps();

    @Test
    @Description("4. Approve message appears after adding product to Cart")
    @Severity(SeverityLevel.NORMAL)
    public void AddToCartMessageTest() {
        productsPageSteps.ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder();
        Assert.assertTrue(productsPageSteps.approveMessage.is(Condition.not(Condition.visible)));
                productsPageSteps.AddOneProductToCart();
        Assert.assertTrue(productsPageSteps.approveMessage.is(Condition.visible),
                "პროდუქტი წარმატებით დაემატა კალათაში");
    }

    @Test
    @Description("5. Verifying product's name is shown correctly in Cart")
    @Severity(SeverityLevel.CRITICAL)
    public void CompareProductName() {
        productsPageSteps.ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddOneProductToCart();
        String productsNameInList = productsPageSteps.itemTitle.getText();
        productsPageSteps.ClickOnCart();
        String productsNameInCart = productsPageSteps.itemTitleInCart.getText();
        Assert.assertEquals(productsNameInCart, productsNameInList,
                "Product's name in Cart is the same as in List" );

    }

    @Test
    @Description("7. Verifying product's code is shown correctly in Cart")
    @Severity(SeverityLevel.NORMAL)
    public void CompareProductCode() {
        productsPageSteps.ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddOneProductToCart();
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
        productsPageSteps.ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .IncreaseProductQuantity()
                .AddOneProductToCart();
        String productQuantityInList = productsPageSteps.itemsQuantityInList.getValue();
        productsPageSteps.ClickOnCart();
        String productsQuantityInCart = productsPageSteps.itemsQuantityInCart.getValue();
        Assert.assertEquals(productsQuantityInCart, productQuantityInList,
                "Product's quantity in Cart is the same as in List");
    }

    @Test
    @Description("9. Verifying product's price is shown correctly in Cart")
    @Severity(SeverityLevel.NORMAL)
    public void CompareProductPrice() {
        productsPageSteps.ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddOneProductToCart()
                .SavePrice()
                .ClickOnCart()
                .SavePriceInCart();
        System.out.println(productsPageSteps.productPriceInList);
        System.out.println(productsPageSteps.productsPriceInCart);
        Assert.assertEquals(productsPageSteps.productPriceInList, productsPageSteps.productsPriceInCart,
                "Product's price in Cart is the same as in List");
    }

    @Test
    @Description("9. Verifying product's price sum is shown correctly in Cart")
    @Severity(SeverityLevel.NORMAL)
    public void CompareProductSum() {
        productsPageSteps.ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddOneProductToCart()
                .SavePrice();
        System.out.println(productsPageSteps.productPriceInList);
                productsPageSteps.ClickOnCart()
                .SavePriceSumInCart();
        System.out.println(productsPageSteps.productPriceSumInCart);
        Assert.assertEquals(productsPageSteps.productPriceInList, productsPageSteps.productPriceSumInCart,
                "Product's price sum in Cart is the same as in List");
    }

}
