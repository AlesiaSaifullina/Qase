package tests;

import dto.Project;
import org.testng.annotations.Test;
import tests.base.BaseApiTest;

import static org.testng.Assert.assertEquals;

public class ProjectApiTest extends BaseApiTest {

    @Test(description = "Create new project")
    public void createNewProject() {
        Project project = Project
                .builder()
                .name("APITEST")
                .code("APITEST")
                .description("Description")
                .access("all")
                .group("1")
                .build();

        projectApiClient.createNewProject(project);
        Project actual = projectApiClient.getProjectByCode(project.getCode());
        assertEquals(actual.getName(), project.getName());
        assertEquals(actual.getCode(), project.getCode());
        assertEquals(actual.getCounts().getCases(), 0);
        projectApiClient.deleteProjectByCode(project.getCode());
    }
}