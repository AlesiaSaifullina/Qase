package steps;

import dto.Suite;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.ProjectPage;
import pages.SuitePage;

@Log4j2
public class SuiteSteps {

    ProjectPage projectPage;
    SuitePage suitePage;

    public SuiteSteps() {
        projectPage = new ProjectPage();
        suitePage = new SuitePage();
    }

    @Step("Creation project: '{project}'")
    public void createSuite(Suite aSuite) {
        log.info("Creation suite: '{}'", aSuite);
        projectPage.clickSuite()
                .create(aSuite);
    }
}