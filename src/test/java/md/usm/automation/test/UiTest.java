package md.usm.automation.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class UiTest {

    protected WebDriver driver;

    @BeforeSuite
    public void setup(){
        File driver = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", driver.getAbsolutePath());
    }

    @BeforeMethod
    public void createDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void close(){
        if (driver != null) {
            driver.quit();
        }
    }
}
