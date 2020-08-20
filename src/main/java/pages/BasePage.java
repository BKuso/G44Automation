package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;
    protected Logger log;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.log = LogManager.getLogger(this);
    }

}
