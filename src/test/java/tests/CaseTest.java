package tests;

import dto.Case;
import dto.Project;
import dto.ProjectsFactory;
import org.testng.annotations.Test;
import pages.CasePage;
import pages.ProjectPage;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CaseTest extends BaseTest {

    @Test(description = "Create new case")
    public void createCase() {
        Project project = ProjectsFactory.getProject();
        loginSteps.login(user, password);
        projectStep.createProject(project);
        newProjectPage.inputInfo(project);
        Case aCase = Case.builder()
                .title("Test")
                .milestone("Not set")
                .build();
        caseSteps.createCase(aCase);
        assertEquals(projectPage.getCaseName(),aCase.getTitle());
        projectPage.deleteCase();
    }
}