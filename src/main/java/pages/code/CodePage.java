package pages.code;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import static java.lang.Thread.sleep;

public class CodePage extends BasePage {

    public CodePage(WebDriver driver) {
        super(driver);
    }

    private final By pomFileButton = By.xpath("//a[@title = 'pom.xml']");

    public POMXmlPage openPomFile(){
        log.info("Открываем файл pom.xml");
        try {
            sleep(500);
        } catch (InterruptedException e) {
            log.error(e);
        }
        Assert.assertTrue(this.driver.findElement(pomFileButton).isDisplayed());
        this.driver.findElement(pomFileButton).click();
        log.info("Кнопка видима и нажата");
        return new POMXmlPage(driver);
    }

}
