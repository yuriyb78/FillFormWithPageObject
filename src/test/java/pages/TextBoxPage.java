package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private SelenideElement userNameInput = $("#userName"),
                    userEmailInput = $("#userEmail"),
                    currentAddressInput = $("#currentAddress"),
                    permanentAddressInput = $("#permanentAddress"),
                    buttonSubmit = $("#submit"),
                    outputResult = $("#output");


    public TextBoxPage openPage() {

        // Открыть браузер на заданной странице
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/text-box");  // Открытие браузера на нужной странице
        executeJavaScript("$('#fixedban').remove()"); // Скрытие рекламы
        executeJavaScript("$('footer').remove()");  // Скрытие футера
        //Configuration.holdBrowserOpen = true; // Чтобы браузер не закрывался после выполенения теста

        return this;
    }

    public  TextBoxPage setUserName (String userName) {
        userNameInput.setValue(userName);
        return this;
    }

    public TextBoxPage setUserEmail (String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public TextBoxPage setCurrentAddress (String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public TextBoxPage setPermanentAddress (String permanentAddress) {
        permanentAddressInput.setValue(permanentAddress);
        return this;
    }

    public  TextBoxPage clickSubmit () {
        buttonSubmit.click();
        return this;
    }
    public TextBoxPage checkOutputVisible () {
        outputResult.shouldBe(visible);
        return this;
    }

    public  TextBoxPage checkResult (String value) {
        if (value.matches(".*Name*.")) {
            outputResult.$("#name").shouldHave(text(value));
        } else if (value.matches(".*Email*.")) {
            outputResult.$("#email").shouldHave(text(value));
        } else if (value.matches(".*Current Address*.")) {
            outputResult.$("#currentAddress").shouldHave(text(value));
        } else if (value.matches(".*Permananet Address*.")) {
            outputResult.$("#permanentAddress").shouldHave(text(value));
        }
        return this;
    }

    public TextBoxPage checkError () {
        String colorRed = "1px solid rgb(255, 0, 0)";
        String borderName = "border";
        userEmailInput.shouldHave(cssClass("field-error"));
        userEmailInput.shouldHave(cssValue(borderName,colorRed));
        outputResult.shouldNotBe(visible);
        return this;
    }
}
