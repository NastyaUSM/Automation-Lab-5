package md.usm.automation.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class SignInPage {

    private final WebDriver driver;

    @FindBy(xpath = "//input[@id='login_field']")
    private TextInput loginInput;

    @FindBy(xpath = "//input[@id='password']")
    private TextInput passwordInput;

    @FindBy(xpath = "//input[contains(@value, 'Sign in')]")
    private Button signInButton;

    @FindBy(xpath = "//*[@id='js-flash-container']//*[contains(@class, 'error')]")
    private TextBlock error;

    public SignInPage(final WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        this.driver = driver;
    }

    public UserPage login(String login, String password){
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        signInButton.click();
        return new UserPage(driver);
    }

    public boolean errorIsShown(){
        return error.isDisplayed();
    }
}
