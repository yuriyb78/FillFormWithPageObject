package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.Component.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
                lastNameInput = $("#lastName"),
                userEmailInput = $("#userEmail"),
                genderInput = $("#genterWrapper"),
                phoneNumberInpit = $("#userNumber"),
                dateOfBirthInput = $("#dateOfBirthInput"),
                subjectInput = $("#subjectsInput"),
                chooseHobbie= $("#hobbiesWrapper"),
                uplouadPicture = $("#uploadPicture"),
                addressInput = $("#currentAddress"),
                selectState = $("#react-select-3-input"),
                selectCity = $("#react-select-4-input"),
                btnSubmit = $("#submit");
    CalendarComponent setCalendarDay = new CalendarComponent();

    public RegistrationPage openPage() {

        // Открыть браузер на заданной странице
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");  // Открытие браузера на нужной странице
        executeJavaScript("$('#fixedban').remove()"); // Скрытие рекламы
        executeJavaScript("$('footer').remove()");  // Скрытие футера
        //Configuration.holdBrowserOpen = true; // Чтобы браузер не закрывался после выполенения теста

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
        phoneNumberInpit.setValue(phoneNumber);
        return this;
    }

    public RegistrationPage setDateOfBirtDay (String day, String month, String year) {
        dateOfBirthInput.click();
        setCalendarDay.setCalendar(day, month, year);
        return this;
    }

    public  RegistrationPage setSubjectInput (String value){
        subjectInput.setValue(value).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        return this;
    }

    public  RegistrationPage setHobbie (String hobbie) {
        chooseHobbie.$(byText(hobbie)).click();
        return this;
    }

    public  RegistrationPage setUploadPicture (String nameFile) {
        uplouadPicture.uploadFromClasspath(nameFile);
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
