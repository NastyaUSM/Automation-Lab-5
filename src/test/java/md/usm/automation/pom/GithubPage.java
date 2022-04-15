package md.usm.automation.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class GithubPage {

    private final WebDriver driver;

    @FindBy(xpath = "//form/label/input[contains(@name, 'q')]")
    private TextInput searchInput;

    @FindBy(xpath = "//a[contains(text(), 'Sign in')]")
    private Button signInButton;

    public GithubPage(final WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        this.driver = driver;
    }

    public SearchPage search(String text){
        searchInput.clear();
        searchInput.sendKeys(text);
        searchInput.sendKeys(Keys.ENTER);
        return new SearchPage(driver);
    }

    public SignInPage clickSignIn(){
        signInButton.click();
        return new SignInPage(driver);
    }
}
