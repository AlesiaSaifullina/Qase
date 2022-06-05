package steps;

import dto.Project;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.NewProjectPage;
import pages.ProjectsList;

@Log4j2
public class ProjectSteps {

    ProjectsList projectsList;
    NewProjectPage newProjectPage;

    public ProjectSteps() {
        projectsList = new ProjectsList();
        newProjectPage = new NewProjectPage();
    }

    @Step("Creation project: '{project}'")
    public void createProject(Project project) {
        log.info("Creation project: '{}'", project);
        projectsList.clickButtonNewProject();
    }
}
