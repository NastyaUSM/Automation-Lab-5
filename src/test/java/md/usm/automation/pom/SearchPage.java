package md.usm.automation.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class SearchPage {

    private final WebDriver driver;

    @FindBy(xpath = "//input[contains(@name, 'q')]")
    private TextInput searchInput;

    @FindBy(xpath = "//button[contains(text(), 'Search')]")
    private Button searchButton;

    public SearchPage(final WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        this.driver = driver;
    }

    public boolean isSearchPageLoaded(){
        return !searchButton.isDisplayed();
    }

    public String getSearchInputText(){
        return searchInput.getText();
    }
}
