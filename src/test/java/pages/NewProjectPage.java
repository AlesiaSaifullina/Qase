package pages;

import com.codeborne.selenide.SelenideElement;
import dto.Project;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class NewProjectPage extends BasePage {

    public static final SelenideElement PROJECT_NAME = $("#inputTitle");
    public static final SelenideElement PROJECT_CODE = $("#inputCode");
    public static final SelenideElement PROJECT_DESCRIPTION = $("#inputDescription");
    public static final SelenideElement CHECK_BOX_PUBLIC = $("#public-access-type");
    public static final SelenideElement CREATE_BUTTON = $("[type=submit]");



    @Step("Input project information: {project}")
    public NewProjectPage inputInfo(Project project) {
        log.info("Input project name: {}, code project: {}, description {}", project.getName(),
                project.getCode(), project.getDescription());
        PROJECT_NAME.sendKeys(project.getName());
        PROJECT_CODE.sendKeys(project.getCode());
        PROJECT_DESCRIPTION.sendKeys(project.getDescription());
        CHECK_BOX_PUBLIC.click();
        CREATE_BUTTON.click();
        return this;
    }
}