package tests.ui;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import pages.MainPage;

import java.util.*;

import static helpers.FileHelper.loadDataForProvider;

@RunWith(Parameterized.class)
public class PageObjectLoginTest extends BaseTest{

    private LoginPage loginPage;
    private MainPage mainPage;

    private final String username;
    private final String password;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Map<String, String> testData = loadDataForProvider();
        Object[][] result = new Object[testData.keySet().size()][2];
        List<String> logins = new ArrayList<>(testData.keySet());
        for(int i = 0; i < testData.keySet().size(); i++){
            result[i][0] = logins.get(i);
            result[i][1] = testData.get(logins.get(i));
        }
        /*
        testData.forEach((key, value) -> {

            result[][]
        });
        */
        return Arrays.asList(result);
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
