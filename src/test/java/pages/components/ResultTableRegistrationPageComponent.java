package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableRegistrationPageComponent {

    private final SelenideElement results = $(".modal-body");

    public void resultTable(String key, String value) {

        results.$(byText(key)).parent().shouldHave(text(value));
    }

    }
