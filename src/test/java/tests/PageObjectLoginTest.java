package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import pages.MainPage;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PageObjectLoginTest extends BaseTest{

    private LoginPage loginPage;
    private MainPage mainPage;

    private final String username;
    private final String password;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
                {"test_login1", "test_password1"},
                {"test_login2", "test_password2"},
                {"test_login3", "test_password3"},
                {"test_login4", "test_password4"},
                {"test_login5", "test_password5"},
        });
    }

    public PageObjectLoginTest(String login, String password){
        this.username = login;
        this.password = password;
    }

    @Before
    public void init(){
        this.loginPage = new LoginPage(this.driver);
    }

    @Test
    public void negativeAuthTest(){
        this.loginPage.login(this.username, this.password)
                .validateError("Incorrect username or password.");
    }
/*
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

*/

}
