package tests;

import dto.Project;
import dto.ProjectsFactory;
import dto.Suite;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class SuiteTest extends BaseTest {

    @Test(description = "Create new Suite")
    public void createSuite() {
        Project project = ProjectsFactory.getProject();
        loginSteps.login(user, password);
        projectStep.createProject(project);
        newProjectPage.inputInfo(project);
        Suite suite = Suite.builder()
                .name("Test")
                .parent("Project root")
                .description("description")
                .preconditions("precondition")
                .build();
        suiteSteps.createSuite(suite);
        assertEquals(projectPage.getSuiteName(),suite.getName());
    }
}