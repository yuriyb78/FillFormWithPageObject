package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.component.CheckResultRegistrationForm;

public class FillFormWithPageObjectTest extends BaseTests {

    RegistrationPage registrationPage = new RegistrationPage();
    CheckResultRegistrationForm checkResultRegistrationForm = new CheckResultRegistrationForm();
    String firstName = "Joe",
            lastName = "Doe",
            emailAddress = "email@email.com",
            genderValue = "Male",
            phoneNumber = "9990001122",
            dayOfBirthDay = "25",
            monthOfBirthDay = "June",
            yearOfBirthDay = "1978",
            subjectChar = "Math",
            hobbieValue = "Sports",
            namePicture = "01.jpg",
            fullAddress = "112233, Какая-то область, г. Какой-то, ул. Какая-то д.1, кв.1",
            nameState = "NCR",
            nameCity = "Delhi";

   // Тест с заполнением всех полей формы
   // и проверкой правильности их заполенения в итоговой таблице
    @Test
    void fillFormWithAllFieldTest(){
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(emailAddress)
                .setGender(genderValue)
                .setUserPhoneNumber(phoneNumber)
                .setDateOfBirthDay(dayOfBirthDay,monthOfBirthDay,yearOfBirthDay)
                .setSubjectInput(subjectChar)
                .setHobbie(hobbieValue)
                .setUploadPicture(namePicture)
                .setAddress(fullAddress)
                .setState(nameState)
                .setCity(nameCity)
                .clickSubmit();

        checkResultRegistrationForm.checkModalWindow()
                .checkTableValue("Student Name",firstName + " " + lastName)
                .checkTableValue("Student Email",emailAddress)
                .checkTableValue("Gender",genderValue)
                .checkTableValue("Mobile",phoneNumber)
                .checkTableValue("Date of Birth",dayOfBirthDay + " " + monthOfBirthDay + "," + yearOfBirthDay)
                .checkTableValue("Subjects","Math")
                .checkTableValue("Hobbies",hobbieValue)
                .checkTableValue("Picture",namePicture)
                .checkTableValue("Address",fullAddress)
                .checkTableValue("State and City",nameState + " " + nameCity);
    }

    // Тест с заполнением только обязательных полей формы
    // и проверкой правильности их заполенения в итоговой таблице
    @Test
    void fillFormWithOnlyRequiredFieldTest(){
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(genderValue)
                .setUserPhoneNumber(phoneNumber)
                .setDateOfBirthDay(dayOfBirthDay,monthOfBirthDay,yearOfBirthDay)
                .clickSubmit();

        checkResultRegistrationForm.checkModalWindow()
                .checkTableValue("Student Name",firstName + " " + lastName)
                .checkTableValue("Student Email","")
                .checkTableValue("Gender",genderValue)
                .checkTableValue("Mobile",phoneNumber)
                .checkTableValue("Date of Birth",dayOfBirthDay + " " + monthOfBirthDay + "," + yearOfBirthDay)
                .checkTableValue("Subjects","")
                .checkTableValue("Hobbies","")
                .checkTableValue("Picture","")
                .checkTableValue("Address","")
                .checkTableValue("State and City","");
    }

    // Негативный тест без заполнения обязательных полей формы
    @Test
    void notFillFormRequiredFieldTest(){
        registrationPage.openPage()
                .clickSubmit();

        checkResultRegistrationForm.checkValidation()
                .checkNotVisibleModalWindow();

    }
}
