package tests;

import data.TestData;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.component.CheckResultRegistrationForm;

public class FillFormWithGenUserDataAndPageObjectTest extends BaseTests {

    RegistrationPage registrationPage = new RegistrationPage();
    CheckResultRegistrationForm checkResultRegistrationForm = new CheckResultRegistrationForm();

    TestData testData = new TestData();

   // Тест с заполнением всех полей формы
   // и проверкой правильности их заполенения в итоговой таблице
    @Test
    void fillFormWithAllFieldTest(){
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.emailAddress)
                .setGender(testData.genderValue)
                .setUserPhoneNumber(testData.phoneNumber)
                .setDateOfBirthDay(testData.dayOfBirthDay,testData.monthOfBirthDay,testData.yearOfBirthDay)
                .setSubjectInput(testData.subjectChar)
                .setHobbie(testData.hobbieValue)
                .setUploadPicture(testData.namePicture)
                .setAddress(testData.fullAddress)
                .setState(testData.nameState)
                .setCity(testData.nameCity)
                .clickSubmit();

        checkResultRegistrationForm.checkModalWindow()
                .checkTableValue("Student Name",testData.firstName + " " + testData.lastName)
                .checkTableValue("Student Email",testData.emailAddress)
                .checkTableValue("Gender",testData.genderValue)
                .checkTableValue("Mobile",testData.phoneNumber)
                .checkTableValue("Date of Birth",testData.dayOfBirthDay + " " + testData.monthOfBirthDay + "," + testData.yearOfBirthDay)
                .checkTableValue("Subjects",testData.subjectChar)
                .checkTableValue("Hobbies",testData.hobbieValue)
                .checkTableValue("Picture",testData.namePicture)
                .checkTableValue("Address",testData.fullAddress)
                .checkTableValue("State and City",testData.nameState + " " + testData.nameCity);
    }

    // Тест с заполнением только обязательных полей формы
    // и проверкой правильности их заполенения в итоговой таблице
    @Test
    void fillFormWithOnlyRequiredFieldTest(){
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.genderValue)
                .setUserPhoneNumber(testData.phoneNumber)
                .setDateOfBirthDay(testData.dayOfBirthDay,testData.monthOfBirthDay,testData.yearOfBirthDay)
                .clickSubmit();

        checkResultRegistrationForm.checkModalWindow()
                .checkTableValue("Student Name",testData.firstName + " " + testData.lastName)
                .checkTableValue("Student Email","")
                .checkTableValue("Gender",testData.genderValue)
                .checkTableValue("Mobile",testData.phoneNumber)
                .checkTableValue("Date of Birth",testData.dayOfBirthDay + " " + testData.monthOfBirthDay + "," + testData.yearOfBirthDay)
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
