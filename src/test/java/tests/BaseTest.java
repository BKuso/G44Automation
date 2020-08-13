package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected final Logger log = LogManager.getLogger("Test");

    protected WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") +
                        "/src/main/resources/drivers/chrome/v84/chromedriver");
        switch (System.getProperty("browser", "chrome")){
            case "chrome":
                this.driver = new ChromeDriver();
                break;
            case "firefox":
                this.driver = new FirefoxDriver();
                break;
            case "internet_explorer":
            case "ie":
            case "InternetExplorer":
                this.driver = new InternetExplorerDriver();
                break;
            default:
                this.driver = new OperaDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/login");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
