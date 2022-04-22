package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class NewProjectPage extends BasePage {
    public SelenideElement projectName = $("#inputTitle");
    public SelenideElement projectCode = $("#inputCode");
    public SelenideElement description = $("#inputDescription");
    public SelenideElement createButton = $("[type=submit]");
    public SelenideElement typeInput = $("#public-access-type");
    public SelenideElement settings = $x("//span[text()='Settings']");
    public SelenideElement deleteButton = $(".btn-cancel");
    public SelenideElement createNewProjectButton = $("#createButton");


    public NewProjectPage() {
    }

    public void fillInProjectInfo(String name, String code, String Description) {
        projectName.sendKeys(name);
        projectCode.sendKeys(code);
        description.sendKeys(Description);
        typeInput.click();
        createButton.click();
    }
    public void deleteProject() {
        settings.click();
        deleteButton.click();
        deleteButton.click();
        createNewProjectButton.shouldBe(Condition.visible);
    }
}
