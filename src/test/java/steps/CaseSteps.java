package steps;

import dto.Case;
import pages.CasePage;
import pages.ProjectPage;

public class CaseSteps {

    ProjectPage projectPage;
    CasePage casePage;

    public CaseSteps() {
        projectPage = new ProjectPage();
        casePage = new CasePage();
    }

    public void createCase(Case aCase) {
        projectPage.clickCase()
                .create(aCase);
    }
}