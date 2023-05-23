package StepObject;
import PageObject.SearchBox;
import io.qameta.allure.Step;
import static DataObject.SearchBoxData.correctProductName;
import static DataObject.SearchBoxData.incorrectProductName;

public class SearchBoxSteps extends SearchBox {

    @Step("Click on Search Products button")
    public SearchBoxSteps ClickSearchProducts() {
        searchProductsBtn.click();
        return this;
    }
    @Step("Enter correct product name: {product_name}")
    public SearchBoxSteps EnterProductName(String product_name) {
        searchBoxInput.setValue(product_name);
        return this;
    }
    @Step("Click Search Results Button")
    public SearchBoxSteps ClickSearchResults() {
        searchResultsBtn.click();
        return this;
    }
    @Step("Enter incorrect product name: {incorrectProductName}")
    public SearchBoxSteps EnterIncorrectName() {
        searchBoxInput.setValue(incorrectProductName);
        return this;
    }
}

