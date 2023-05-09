import StepObject.SearchBoxSteps;
import Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DataObject.SearchBoxData.*;

public class SearchBoxTest extends ChromeRunner {

    SearchBoxSteps searchBoxSteps = new SearchBoxSteps();
    @Test
    @Description("1. After clicking on the search button, an input field appears")
    @Severity(SeverityLevel.NORMAL)
    public void SearchBoxAppearsTest() {
        Assert.assertTrue(searchBoxSteps.searchBoxField.is(Condition.not(Condition.visible)),
                "The search input field is not visible");
        searchBoxSteps.ClickSearchProducts();
        Assert.assertTrue(searchBoxSteps.searchBoxField.is(Condition.visible),
                "The search input field is visible");
    }

    @Test
    @Description("2. Verifying the correct product name is shown in the search result")
    @Severity(SeverityLevel.NORMAL)
    public void SearchCorrectProductTest() {
        searchBoxSteps.ClickSearchProducts()
                .EnterCorrectName()
                .ClickSearchResults();
        Assert.assertTrue(searchBoxSteps.correctSearchResult.is(Condition.visible),
                "Correct product name is shown in the search result");
    }

    @Test
    @Description("3. Verifying the incorrect product name search result ")
    @Severity(SeverityLevel.NORMAL)
    public void SearchIncorrectProductTest() {
        searchBoxSteps.ClickSearchProducts()
                .EnterIncorrectName()
                .ClickSearchResults();
        Assert.assertEquals(searchBoxSteps.incorrectSearchResult.getText(), errorSearchMessage,
                "Search error message is visible");
    }
}