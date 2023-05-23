package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.SelenideElementDescriber;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class InvoicePage {

    public SelenideElement

    legalEntity = $(byText("იურიდიული პირი")),
    individual = $(byText("ფიზიკური პირი")),
    sendBtn = $(byId("btn2")),
    companyName = $(by("placeholder", "კომპანიის სახელწოდება")),
    companyCode = $(by("placeholder", "საიდენტიფიკაციო კოდი")),
    companyAddress = $(by("placeholder", "ფაქტიური მისამართი")),
    companyPhone = $(by("placeholder", "საკონტაქტო ნომერი")),
    companyDesiredDate = $(by("placeholder", "როდის გსურთ შეკვეთის მიღება?")),
    companyEmail = $(by("placeholder", "ელ.ფოსტა"));
}
