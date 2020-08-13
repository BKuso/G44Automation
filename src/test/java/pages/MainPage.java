package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);

    }

    private final By successHead = By.xpath("//h2[@class = 'shelf-title']");
    private final String successMessage = "Learn Git and GitHub without any code!";

    private final By commitButton = By.xpath("//span[@class = 'css-truncate css-truncate-target']");

    public void openCommits(){
        Assert.assertTrue(driver.findElement(commitButton).isDisplayed());
        driver.findElement(commitButton).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void validateSuccess(String successMessage){
        Assert.assertTrue(this.driver.findElement(successHead).isDisplayed());
        Assert.assertEquals(successMessage, driver.findElement(successHead).getText());
    }
}
