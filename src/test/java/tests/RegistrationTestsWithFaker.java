package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultTableRegistrationPageComponent;
import utils.RandomValues;


public class RegistrationTestsWithFaker extends TestBase {
    RandomValues randomValues = new RandomValues();
@Tag("POMЦithFaker")
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