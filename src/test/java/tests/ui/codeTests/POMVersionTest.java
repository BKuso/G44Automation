package tests.ui.codeTests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import tests.ui.BaseTest;

public class POMVersionTest extends BaseTest {


    private MainPage page;

    @Before
    public void logIn(){
        this.page = new LoginPage(this.driver).login();
    }

    @Test
    public void checkPom(){
        this.page.openCodePage()
                .openPomFile()
                .showAllVersion();
    }
}
