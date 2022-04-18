package tests;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest{

    @Test
    public void login() {
        open("login");
        loginPage.login("saifulina.qa@gmail.com", "iH96sFQBYV@4.Mx");
    }
}

// $("#inputEmail").sendKeys("saifulina.qa@gmail.com");
// $("#inputPassword").sendKeys("iH96sFQBYV@4.Mx");
// $("#btnLogin").click();
// $("#createButton").shouldBe(Condition.visible);