import StepObject.CartPageSteps;
import StepObject.InvoicePageSteps;
import StepObject.ProductsPageSteps;
import Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import static DataObject.InvoicePageData.*;

public class InvoicePageTest extends ChromeRunner {

    ProductsPageSteps productsPageSteps = new ProductsPageSteps();
    CartPageSteps cartPageSteps = new CartPageSteps();
    InvoicePageSteps invoicePageSteps = new InvoicePageSteps();


    @Test
    @Description("18. Legal entity and individual invoice forms appear")
    @Severity(SeverityLevel.BLOCKER)
    public void InvoiceFormsAppearTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        Assert.assertFalse(invoicePageSteps.legalEntity.is(Condition.visible),
                "Legal entity is not visible");
        Assert.assertFalse(invoicePageSteps.individual.is(Condition.visible),
                "Individual is not visible");
        invoicePageSteps.ClickOnContinueBtn();
        Assert.assertTrue(invoicePageSteps.legalEntity.is(Condition.visible),
                "Legal entity is visible");
        Assert.assertTrue(invoicePageSteps.individual.is(Condition.visible),
                "Individual is visible");
    }
    @Test
    @Description("18(2nd version). Legal entity and individual invoice forms appear")
    @Severity(SeverityLevel.BLOCKER)
    public void InvoiceFormsAppearTest_2() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        Assert.assertFalse(invoicePageSteps.getLegalEntityForm.isDisplayed(),
                "Legal entity form is not visible");
        Assert.assertFalse(invoicePageSteps.individualForm.isDisplayed(),
                "Individual form is not visible");
        invoicePageSteps.ClickOnContinueBtn();
        Assert.assertTrue(invoicePageSteps.getLegalEntityForm.isDisplayed(),
                "Legal entity form is visible");
        invoicePageSteps.ClickOnIndividualBtn();
        Assert.assertTrue(invoicePageSteps.individualForm.isDisplayed(),
                "Individual from is visible");
    }
    @Test
    @Description("19. Company's empty Name field becomes red after clicking Send button")
    @Severity(SeverityLevel.NORMAL)
    public void EmptyNameFieldErrorTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps.ClickOnContinueBtn();
        Assert.assertFalse(invoicePageSteps.companyName.has(Condition.attribute(style,red )),
                "Company name field does not have red border");
                invoicePageSteps.ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyName.has(Condition.attribute(style, red)),
                "Company name field has red border" );
    }
    @Test
    @Description("20. Company's empty Code field becomes red after clicking Send button")
    @Severity(SeverityLevel.NORMAL)
    public void EmptyCodeFieldErrorTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps.ClickOnContinueBtn();
        Assert.assertFalse(invoicePageSteps.companyCode.has(Condition.attribute(style,red )),
                "Company code field does not have red border");
        invoicePageSteps.ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyCode.has(Condition.attribute(style, red)),
                "Company code field has red border" );
    }
    @Test
    @Description("21. Company's empty Address field becomes red after clicking Send button")
    @Severity(SeverityLevel.NORMAL)
    public void EmptyAddressFieldErrorTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps.ClickOnContinueBtn();
        Assert.assertFalse(invoicePageSteps.companyAddress.has(Condition.attribute(style,red)),
                "Company address field does not have red border");
        invoicePageSteps.ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyAddress.has(Condition.attribute(style, red)),
                "Company address field has red border" );
    }
    @Test
    @Description("22. Company's empty Phone field becomes red after clicking Send button")
    @Severity(SeverityLevel.NORMAL)
    public void EmptyPhoneFieldErrorTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps.ClickOnContinueBtn();
        Assert.assertFalse(invoicePageSteps.companyPhone.has(Condition.attribute(style,red)),
                "Company phone field does not have red border");
        invoicePageSteps.ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyPhone.has(Condition.attribute(style,red)),
                "Company phone field has red border" );
    }
    @Test
    @Description("23. Company's empty Desired Date field becomes red after clicking Send button")
    @Severity(SeverityLevel.NORMAL)
    public void EmptyDateFieldErrorTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps.ClickOnContinueBtn();
        Assert.assertFalse(invoicePageSteps.companyDesiredDate.has(Condition.attribute(style,red)),
                "Company Desired Date field does not have red border");
        invoicePageSteps.ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyDesiredDate.has(Condition.attribute(style,red)),
                "Company Desired Date field has red border" );
    }
    @Test
    @Description("24. Company's empty Email field becomes red after clicking Send button")
    @Severity(SeverityLevel.NORMAL)
    public void EmptyEmailFieldErrorTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps.ClickOnContinueBtn();
        Assert.assertFalse(invoicePageSteps.companyEmail.has(Condition.attribute(style,red)),
                "Company email field does not have red border");
        invoicePageSteps.ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyEmail.has(Condition.attribute(style,red)),
                "Company email field has red border" );
    }
    @Test
    @Description("25. Company's filled Name field is not red after clicking Send button")
    @Severity(SeverityLevel.NORMAL)
    public void FilledNameFieldTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps.ClickOnContinueBtn();
        Assert.assertFalse(invoicePageSteps.companyName.has(Condition.attribute(style,red)),
                "Company name field does not have red border");
        invoicePageSteps.ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyName.has(Condition.attribute(style,red)),
                "Company name field has red border" );
        invoicePageSteps
                .EnterCompanyName(companyNameInput)
                .ClickOnSendBtn();
        Assert.assertFalse(invoicePageSteps.companyName.has(Condition.attribute(style,red)),
                "Company name field does not have red border");
    }
    @Test
    @Description("26. Text cannot be written in the company Code field")
    @Severity(SeverityLevel.NORMAL)
    public void TextInCodeFieldErrorTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps
                .ClickOnContinueBtn()
                .EnterCompanyCode(textInput);
        System.out.println(invoicePageSteps.companyCode.getValue());
        System.out.println(textInput);
        Assert.assertNotEquals(invoicePageSteps.companyCode.getValue(), textInput,
                "Text is not written in the company code field");
    }

    @Test
    @Description("27. Less than 9 symbols are entered to the company's Code field, it becomes red after clicking Send button")
    @Severity(SeverityLevel.NORMAL)
    public void ShortCodeErrorTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps.ClickOnContinueBtn();
        Assert.assertFalse(invoicePageSteps.companyCode.has(Condition.attribute(style,red)),
                "Company code field does not have red border");
        invoicePageSteps
                .EnterCompanyCode(eightDigitsInput)
                .ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyCode.has(Condition.attribute(style,red)),
                "Company code field has red border" );
    }
    @Test
    @Description("28. 9 symbols are entered in the company Code field despite entering 10 symbols")
    @Severity(SeverityLevel.NORMAL)
    public void LongCodeErrorTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps
                .ClickOnContinueBtn()
                .EnterCompanyCode(tenDigitsInput);
        Assert.assertEquals(invoicePageSteps.companyCode.getValue().length(), nineDigitsInput.length(),
                "9 symbols are entered in the company code field");
        System.out.println(invoicePageSteps.companyCode.getValue().length());
        System.out.println(nineDigitsInput.length());
    }
    @Test
    @Description("29. 9 symbols are entered in the company Code field, it is not red after clicking Send button")
    @Severity(SeverityLevel.NORMAL)
    public void FilledCodeFieldErrorTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps.ClickOnContinueBtn();
        Assert.assertFalse(invoicePageSteps.companyCode.has(Condition.attribute(style,red)),
                "Company code field does not have red border");
        invoicePageSteps.ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyCode.has(Condition.attribute(style,red)),
                "Company code field has red border" );
        invoicePageSteps
                .EnterCompanyCode(nineDigitsInput)
                .ClickOnSendBtn();
        Assert.assertFalse(invoicePageSteps.companyCode.has(Condition.attribute(style,red)),
                "Company code field does not have red border");
    }
    @Test
    @Description("30. Company's filled Address field is not red after clicking Send button")
    @Severity(SeverityLevel.NORMAL)
    public void FilledAddressFieldTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps.ClickOnContinueBtn();
        Assert.assertFalse(invoicePageSteps.companyAddress.has(Condition.attribute(style,red)),
                "Company address field does not have red border");
        invoicePageSteps.ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyAddress.has(Condition.attribute(style,red)),
                "Company address field has red border" );
        invoicePageSteps
                .EnterCompanyAddress(textInput)
                .ClickOnSendBtn();
        Assert.assertFalse(invoicePageSteps.companyAddress.has(Condition.attribute(style,red)),
                "Company address field does not have red border");
    }
    @Test
    @Description("31. Text cannot be written in the company's Phone field")
    @Severity(SeverityLevel.NORMAL)
    public void TextInPhoneFieldErrorTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps
                .ClickOnContinueBtn()
                .EnterCompanyPhone(textInput);
        System.out.println(invoicePageSteps.companyPhone.getValue());
        System.out.println(textInput);
        Assert.assertNotEquals(invoicePageSteps.companyPhone.getValue(), textInput,
                "Text is not written in the company phone field");
    }
    @Test
    @Description("32. Less than 9 digits are entered in the company's Phone field, it becomes red after clicking Send button")
    @Severity(SeverityLevel.NORMAL)
    public void ShortPhoneErrorTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps.ClickOnContinueBtn();
        Assert.assertFalse(invoicePageSteps.companyPhone.has(Condition.attribute(style,red)),
                "Company phone field does not have red border");
        invoicePageSteps
                .EnterCompanyPhone(eightDigitsInput)
                .ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyPhone.has(Condition.attribute(style,red)),
                "Company phone field has red border" );
    }
    @Test
    @Description("33. 9 digits are entered in the company Phone field despite entering 10 digits")
    @Severity(SeverityLevel.NORMAL)
    public void LongPhoneErrorTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps
                .ClickOnContinueBtn()
                .EnterCompanyPhone(tenDigitsInput);
        Assert.assertEquals(invoicePageSteps.companyPhone.getValue().length(), nineDigitsInput.length(),
                "9 symbols are entered in the company phone field");
        System.out.println(invoicePageSteps.companyPhone.getValue().length());
        System.out.println(nineDigitsInput.length());
    }
    @Test
    @Description("34.  9 digits are entered to the company's Phone field, it is not red after clicking Send button")
    @Severity(SeverityLevel.NORMAL)
    public void FilledPhoneFieldTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps.ClickOnContinueBtn();
        Assert.assertFalse(invoicePageSteps.companyPhone.has(Condition.attribute(style,red)),
                "Company phone field does not have red border");
        invoicePageSteps.ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyPhone.has(Condition.attribute(style,red)),
                "Company phone field has red border" );
        invoicePageSteps
                .EnterCompanyPhone(nineDigitsInput)
                .ClickOnSendBtn();
        Assert.assertFalse(invoicePageSteps.companyPhone.has(Condition.attribute(style,red)),
                "Company phone field does not have red border");
    }
    @Test
    @Description("35. Emptiness is replaced with less than 5 symbols in the company's Desired Date field, it stays red after clicking Send button")
    @Severity(SeverityLevel.NORMAL)
    public void ShortDateErrorTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps.ClickOnContinueBtn();
        Assert.assertFalse(invoicePageSteps.companyDesiredDate.has(Condition.attribute(style,red)),
                "Company Desired Date field does not have red border");
        invoicePageSteps.ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyDesiredDate.has(Condition.attribute(style,red)),
                "Company Desired Date field has red border" );
        invoicePageSteps
                .EnterDesiredDate(fourDigitsInput)
                .ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyDesiredDate.has(Condition.attribute(style,red)),
                "Company Desired Date field has red border" );
    }
    @Test
    @Description("36. Emptiness is replaced with more than 5 symbols in the company's Desired Date field, it doesn't have red border after clicking Send button")
    @Severity(SeverityLevel.NORMAL)
    public void LongDateErrorTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps.ClickOnContinueBtn();
        Assert.assertFalse(invoicePageSteps.companyDesiredDate.has(Condition.attribute(style,red)),
                "Company Desired Date field does not have red border");
        invoicePageSteps.ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyDesiredDate.has(Condition.attribute(style,red)),
                "Company Desired Date field has red border" );
        invoicePageSteps
                .EnterDesiredDate(eightDigitsInput)
                .ClickOnSendBtn();
        Assert.assertFalse(invoicePageSteps.companyDesiredDate.has(Condition.attribute(style,red)),
                "Company Desired Date field does not have red border" );
    }
    @Test
    @Description("37. Emptiness is replaced with correct email in the company's Email field, it doesn't have red border after clicking Send button")
    @Severity(SeverityLevel.NORMAL)
    public void CorrectEmailTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps.ClickOnContinueBtn();
        Assert.assertFalse(invoicePageSteps.companyEmail.has(Condition.attribute(style,red)),
                "Company email field does not have red border");
        invoicePageSteps.ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyEmail.has(Condition.attribute(style,red)),
                "Company email field has red border" );
        invoicePageSteps
                .EnterEmail(companyCorrectEmailInput)
                .ClickOnSendBtn();
        Assert.assertFalse(invoicePageSteps.companyEmail.has(Condition.attribute(style,red)),
                "Company email field does not have red border");
    }
    @Test
    @Description("38. Emptiness is replaced with incorrect email in the company's Email field, the border remains red after clicking Send button")
    @Severity(SeverityLevel.NORMAL)
    public void IncorrectEmailTest() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps.ClickOnContinueBtn();
        Assert.assertFalse(invoicePageSteps.companyEmail.has(Condition.attribute(style,red)),
                "Company email field does not have red border");
        invoicePageSteps.ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyEmail.has(Condition.attribute(style,red)),
                "Company email field has red border" );
        invoicePageSteps
                .EnterEmail(companyIncorrectEmailInput)
                .ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyEmail.has(Condition.attribute(style,red)),
                "Company email field has red border" );
    }
    @Test
    @Description("39. Emptiness is replaced with incorrect email in the company's Email field, the border remains red after clicking Send button")
    @Severity(SeverityLevel.NORMAL)
    public void IncorrectEmailTest_2() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps.ClickOnContinueBtn();
        Assert.assertFalse(invoicePageSteps.companyEmail.has(Condition.attribute(style,red)),
                "Company email field does not have red border");
        invoicePageSteps.ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyEmail.has(Condition.attribute(style,red)),
                "Company email field has red border" );
        invoicePageSteps
                .EnterEmail(companyIncorrectEmailInput_2)
                .ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyEmail.has(Condition.attribute(style,red)),
                "Company email field has red border" );
    }
    @Test
    @Description("40. Emptiness is replaced with incorrect email in the company's Email field, the border remains red after clicking Send button")
    @Severity(SeverityLevel.NORMAL)
    public void IncorrectEmailTest_3() {
        productsPageSteps
                .ClickProducts()
                .ChooseFirstCategory()
                .ChooseBinder()
                .AddThirdProductToCart()
                .ClickOnCart();
        invoicePageSteps.ClickOnContinueBtn();
        Assert.assertFalse(invoicePageSteps.companyEmail.has(Condition.attribute(style,red)),
                "Company email field does not have red border");
        invoicePageSteps.ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyEmail.has(Condition.attribute(style,red)),
                "Company email field has red border" );
        invoicePageSteps
                .EnterEmail(companyIncorrectEmailInput_3)
                .ClickOnSendBtn();
        Assert.assertTrue(invoicePageSteps.companyEmail.has(Condition.attribute(style,red)),
                "Company email field has red border" );
    }
}
