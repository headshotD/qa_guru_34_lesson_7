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
    void browserSizeProperties() {
        String browserSize = System.getProperty("browserSize", "1280x720");
        System.out.println(browserSize); // chrome
    }

    @Test
    @Tags({
            @Tag("MyTest"),
            @Tag("POMMithFaker"),
    })
    void browserProperties() {
        String browser = System.getProperty("browser", "mozilla");
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