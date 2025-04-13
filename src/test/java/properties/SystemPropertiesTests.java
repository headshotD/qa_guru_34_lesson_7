package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;


public class SystemPropertiesTests {

    @Tags({
            @Tag("MyTest"),
            @Tag("POMMithFaker"),
    })
    @Test
    void browserRemoteProperties() {
        String browserRemote = System.getProperty("browserRemote", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        System.out.println("Remote browser URL: " + System.getProperty(browserRemote));
    }
    @Tags({
            @Tag("MyTest"),
            @Tag("POMMithFaker"),
    })
    @Test
    void browserSizeProperties() {
        String browserSize = System.getProperty("browserSize", "1920x1080");
        System.out.println(browserSize);
    }

    @Test
    @Tags({
            @Tag("MyTest"),
            @Tag("POMMithFaker"),
    })
    void browserProperties() {
        String browser = System.getProperty("browser", "chrome");
        System.out.println(browser);

    }

    @Test
    @Tags({
            @Tag("MyTest"),
            @Tag("POMMithFaker"),
    })
    void browserVersionProperties() {
        String browserVersion = System.getProperty("browserVersion", "127.0");
        System.out.println(browserVersion);

    }

}