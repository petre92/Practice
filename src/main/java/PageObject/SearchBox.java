package PageObject;
import com.codeborne.selenide.SelenideElement;
import static DataObject.SearchBoxData.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class SearchBox {

    public SelenideElement

            searchBoxField = $(byId("searchmodal")),
            searchProductsBtn = $(byText("პროდუქტის ძიება")),
            searchBoxInput = $(by("onkeyup", "livesearch(this.value)")),
            searchResultsBtn = $(byClassName("fa-search"), 1),
            correctSearchResult = $(byText(correctProductName)),
            incorrectSearchResult = $(byClassName("search_result"));
}
