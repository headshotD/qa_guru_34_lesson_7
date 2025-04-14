package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;


public class RegistrationRemoteTests {

    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://demoqa.com";
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "127.0");
        Configuration.timeout = 5000;
        Configuration.remote = System.getProperty("browserRemote", "https://user1:1234@selenoid.autotests.cloud/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }


    @Tag("MyTest")
    @Test
    void registrationTest() {
        step("Open reg.form", () -> {
            open("/automation-practice-form");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('#footer').remove()");
        });
        step("Fill form", () -> {
            $("#firstName").setValue("Oleg");
            $("#lastName").setValue("Namozov");
            $("#userEmail").setValue("oleg@mail.ru");
            $("#userNumber").setValue("7999111223");
            $("#genterWrapper").$(byText("Male")).click();
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("May");
            $(".react-datepicker__year-select").selectOption("2008");
            $(".react-datepicker__day--024:not(.react-datepicker__day--outside-month)").click();
            $("#subjectsInput").setValue("Math").pressEnter();
            $("#hobbiesWrapper").scrollTo().$(byText("Sports")).click();
            $("#uploadPicture").uploadFromClasspath("images/KoK.jpg");
            $("#currentAddress").setValue("Some address 1");
            $("#state").scrollTo().click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Delhi")).click();
            $("#submit").click();
        });
        step("Verify results", () -> {
            $(".modal-dialog").should(appear);
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(text("Oleg"), text("Namozov"),
                    text("oleg@mail.ru"), text("7999111223"));
        });
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}