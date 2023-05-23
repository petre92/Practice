package StepObject;
import PageObject.InvoicePage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import java.time.Duration;

public class InvoicePageSteps extends InvoicePage {
    ProductsPageSteps productsPageSteps = new ProductsPageSteps();
    CartPageSteps cartPageSteps = new CartPageSteps();

    @Step("Click on Continue button")
    public InvoicePageSteps ClickOnContinueBtn() {
        cartPageSteps.continueBtn.click();
        cartPageSteps.continueBtn.shouldNotBe(Condition.visible, Duration.ofMillis(2000));
        return this;
    }
    @Step("Click on Send button")
    public InvoicePageSteps ClickOnSendBtn() {
        sendBtn.click();
        return this;
    }
    @Step("Enter company name to the company's Name field: {company_name}")
    public InvoicePageSteps EnterCompanyName(String company_name) {
       companyName.setValue(company_name);
        return this;
    }
    @Step("Enter data to the company's Code field: {data}")
    public InvoicePageSteps EnterCompanyCode(String data) {
        companyCode.setValue(data);
        return this;
    }
    @Step("Enter some text to the company's Address field: {address}")
    public InvoicePageSteps EnterCompanyAddress(String address) {
        companyAddress.setValue(address);
        return this;
    }
    @Step("Enter data to the company's Phone field: {phone}")
    public InvoicePageSteps EnterCompanyPhone(String phone) {
        companyPhone.setValue(phone);
        return this;
    }
    @Step("Enter data to the company's Desired Date field: {date}")
    public InvoicePageSteps EnterDesiredDate(String date) {
        companyDesiredDate.setValue(date);
        return this;
    }
    @Step("Enter data to the company's Email field: {email}")
    public InvoicePageSteps EnterEmail(String email) {
        companyEmail.setValue(email);
        return this;
    }
}
