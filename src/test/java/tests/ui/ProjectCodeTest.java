package tests.ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;

public class ProjectCodeTest extends BaseTest{

    private MainPage page;

    @Before
    public void init(){
        this.page = new LoginPage(this.driver)
                .login();
    }

    @Test
    public void checkSearch(){
        this.page.searchProject("BKuso/G44Automation")
                .openPomFile()
                .showAllVersion();
    }

    @After
    public void exit(){
        this.page.logout();
    }

}
