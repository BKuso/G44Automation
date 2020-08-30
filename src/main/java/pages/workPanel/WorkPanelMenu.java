package pages.workPanel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.MainMenu;
import pages.workPanel.code.CodePage;
import pages.workPanel.issues.IssuesPage;

public abstract class WorkPanelMenu extends MainMenu {

    public WorkPanelMenu(WebDriver driver) {
        super(driver);
    }

    private final By codeTabButton = By.xpath("//span[@data-content='Code']");
    private final By issuesTabButton = By.xpath("//span[@data-content='Issues']");
    private final By pullRequestsTabButton = By.xpath("//span[@data-content='Pull requests']");
    private final By actionsTabButton = By.xpath("//span[@data-content='Actions']");
    private final By projectTabButton = By.xpath("//span[@data-content='Projects']");
    private final By wikiTabButton = By.xpath("//span[@data-content='Wiki']");
    private final By securityTabButton = By.xpath("//span[@data-content='Security']");
    private final By insightsTabButton = By.xpath("//span[@data-content='Insights']");
    private final By settingsTabButton = By.xpath("//span[@data-content='Settings']");

    public IssuesPage openProjectIssues(){
        Assert.assertTrue(this.driver.findElement(issuesTabButton).isDisplayed());
        this.driver.findElement(issuesTabButton).click();
        return new IssuesPage(this.driver);
    }

    public CodePage openProjectCode(){
        Assert.assertTrue(this.driver.findElement(codeTabButton).isDisplayed());
        this.driver.findElement(codeTabButton).click();
        return new CodePage(this.driver);
    }

}
