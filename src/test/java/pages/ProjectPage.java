package pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage extends BasePage {
    public  SelenideElement suiteButton = $("#create-suite-button");
    public  SelenideElement suiteName = $("#name");
    public  SelenideElement suiteParent = $("");
    public  SelenideElement description = $("#description");
    public  SelenideElement preconditions = $("#preconditions");
    public  SelenideElement createSuiteButton = $("#save-suite-button");
    public SelenideElement repository = $x("//p[contains(@class, 'header')]");

    public ProjectPage() {
    }



    public void createNewSuite(String name, String Description, String Preconditions) {
        suiteButton.click();
        suiteName.sendKeys(name);
        description.sendKeys(Description);
        preconditions.sendKeys(Preconditions);
        createSuiteButton.click();

    }
}