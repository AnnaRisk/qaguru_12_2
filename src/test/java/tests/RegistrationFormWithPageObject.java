package tests;

import pages.RegistrationPages;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormWithPageObject {

    RegistrationPages registrationPages = new RegistrationPages();
    String firstName = "Anna";
    String lastName = "Rain";
    String email = "annatest111@gmail.com";
    String phone = "78889998877";
    String subject = "Arts";
    String adress = "Address2";
    String state = "NCR";
    String city = "Delhi";


    @BeforeAll

    static  void beforeAll() {

        Configuration.baseUrl = "https://demoqa.com";


    }

    @Test

    void successFillTest () {


        registrationPages.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGenter()
                .setPhone(phone)
                .setBirthDate("14", "January", "1984")
                .setSubjects(subject)
                .setHobbyes()
                .uploadUserFile()
                .setAdress(adress)
                .setState(state)
                .setCity(city)
                .setSubmit()
                .checkHeader("Thanks for submitting the form")
                .checkForm ("Student Name","Anna Rain")
                .checkForm ("Student Email","annatest111@gmail.com")
                .checkForm ("Gender","Female")
                .checkForm ("Mobile","7888999887")
                .checkForm ("Date of Birth","14 January,1984")
                .checkForm ("Subjects","Arts")
                .checkForm ("Hobbies","Music")
                .checkForm ("Picture","khosiko5.jpg")
                .checkForm ("Address","Address2")
                .checkForm ("State and City","NCR Delhi");
    }


    }

