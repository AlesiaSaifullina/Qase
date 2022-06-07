package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import dto.Case;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Log4j2
public class ProjectPage extends BasePage {

    public static final SelenideElement PROJECT_NAME = $("p.header");
    public static final SelenideElement CREATE_SUITE = $("#create-suite-button");
    public static final SelenideElement CREATE_CASE = $("#create-case-button");
    public static final SelenideElement DELETE_SUITE = $("i.fa-trash");
    public static final SelenideElement DELETE_CASE = $("i.fa.fa-trash");
    public static final SelenideElement SELECT_CASE = $("[type=checkbox]");
    public static final SelenideElement CONFIRM_BUTTON = $(byText("Delete"));
    public static final SelenideElement DELETE_ICON = $("[name=confirm]");
    public static final SelenideElement SUITE_NAME = $("span.style_titleText-2sGhc");
    public static final SelenideElement CASE_TITLE = $("div.style_itemCell-3gHZi.style_title-3pZF1");



    @Step("Create new 'Suite'")
    public SuitePage clickSuite() {
        log.info("Click on button 'Suite'");
        CREATE_SUITE.click();
        return new SuitePage();
    }

    @Step("Create new 'Case'")
    public CasePage clickCase() {
        log.info("Click on button 'Case'");
        CREATE_CASE.click();
        return new CasePage();
    }

    @Step("Delete a suite")
    public void deleteSuite() {
        log.info("Delete a suite");
        DELETE_SUITE.click();
    }
    @Step("Delete a case")
    public void deleteCase() {
        log.info("Delete a case");
        SELECT_CASE.click();
        DELETE_CASE.click();
        DELETE_ICON.shouldBe(Condition.visible);
        DELETE_ICON.click();
        DELETE_ICON.sendKeys("CONFIRM");
        CONFIRM_BUTTON.click();
    }

    @Step("Getting project name")
    public String getProjectName() {
        String projectName = PROJECT_NAME.getText();
        return projectName;
    }
    @Step("Getting suit name")
    public String getSuiteName() {
        return SUITE_NAME.getText();
    }
    @Step("Getting case name")
    public String getCaseName() {
        return CASE_TITLE.getText();
    }
}