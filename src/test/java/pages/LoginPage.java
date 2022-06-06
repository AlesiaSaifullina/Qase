package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage extends BasePage {

    public static final SelenideElement USER_EMAIL = $("#inputEmail");
    public static final SelenideElement USER_PASSWORD = $("#inputPassword");
    public static final SelenideElement LOGIN_BUTTON = $("#btnLogin");
    public static final SelenideElement ERROR_MESSAGE = $(byXpath("//div[contains(@class,'form-control-feedback')]"));


    @Step("Opening login page")
    public LoginPage openPage() {
        log.info("Opening login page");
        open("login");
        return this;
    }

    @Step("Log in with '{user}' and '{password}'")
    public ProjectsList login(String user, String password) {
        log.info("Log in by {} using password {}", user, password);
        USER_EMAIL.sendKeys(user);
        USER_PASSWORD.sendKeys(password);
        LOGIN_BUTTON.click();
        waitForPageLoaded();
        return new ProjectsList();
    }

    @Step("Getting error message")
    public String getErrorMessage() {
        return ERROR_MESSAGE.getText();
    }
}