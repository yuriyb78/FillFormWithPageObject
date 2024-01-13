package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTest {

    TextBoxPage textBoxPage = new TextBoxPage();

    String userName = "UserName",
            userEmail = "test@test.com",
            currentAddress = "112233, Какая-то область, г. Какой-то, ул. Какая-то д.1, кв.1",
            permanentAddress = "112233, Какая-то область, г. Какой-то, ул. Какая-то д.1, кв.1";

    // Заполнение только обязательного поля Email и проверка результата
    @Test
    void fillOnlyRequeredFieldOnTextBoxPageTest () {
        textBoxPage.openPage()
                .setUserEmail(userEmail)
                .clickSubmit()
                .checkOutputVisible()
                .checkResult("Email:"+ userEmail);
    }

    // Заполнение всех полей формы и проверка результата
    @Test
    void fFillAllFuildsOnTextBoxPageTest () {
        textBoxPage.openPage()
                .setUserName(userName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit()
                .checkOutputVisible()
                .checkResult("Name:"+ userName)
                .checkResult("Email:"+ userEmail)
                .checkResult("Current Address :"+ currentAddress)
                .checkResult("Permananet Address :"+ permanentAddress);
    }

    // Негативный тест с указанием невалидного адреса электронной почты в обязательном поле
    @Test
    void checkFormWithNotValidEmail () {
        textBoxPage .openPage()
                .setUserEmail("123")
                .clickSubmit()
                .checkError();
    }
}
