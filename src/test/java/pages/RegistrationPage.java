package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.component.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    public final SelenideElement userForm = $("#userForm"),
                firstNameInput = $("#firstName"),
                lastNameInput = $("#lastName"),
                userEmailInput = $("#userEmail"),
                genderInput = $("#genterWrapper"),
                phoneNumberInput = $("#userNumber"),
                dateOfBirthInput = $("#dateOfBirthInput"),
                subjectInput = $("#subjectsInput"),
                chooseHobbie= $("#hobbiesWrapper"),
                uploadPicture = $("#uploadPicture"),
                addressInput = $("#currentAddress"),
                selectState = $("#react-select-3-input"),
                selectCity = $("#react-select-4-input"),
                btnSubmit = $("#submit");
    CalendarComponent setCalendarDay = new CalendarComponent();

    public RegistrationPage openPage() {

        // Открыть браузер на заданной странице
        open("/automation-practice-form");  // Открытие браузера на нужной странице
        executeJavaScript("$('#fixedban').remove()"); // Скрытие рекламы
        executeJavaScript("$('footer').remove()");  // Скрытие футера

        return this;
    }

    public RegistrationPage setFirstName (String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName (String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail (String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGender (String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setUserPhoneNumber (String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);
        return this;
    }

    public RegistrationPage setDateOfBirthDay (String day, String month, String year) {
        dateOfBirthInput.click();
        setCalendarDay.setCalendar(day, month, year);
        return this;
    }

    public  RegistrationPage setSubjectInput (String value){
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public  RegistrationPage setHobbie (String hobbie) {
        chooseHobbie.$(byText(hobbie)).click();
        return this;
    }

    public  RegistrationPage setUploadPicture (String nameFile) {
        uploadPicture.uploadFromClasspath(nameFile);
        return this;
    }

    public  RegistrationPage setAddress (String address) {
        addressInput.setValue(address);
        return this;
    }

    public  RegistrationPage setState (String state) {
        selectState.setValue(state).sendKeys(Keys.ENTER);
        return this;
    }

    public  RegistrationPage setCity (String city) {
        selectCity.setValue(city).sendKeys(Keys.ENTER);
        return this;
    }

    public  RegistrationPage clickSubmit () {
        btnSubmit.click();
        return this;
    }


}
