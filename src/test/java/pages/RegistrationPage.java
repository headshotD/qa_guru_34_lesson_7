package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    public static RegistrationPage openPage() {
        open("/automation-practice-form");
        return new RegistrationPage();
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    CalendarComponent calendarComponent = new CalendarComponent();
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadFile = $(".form-control-file"),
            currentAddress = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submit = $("#submit");


    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmailInput(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;

    }

    public RegistrationPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.parent().$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadFiles(String value) {
        uploadFile.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }


    public RegistrationPage setState(String state) {
        stateInput.click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }


    public RegistrationPage setCity(String city) {
        cityInput.click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public void clickSubmit() {

        submit.click();
    }

}
