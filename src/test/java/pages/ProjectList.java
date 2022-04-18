package pages;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class ProjectList extends BasePage {

    public SelenideElement createButton = $("#createButton");

    public void clickNewCreate() {
        createButton.click();
       // $(".col").shouldBe(Condition.visible);
    }

    public ProjectList() {
    }
}
