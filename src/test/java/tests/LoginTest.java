package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.TestListener;
import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test(description = "Authorization")
    public void logIn() {
        loginSteps.login(user, password);
    }
    @Test(description = "Not registered user")
    public void errorMessageShouldBeDisplayed() {
        loginSteps.login("bla_bla@100.bla.com", "blabla");
        assertEquals(loginPage.getErrorMessage(), "These credentials do not match our records.", "Error message didn't match");
    }
}
