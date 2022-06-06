package pages;

import com.codeborne.selenide.SelenideElement;
import dto.Case;
import lombok.extern.log4j.Log4j2;
import wrappers.DropDown;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
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