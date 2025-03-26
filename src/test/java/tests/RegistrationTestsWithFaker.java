package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultTableRegistrationPageComponent;

import static utils.RandomValues.*;


public class RegistrationTestsWithFaker extends TestBase {


    @Test
    void RegistrationTest() {
        RegistrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserNumber(phoneNumber)
                .setEmailInput(email)
                .setGender(gender)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadFiles(uploadFile)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();


        ResultTableRegistrationPageComponent resultTable = new ResultTableRegistrationPageComponent();
        resultTable.resultTable("Student Name", firstName + " " + lastName);
        resultTable.resultTable("Student Email", email);
        resultTable.resultTable("Gender", gender);
        resultTable.resultTable("Mobile", phoneNumber);
        resultTable.resultTable("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth);
        resultTable.resultTable("Subjects", subjects);
        resultTable.resultTable("Hobbies", hobbies);
        resultTable.resultTable("Picture", uploadFile);
        resultTable.resultTable("Address", currentAddress);
        resultTable.resultTable("State and City", state + " " + city);
    }

}
