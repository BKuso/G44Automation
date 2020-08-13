package tests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

public class PageObjectLoginTest extends BaseTest{

    private LoginPage loginPage;

    @Before
    public void init(){
        this.loginPage = new LoginPage(this.driver);
    }

    @Test
    public void negativeAuthTest(){
        this.loginPage.login("TestUser", "TestPassword")
                .validateError("Incorrect username or password.");
    }

    @Test
    public void positiveAuthTest(){
        this.loginPage.login()
                .validateSuccess("Learn Git and GitHub without any code!");
    }


    @Test
    public void checkOurCommits(){
        this.loginPage.login()
                .openCommits();
    }



}
