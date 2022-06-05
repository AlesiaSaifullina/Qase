package pages;

import com.codeborne.selenide.SelenideElement;
import dto.Suite;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import wrappers.DropDown;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class SuitePage extends BasePage {


    public static final SelenideElement SUITE_NAME = $("#name");
    public static final SelenideElement SUITE_DESCRIPTION = $("#description");
    public static final SelenideElement SUITE_PRECONDITION = $("#preconditions");
    public static final SelenideElement CREATE_SUITE = $("#save-suite-button");


    @Step("Input suite information: {suite}")
    public SuitePage create(Suite aSuite) {
        log.info("Input suite name: {}, select parent suite: {}, description: {}, preconditions: {}",
                aSuite.getName(), aSuite.getParent(), aSuite.getDescription(), aSuite.getPreconditions());
        SUITE_NAME.sendKeys(aSuite.getName());
        new DropDown("Parent suite").select(aSuite.getParent());
        SUITE_DESCRIPTION.sendKeys(aSuite.getDescription());
        SUITE_PRECONDITION.sendKeys(aSuite.getPreconditions());
        CREATE_SUITE.click();
        return this;
    }
}