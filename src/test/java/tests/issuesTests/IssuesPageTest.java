package tests.issuesTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import tests.BaseTest;

public class IssuesPageTest extends BaseTest {

    private MainPage page;

    @Before
    public void init(){
        this.page = new LoginPage(this.driver)
                .login();
    }

    @Test
    public void checkSearch(){
        this.page.searchProject("BKuso/G44Automation")
                .openProjectIssues()
                .pressNewIssueButton()
                .createIssue("Automated issue creation", "test", "documentation", "bug")
                .submitIssue();
    }

    @After
    public void exit(){
        this.page.logout();
    }
}
