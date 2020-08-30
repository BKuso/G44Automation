package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.workPanel.code.CodePage;
import pages.workPanel.issues.IssuesPage;

import java.util.List;

import static java.lang.String.format;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public abstract class MainMenu extends BasePage {

    private final By searchField = By.xpath("//input[@data-hotkey = 's,/']");
    private final By issuesButton = By.xpath("//a[@href='issues']");
    private final By userButton = By.xpath("//summary[@class='Header-link']");
    private final By searchResultList = By.xpath("//ul[@id='jump-to-results']/li/a");

    private final By logOutButton = By.xpath("//button[contains(text(), 'Sign out')]");

    public MainMenu(WebDriver driver) {
        super(driver);
    }

    public CodePage searchProject(final String projectTitle){
        log.info("Ищем проект "+ projectTitle);
        assertTrue(this.driver.findElement(searchField).isEnabled());
        this.driver.findElement(searchField).sendKeys(projectTitle);
        this.driver.findElement(searchField).click();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            log.error(e);
        }
        List<WebElement> results = this.driver.findElements(searchResultList);
        results.stream()
                .filter(result -> result.getAttribute("href").contains(projectTitle))
                .findFirst()
                .orElse(results.get(2))
                .click();
        log.info(String.format("Проект %s найден", projectTitle));
        return new CodePage(this.driver);
    }

    public IssuesPage openIssues(){
        this.driver.findElement(issuesButton).click();
        return new IssuesPage(this.driver);
    }

    public HomePage logout(){
        log.info("Выход из приложения");
     //   this.driver.navigate().refresh();
        this.driver.findElements(userButton).get(1).click();
        this.driver.findElement(logOutButton).click();
        return new HomePage(driver);
    }
}
