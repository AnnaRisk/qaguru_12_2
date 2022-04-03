package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {

    @BeforeAll

    static  void beforeAll() {

        Configuration.baseUrl = "https://demoqa.com";


    }
    @Test


    void successFillTest (){

        open ("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));


        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Rain");
        $("#userEmail").setValue("annatest111@gmail.com");

        $("#genterWrapper").$(byText("Female")).click();

        $("#userNumber").setValue("78889998877");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1984");

        $("[aria-label$='January 14th, 1984']").click();



        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFile(new File("src/test/java/tests/khosiko5.jpg"));

        $("#currentAddress").setValue("Address");


        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").pressEnter();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));


        $("[class='modal-body']").shouldHave(
                text("Anna Rain"),
                text("annatest111@gmail.com"));


    }

}
