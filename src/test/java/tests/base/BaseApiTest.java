package tests.base;

import api.ProjectApiClient;
import api.SuiteApiClient;

public class BaseApiTest {

    protected ProjectApiClient projectApiClient;
    protected SuiteApiClient suiteApiClient;

    public BaseApiTest() {
        projectApiClient = new ProjectApiClient();
        suiteApiClient = new SuiteApiClient();
    }
}
