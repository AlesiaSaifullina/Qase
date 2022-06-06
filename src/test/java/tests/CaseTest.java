package tests;

import dto.Case;
import dto.Project;
import dto.ProjectsFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class CaseTest extends BaseTest {

    @Test(description = "Create new case")
    public void createCase() {
        Project project = ProjectsFactory.getProject();
        loginSteps.login(user, password);
        projectStep.createProject(project);
        newProjectPage.inputInfo(project);
        //TODO сделать на большее кол-во полей
        Case aCase = Case.builder()
                .title("Test")
                .milestone("Not set")
                .build();
        caseSteps.createCase(aCase);
        //TODO нет валидации
        projectPage.deleteCase();
    }
}