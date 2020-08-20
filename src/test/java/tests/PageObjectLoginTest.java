package tests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;

public class PageObjectLoginTest extends BaseTest{

    private LoginPage loginPage;
    private MainPage mainPage;

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
    public void a_positiveAuthTest(){
        mainPage = this.loginPage.login()
                .validateSuccess("Learn Git and GitHub without any code!");
    }

    @Test
    public void b_checkMainPage(){
        mainPage.validateSuccess("");
    }


    @Test
    public void checkOurCommits(){
        this.loginPage.login()
                .openCommits();
    }



}
