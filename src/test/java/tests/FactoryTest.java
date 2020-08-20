package tests;

import org.junit.Before;
import org.junit.Test;
import pages.PageFactory;

public class FactoryTest extends BaseTest{

    private PageFactory factory;

    @Before
    public void init(){
        factory = new PageFactory(driver);

    }

    @Test
    public void checkLogin(){
       factory.login();
    }

}
