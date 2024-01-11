package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
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


    ;
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
        genderInput.setValue(byText(gender)).click();
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

}
