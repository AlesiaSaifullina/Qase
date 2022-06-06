package wrappers;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class DropDown {

    String label;

    public DropDown(String label) {
        this.label = label;
    }

    //TODO ту тпараметр select в Allure указан. Его нет в методе/классе
    @Step("Select: {option} into: {select}")
    public void select(String option) {
        log.info("Choosing {} in {}", option, label);
        $(byXpath(String.format("//label[text()='%s']/../div[contains(@class, 'css')]", label))).click();
        $(byText(option)).click();
    }
}