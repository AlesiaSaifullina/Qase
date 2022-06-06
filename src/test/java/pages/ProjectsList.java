package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectsList extends BasePage {

    public static final SelenideElement CREATE_BUTTON = $("#createButton");
    public static final SelenideElement CREATE_PROJECT = $("[type=submit]");
    public static final SelenideElement PROJECTS_SORTING = $(By.className("sortable"));
    public static final SelenideElement PROJECT_SETTING = $("a.btn.btn-dropdown");
    public static final SelenideElement DELETE_BUTTON = $("a.text-danger");
    public static final SelenideElement SUBMIT_BUTTON = $("button.btn.btn-cancel");
    public static final SelenideElement PROJECT_EXISTENCE = $("span.no-project.mt-4");

    public ProjectsList openPage() {
        open("projects");
        return this;
    }


    @Step("Click button 'Create new project'")
    public NewProjectPage clickButtonNewProject() {
        log.info("Click button 'Create new project'");
        CREATE_BUTTON.click();
        return new NewProjectPage();
    }

    @Step("Delete project")
    public void deleteProject() {
        //TODO не уверен что этот метод тебе нежуен. Лог некорректный в люьом случае. Либо удаляем либо фиксим лог и использование
        log.info("Removal a project with name 'test'");
        open("projects");
        PROJECTS_SORTING.click();
        PROJECT_SETTING.click();
        DELETE_BUTTON.click();
        SUBMIT_BUTTON.click();
    }

    @Step("Project creation check with name: {name}")
    public boolean validate(String name) {
        log.info("Project creation check with name: {}", name);
        $$("[class=defect-title]").findBy(Condition.text(name)).shouldBe(Condition.visible);
        return $$("[class=defect-title]").findBy(Condition.text(name)).isDisplayed();
    }
}