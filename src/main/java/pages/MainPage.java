package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.workPanel.code.CodePage;

import java.util.List;

import static java.lang.Thread.sleep;

public class MainPage extends MainMenu {

    public MainPage(WebDriver driver) {
        super(driver);

    }

    private final By projectButton = By.xpath("//span[@title = 'G44Automation']");
    private final By successHead = By.xpath("//h2[@class = 'shelf-title']");
    private final String successMessage = "Learn Git and GitHub without any code!";

    private final By commitButton = By.xpath("//span[@class = 'css-truncate css-truncate-target']");

    public void openCommits(){
        Assert.assertTrue(driver.findElement(commitButton).isDisplayed());
        driver.findElement(commitButton).click();
        driver.findElement(commitButton).sendKeys(Keys.ENTER);
        driver.findElement(commitButton);
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public MainPage validateSuccess(String successMessage){
        Assert.assertTrue(this.driver.findElement(successHead).isDisplayed());
        Assert.assertEquals(successMessage, driver.findElement(successHead).getText());
        return this;
    }

    public CodePage openCodePage(){
        log.info("Переходим на страницу проекта");
        List<WebElement> buttons = driver.findElements(projectButton);
        WebElement ourButton = buttons
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .orElse(driver.findElement(commitButton));
        Assert.assertTrue("Кнопка проекта не доступна для нажатия",
                ourButton.isDisplayed());
        ourButton.click();
        return new CodePage(driver);
    }



}
