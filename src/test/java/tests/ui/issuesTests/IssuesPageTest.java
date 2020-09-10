package tests.ui.issuesTests;

import io.qameta.allure.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import pages.MainPage;
import pages.workPanel.issues.IssueCreationPage;
import tests.ui.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class IssuesPageTest extends BaseTest {

    private MainPage page;
    /*
        public IssuesPageTest(String title, String comment, List<String> labels){

        }


        @Parameterized.Parameters
        public static List<Object[]> data(){
            List<String> iterationOne = new ArrayList<>();
            iterationOne.add("bug");
            iterationOne.add("documentation");


            return Arrays.asList(new Object[][]{{
                "Test title", "Test Comment", new ArrayList<String>(){
                    {
                        add("bug");
                        add("documentation"); }
                }
            }
            });

        }
    (*/
    @Before
    public void init(){
        this.page = new LoginPage(this.driver)
                .login();
    }

    @Ignore
    @Owner("BKuso")
    @Feature("Some feature")
    @Story("Some Story")
    @Severity(SeverityLevel.CRITICAL)
    @Description("")
    @TmsLink("")
    @TmsLinks({@TmsLink(""), @TmsLink("")})
    @Link("")
    @Links({@Link(""), @Link("")})
    @Issue("")
    @Issues(@Issue(""))
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
