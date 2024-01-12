package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class FillFormWithPageObjectTest {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Joe",
            lastName = "Doe",
            emailAddress = "email@email.com",
            genderValue = "Male",
            phoneNumber = "9990001122",
            dayOfBirthDay = "25",
            monthOfBirthDay = "June",
            yearOfBirthDay = "1978",
            subjectChar = "a",
            hobbieValue = "Sports",
            namePicture = "01.jpg",
            fullAddress = "112233, Какая-то область, г. Какой-то, ул. Какая-то д.1, кв.1",
            nameState = "NCR",
            nameCity = "Delhi";

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
                .checkTableValue("Subjects","Arts")
                .checkTableValue("Hobbies",hobbieValue)
                .checkTableValue("Picture",namePicture)
                .checkTableValue("Address",fullAddress)
                .checkTableValue("State and City",nameState + " " + nameCity);
    }
}
