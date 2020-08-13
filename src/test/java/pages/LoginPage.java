package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    protected final Logger log = LogManager.getLogger("Login Page");

    private final By usernameField = By.id("login_field");
    private final By passwordField = By.id("password");
    private final By signInButton = By.name("commit");
    private final By errorMessage = By.xpath("//div[@class = 'container-lg px-2']");
    //   private final By signInButton = By.xpath("//input[@name = 'commit']");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public MainPage login(){
        validateTrue(this.driver.findElement(usernameField));
        validateTrue(this.driver.findElement(passwordField));
        validateTrue(this.driver.findElement(signInButton));

        this.driver.findElement(usernameField).sendKeys(System.getProperty("username"));
        this.driver.findElement(passwordField).sendKeys(System.getProperty("password"));
        this. driver.findElement(signInButton).click();
        return new MainPage(this.driver);
    }

    public LoginPage login(String username, String password){

        this.driver.findElement(usernameField).sendKeys(username);
        this.driver.findElement(passwordField).sendKeys(password);
        this.driver.findElement(signInButton).click();

        return new LoginPage(this.driver);
    }

    public void validateError(String errorText){
        Assert.assertEquals(errorText, driver.findElement(errorMessage).getText());
    }

    private void validateTrue(WebElement element){
        log.debug("Start test for enabled true for element: " + element);
        Assert.assertTrue(element.isEnabled());
        log.debug("Test finished");
    }

}