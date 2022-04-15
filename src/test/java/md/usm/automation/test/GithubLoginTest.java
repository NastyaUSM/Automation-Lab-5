package md.usm.automation.test;

import md.usm.automation.pom.GithubPage;
import md.usm.automation.pom.SignInPage;
import md.usm.automation.pom.UserPage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class GithubLoginTest extends UiTest {

    //Валидный кейс
    public void testLoginWithExistingUser(){
        driver.get("https://github.com/");
        GithubPage page = new GithubPage(driver);
        SignInPage signInPage = page.clickSignIn();
        UserPage userPage = signInPage.login("anastasiaqaa", "@cB5uzHHAQ9pbt@");
        Assert.assertTrue(userPage.isAuthorized());
    }

    //Невалидный кейс
    public void testLoginWithNonExistingUser(){
        driver.get("https://github.com/");
        GithubPage page = new GithubPage(driver);
        SignInPage signInPage = page.clickSignIn();
        signInPage.login("anastasiaqaa", "123456789");
        Assert.assertTrue(signInPage.errorIsShown());
    }
}
