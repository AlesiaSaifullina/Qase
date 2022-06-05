package api;

import dto.Suite;

public class SuiteApiClient extends BaseApiClient {

    public void createNewSuite(Suite suite) {
        post(gson.toJson(suite), "suite");
    }

    public Suite getSuiteByCode(String code) {
        return gson.fromJson(get("suite/" + code).path("result").toString(), Suite.class);
    }
}