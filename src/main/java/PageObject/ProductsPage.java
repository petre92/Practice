package PageObject;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {

    public SelenideElement
            productsCategory = $(byText("პროდუქცია")),
            firstCategory = $(byText("საკანცელარიო ნივთები")),
            binder = $(byText("ბაინდერი")),
            addProductToCart = $(byClassName("add_cart"), 2),
            approveMessage = $(byText("პროდუქტი წარმატებით დაემატა კალათაში")),
            itemTitle = $(byClassName("prod_title"), 2),
            cart = $(byClassName("junior-span")),
            itemTitleInCart = $(byClassName("item_title")),
            firstProduct = $(byClassName("add_cart"), 0),
            dropdown = $(byClassName("fa-angle-down"), 0),
            blackColor = $(by("data-color", "#000000")),
            redColor = $(by("data-color", "#ff2600")),
            itemCode = $(byClassName("prod_id"), 2),
            itemCodeInCart = $(byClassName("item_id")),
            plusItemQuantity = $(byClassName("add"), 2),
            itemsQuantityInList = $(byClassName("inputvalue"), 2),
            itemsQuantityInCart = $(byClassName("inputvalue")),
            itemsPrice = $(byClassName("price"), 6),
            itemsPriceInCart = $(byClassName("prod_price")),
            itemsPriceSum = $(byClassName("fullPriceFor"));

    public Double
            productPriceInList, productsPriceInCart, productPriceSumInCart;
}
