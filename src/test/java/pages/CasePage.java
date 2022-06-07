package pages;

import com.codeborne.selenide.SelenideElement;
import dto.Case;
import wrappers.DropDown;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CasePage extends BasePage {

    public static final SelenideElement CASE_TITLE = $("#title");
    public static final SelenideElement SAVE = $(byText("Save"));


    public CasePage create(Case aCase) {
        CASE_TITLE.sendKeys(aCase.getTitle());
        new DropDown("Milestone").select(aCase.getMilestone());
        SAVE.click();
        return this;
    }
}