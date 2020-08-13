package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageFactory {

    @FindBy(id = "login_field")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(name = "commit")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class = 'container-lg px-2']")
    private WebElement errorMessage;

    @FindBy(xpath = "//h2[@class = 'shelf-title']")
    private WebElement successHead;

    private WebDriver driver;

    public PageFactory(WebDriver driver){
        this.driver = driver;
        org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }

    public void login(){
        validateTrue(usernameField);
        validateTrue(passwordField);
        validateTrue(signInButton);

        usernameField.sendKeys(System.getProperty("username"));
        passwordField.sendKeys(System.getProperty("password"));
        signInButton.click();
        validateTrue(successHead);
    }


    private void validateTrue(WebElement element){
        Assert.assertTrue(element.isEnabled());
    }

}
