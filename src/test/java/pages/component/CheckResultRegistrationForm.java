package pages.component;

import com.codeborne.selenide.SelenideElement;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckResultRegistrationForm extends RegistrationPage {

    private final SelenideElement modalWindow = $(".modal-open"),
            fieldTable = $(".table");

    public CheckResultRegistrationForm checkModalWindow () {
        modalWindow.shouldBe(visible);
        return this;
    }
    public CheckResultRegistrationForm checkTableValue (String column, String value) {
        int lenghtValue = value.length();
        if (lenghtValue >= 1) {
            fieldTable.$(byText(column)).parent().shouldHave(text(value));
        } else {
            fieldTable.$(byText(column)).parent().$("td",1).shouldHave(exactText(value));
        }
        return this;
    }

    public CheckResultRegistrationForm checkValidation() {
        String valueName = "border-color";
        String colorRed = "rgb(220, 53, 69)";
        userForm.shouldHave(cssClass("was-validated"));
        firstNameInput.shouldHave(cssValue(valueName,colorRed));
        lastNameInput.shouldHave(cssValue(valueName,colorRed));
        genderInput.$("label[for='gender-radio-1']").shouldHave(cssValue(valueName,colorRed)); //Male
        genderInput.$("label[for='gender-radio-2']").shouldHave(cssValue(valueName,colorRed)); //Female
        genderInput.$("label[for='gender-radio-3']").shouldHave(cssValue(valueName,colorRed)); //Other
        phoneNumberInput.shouldHave(cssValue(valueName,colorRed));
        return this;
    }
    public void checkNotVisibleModalWindow () {
        modalWindow.shouldNotBe(visible);

    }
}
