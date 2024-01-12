package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class FillFormWithPageObjectTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormWithAllFieldTest(){
        registrationPage.openPage()
                .setFirstName("Joe")
                .setLastName("Doe")
                .setEmail("email@email.com")
                .setGender("Male")
                .setUserPhoneNumber("9990001122")
                .setDateOfBirtDay("25","June","1978")
                .setSubjectInput("a")
                .setHobbie("Sports")
                .setUploadPicture("01.jpg")
                .setAddress("112233, Какая-то область, г. Какой-то, ул. Какая-то д.1, кв.1")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit();
    }
}
