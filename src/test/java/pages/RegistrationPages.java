package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPages {
    //components

    CalendarComponent calendarComponent  = new CalendarComponent();

    //locators
    private SelenideElement
            headerTitle =$(".main-header"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            resultsTable = $(".table-responsive"),
            emailInput =  $("#userEmail"),
            phoneInput = $("#userNumber"),
            genterInput = $("#genterWrapper").$(byText("Female")),
            subjectInput =  $("#subjectsInput"),
            hobbyInput = $("#hobbiesWrapper").$(byText("Music")),
            adressInput =  $("#currentAddress"),
            stateInput =  $("#react-select-3-input"),
            cityInput=  $("#react-select-4-input"),
            submitInput = $("#submit"),
            headerCheck = $("#example-modal-sizes-title-lg");



    //actions

    public RegistrationPages openPage(){

        open ("/automation-practice-form");
        headerTitle.shouldHave(text("Practice Form"));

        return this;
    }

    public RegistrationPages setFirstName (String firstName) {
        firstNameInput.setValue(firstName);

        return this;

    }

    public RegistrationPages setLastName (String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }


    public RegistrationPages setEmail (String email) {
        emailInput.setValue(email);

        return this;
    }

    public RegistrationPages setGenter () {
        genterInput.click();

        return this;
    }

    public RegistrationPages setPhone (String phone) {
        phoneInput.setValue(phone);

        return this;
    }

    public RegistrationPages setSubjects(String subject) {
        subjectInput.setValue(subject).pressEnter();

        return this;
    }


    public RegistrationPages setHobbyes() {
        hobbyInput.click();

        return this;
    }

    public RegistrationPages setBirthDate (String day,String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPages uploadUserFile(){

        $("#uploadPicture").uploadFromClasspath("khosiko5.jpg");
        return this;
    }


    public RegistrationPages setAdress(String adress) {
        adressInput.setValue(adress);

        return this;
    }

    public RegistrationPages setState(String state) {
        stateInput.setValue(state).pressEnter();

        return this;
    }

    public RegistrationPages setCity(String city) {
        cityInput.setValue(city).pressEnter();

        return this;
    }

    public RegistrationPages setSubmit(){
        submitInput.pressEnter();

        return this;
    }

    public RegistrationPages checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }
    public RegistrationPages checkHeader(String header) {
        headerCheck.shouldHave(text(header));

        return this;
    }




}
