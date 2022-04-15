package md.usm.automation.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.Image;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class UserPage {

    private final WebDriver driver;

    @FindBy(xpath = "//img[contains(@class, 'avatar-small')]")
    private Image userAvatar;

    public UserPage(final WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        this.driver = driver;
    }

    public boolean isAuthorized(){
        return userAvatar.isDisplayed();
    }
}
