package someMain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestApplication {

    private static final Logger log = LogManager.getLogger("Web driver test");

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") +
                        "/src/main/resources/drivers/chrome/v84/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/BKuso/G44Automation");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error(e);
        }

        driver.quit();
    }
}
