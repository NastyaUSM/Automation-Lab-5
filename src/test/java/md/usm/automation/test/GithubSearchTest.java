package md.usm.automation.test;

import md.usm.automation.pom.GithubPage;
import md.usm.automation.pom.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class GithubSearchTest extends UiTest{

    public void testSearchInputWithText(){
        driver.get("https://github.com/");
        GithubPage githubPage = new GithubPage(driver);
        SearchPage searchPage = githubPage.search("test");
        Assert.assertTrue(searchPage.isSearchPageLoaded());
        Assert.assertEquals(searchPage.getSearchInputText(), "test");
    }

    public void testSearchInputWithEmptyText(){
        driver.get("https://github.com/");
        GithubPage githubPage = new GithubPage(driver);
        SearchPage searchPage = githubPage.search("");
        Assert.assertFalse(searchPage.isSearchPageLoaded());
        Assert.assertEquals(searchPage.getSearchInputText(), "");
    }
}
