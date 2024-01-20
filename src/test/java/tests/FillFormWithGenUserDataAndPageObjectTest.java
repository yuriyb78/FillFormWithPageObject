package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.GenUserData;

public class FillFormWithGenUserDataAndPageObjectTest extends BaseTests {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = GenUserData.getRandomFirstName(),
            lastName = GenUserData.getRandomLastName(),
            emailAddress = GenUserData.getRandomEmailAddress(),
            genderValue = GenUserData.getRandomGenderValue(),
            phoneNumber = GenUserData.getRandomPhoneNumber(),
            dayOfBirthDay = GenUserData.getRandomDayOfBirthDay(),
            monthOfBirthDay = GenUserData.getRandomMonthOfBirthDay(dayOfBirthDay),
            yearOfBirthDay = GenUserData.getRandomYearOfBirthDay(),
            subjectChar = GenUserData.getRandomGetRandomSubject(),
            hobbieValue = GenUserData.getRandomHobbies(),
            namePicture = "01.jpg",
            fullAddress = GenUserData.getRandomFullAddress(),
            nameState = GenUserData.getRandomNameState(),
            nameCity = GenUserData.getRandomNameCity(nameState);

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
                .clickSubmit()
                .checkModalWindow()
                .checkTableValue("Student Name",firstName + " " + lastName)
                .checkTableValue("Student Email",emailAddress)
                .checkTableValue("Gender",genderValue)
                .checkTableValue("Mobile",phoneNumber)
                .checkTableValue("Date of Birth",dayOfBirthDay + " " + monthOfBirthDay + "," + yearOfBirthDay)
                .checkTableValue("Subjects",subjectChar)
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
                .clickSubmit()
                .checkModalWindow()
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
                .clickSubmit()
                .checkValidation()
                .checkNotVisibleModalWindow();

    }

}
