package tests;

import dto.Project;
import dto.ProjectsFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NewProjectTest extends BaseTest {

    @Test(description = "Create new Project")
    public void createNewProject() {
        Project project = ProjectsFactory.getProject();
        loginSteps.login(user, password);
        projectStep.createProject(project);
        newProjectPage.inputInfo(project);
        assertEquals( project.getName(), projectPage.getProjectName(), "Project name doesn't match");
    }
}