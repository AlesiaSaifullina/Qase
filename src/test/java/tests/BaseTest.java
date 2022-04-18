package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.LoginPage;
import pages.NewProjectPage;
import pages.ProjectList;

public class BaseTest {
    BasePage basePage;
    LoginPage loginPage;
    ProjectList projectList;
    NewProjectPage newProjectPage;


    @BeforeMethod
    public void setUp() {
        Configuration.baseUrl = "http://qase.io/";
        //Configuration.browser = "edge";
        Configuration.headless = false;
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;

        basePage = new BasePage();
        loginPage = new LoginPage();
        projectList = new ProjectList();
        newProjectPage = new NewProjectPage();
    }
}
