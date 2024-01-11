package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class FillFormWithPageObject {

    RegistrationPage registrationPage = new RegistrationPage;

    @Test
    void fillFormWithAllField(){
        registrationPage.openPage()
                .setFirstName("Joe")
                .setLastName("Doe")
                .setEmail("email@email.com")
                .setGender("Male")
                .setUserPhoneNumber("9990001122")
                .
    }
}
