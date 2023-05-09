package StepObject;
import PageObject.SearchBox;
import io.qameta.allure.Step;

import static DataObject.SearchBoxData.correctProductName;
import static DataObject.SearchBoxData.incorrectProductName;
import static com.codeborne.selenide.Selenide.sleep;

public class SearchBoxSteps extends SearchBox {

    @Step("Click on Search Products button")
    public SearchBoxSteps ClickSearchProducts() {
        searchProductsBtn.click();
        return this;
    }

    @Step("Enter Correct Product Name")
    public SearchBoxSteps EnterCorrectName() {
        searchBoxInput.setValue(correctProductName);
        return this;
    }

    @Step("Click Search Results Button")
    public SearchBoxSteps ClickSearchResults() {
        searchResultsBtn.click();
        return this;
    }

    @Step("Click Search Results Button")
    public SearchBoxSteps EnterIncorrectName() {
        searchBoxInput.setValue(incorrectProductName);
        return this;
    }





}

