package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class NewProjectTest extends BaseTest {

    @Test
    public void createNewProject() {
        open("login");
        loginPage.login("saifulina.qa@gmail.com", "iH96sFQBYV@4.Mx");
        projectList.clickNewCreate();
        newProjectPage.fillInProjectInfo("Sauce Demo", "SD", "Example");
    }
}
