package pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    public SelenideElement userInput = $("#inputEmail");
    public SelenideElement passwordInput = $("#inputPassword");
    public SelenideElement loginButton = $("#btnLogin");
    public SelenideElement createButton = $("#createButton");

    public LoginPage() {

    }
    public void login(String email, String password) {
        userInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
        createButton.shouldBe(Condition.visible);
    }
}