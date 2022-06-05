package tests;

import dto.Suite;
import org.testng.annotations.Test;
import tests.base.BaseApiTest;

public class SuiteApiTest extends BaseApiTest {

    @Test(description = "Create new suite")
    public void createNewSuite() {
        Suite suite = Suite
                .builder()
                .name("APITEST")
                .description("DESCRIPTION")
                .preconditions("TEXT")
                .build();

        suiteApiClient.createNewSuite(suite);
        suiteApiClient.getSuiteByCode("APITEST");
    }
}