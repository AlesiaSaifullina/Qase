package tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.CaseSteps;
import steps.LoginSteps;
import steps.ProjectSteps;
import steps.SuiteSteps;
import utils.PropertyReader;

@Listeners(TestListener.class)
public class BaseTest {

    protected LoginPage loginPage;
    protected LoginSteps loginSteps;
    protected ProjectsList projectsList;
    protected NewProjectPage newProjectPage;
    protected ProjectSteps projectStep;
    protected ProjectPage projectPage;
    protected SuitePage suitePage;
    protected CasePage casePage;
    protected SuiteSteps suiteSteps;
    protected CaseSteps caseSteps;


    public String user;
    public String password;

    @BeforeMethod(description = "Opening browser")
    public void setup(ITestContext context) {
        user = System.getProperty("user", PropertyReader.getProperty("user"));
        password = System.getProperty("password", PropertyReader.getProperty("password"));

        Configuration.baseUrl = "https://app.qase.io/";
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.clickViaJs = true;
        Configuration.timeout = 30000;

        loginPage = new LoginPage();
        loginSteps = new LoginSteps();
        projectsList = new ProjectsList();
        newProjectPage = new NewProjectPage();
        projectStep = new ProjectSteps();
        projectPage = new ProjectPage();
        suitePage = new SuitePage();
        casePage = new CasePage();
        suiteSteps = new SuiteSteps();
        caseSteps = new CaseSteps();

    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void close() {
        Selenide.closeWebDriver();
    }
}