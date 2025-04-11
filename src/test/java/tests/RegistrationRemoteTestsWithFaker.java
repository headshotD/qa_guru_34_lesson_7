package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;
import pages.components.ResultTableRegistrationPageComponent;
import utils.RandomValues;


public class RegistrationRemoteTestsWithFaker {
    RandomValues randomValues = new RandomValues();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
    @Tag("MyTest")
    @Test
    void registrationTest() {
        RegistrationPage.openPage()
                .removeBanner()
                .setFirstName(randomValues.firstName)
                .setLastName(randomValues.lastName)
                .setUserNumber(randomValues.phoneNumber)
                .setEmailInput(randomValues.email)
                .setGender(randomValues.gender)
                .setDateOfBirth(randomValues.dayOfBirth, randomValues.monthOfBirth, randomValues.yearOfBirth)
                .setSubjects(randomValues.subjects)
                .setHobbies(randomValues.hobbies)
                .uploadFiles(randomValues.uploadFile)
                .setCurrentAddress(randomValues.currentAddress)
                .setState(randomValues.state)
                .setCity(randomValues.city)
                .clickSubmit();


        ResultTableRegistrationPageComponent resultTable = new ResultTableRegistrationPageComponent();
        resultTable.resultTable("Student Name", randomValues.firstName + " " + randomValues.lastName);
        resultTable.resultTable("Student Email", randomValues.email);
        resultTable.resultTable("Gender", randomValues.gender);
        resultTable.resultTable("Mobile", randomValues.phoneNumber);
        resultTable.resultTable("Date of Birth", randomValues.dayOfBirth + " " + randomValues.monthOfBirth + "," + randomValues.yearOfBirth);
        resultTable.resultTable("Subjects", randomValues.subjects);
        resultTable.resultTable("Hobbies", randomValues.hobbies);
        resultTable.resultTable("Picture", randomValues.uploadFile);
        resultTable.resultTable("Address", randomValues.currentAddress);
        resultTable.resultTable("State and City", randomValues.state + " " + randomValues.city);
    }

}