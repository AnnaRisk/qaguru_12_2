package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPages;

import static utils.RandomUtils.getRandomInt;
import static utils.RandomUtils.getRandomString;

public class RegistrationFormWithPageObjectFaker {

    Faker faker = new Faker();

    RegistrationPages registrationPages = new RegistrationPages();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phone = getRandomString(10),
            subject = "Arts",
            adress = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi";



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
                .checkForm ("Student Name",firstName + " " + lastName)
                .checkForm ("Student Email",email)
                .checkForm ("Gender","Female")
                .checkForm ("Mobile",phone)
                .checkForm ("Date of Birth","14 January,1984")
                .checkForm ("Subjects","Arts")
                .checkForm ("Hobbies","Music")
                .checkForm ("Picture","khosiko5.jpg")
                .checkForm ("Address",adress)
                .checkForm ("State and City","NCR Delhi");
    }


    }

