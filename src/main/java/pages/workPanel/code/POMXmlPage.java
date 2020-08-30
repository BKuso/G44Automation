package pages.workPanel.code;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.workPanel.WorkPanelMenu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class POMXmlPage extends WorkPanelMenu {

    public POMXmlPage(WebDriver driver) {
        super(driver);
    }

    private final By version = By.id("LC27");
    private final By versions = By.xpath("//span[text() = 'version']/..");
    private final By artifacts = By.xpath("//span[text() = 'artifactId']/..");

    public POMXmlPage showSeleniumVersion(){
        log.info("Текущая версия библиотеки: "
                + driver.findElement(version)
                .getText()
                .replaceAll(" ", "")
                .replaceAll("<version>", "")
                .replaceAll("</version>", ""));
        return this;
    }

    public POMXmlPage showAllVersion(){
        log.info("Выводим версии");
        Map<String, String> libAndVersion = new HashMap<>();
        List<WebElement> ourVersion = driver.findElements(versions);
        driver.findElements(artifacts).forEach(
                artifact -> {
                    Assert.assertTrue(artifact.isDisplayed());
                    libAndVersion.put(artifact.getText()
                                                .replaceAll(" ", "")
                                                .replaceAll("<artifactId>", "")
                                                .replaceAll("</artifactId>", ""),
                            ourVersion.get(driver.findElements(artifacts).indexOf(artifact))
                                    .getText()
                                    .replaceAll(" ", "")
                                    .replaceAll("<version>", "")
                                    .replaceAll("</version>", ""));
                });
        libAndVersion.forEach( (key, value) -> {
            log.info(key + ": "+ value);
        });
    /*    for (WebElement version : driver.findElements(versions)){
            log.info("Найдена версия: "+ version.getText()
                    .replaceAll(" ", "")
                    .replaceAll("<version>", "")
                    .replaceAll("</version>", ""));
        }*/
        return this;
    }
}
