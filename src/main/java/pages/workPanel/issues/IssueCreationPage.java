package pages.workPanel.issues;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.workPanel.WorkPanelMenu;

import java.util.Arrays;
import java.util.stream.Stream;

public class IssueCreationPage extends WorkPanelMenu {

    public IssueCreationPage(WebDriver driver) {
        super(driver);
    }

    private final By titleField = By.id("issue_title");
    private final By commentField = By.id("issue_body");
    private final By additionalFieldButtons =
            By.xpath("//summary[@class = 'text-bold discussion-sidebar-heading " +
                    "discussion-sidebar-toggle hx_rsm-trigger']");
    private final By labelSearchField = By.id("label-filter-field");
    private By labelLocator(String name){
        return By.xpath(String.format("//span[text() = '%s']", name));
    }

    public IssueCreationPage createIssue(String title, String comment, String... labels){
        Assert.assertTrue(this.driver.findElement(titleField).isDisplayed());
        this.driver.findElement(titleField).sendKeys(title);
        this.driver.findElement(commentField).sendKeys(comment);
        this.driver.findElements(additionalFieldButtons).get(1).click();
        Arrays.stream(labels).forEach(label -> {
            Assert.assertTrue(this.driver.findElement(labelLocator(label)).isDisplayed());
            this.driver.findElement(labelLocator(label)).click();
        });
        this.driver.findElement(commentField).click();
        return new IssueCreationPage(this.driver);

    }

    public void submitIssue(){
        //"//button[contains(text(), 'Submit new issue')]"[]
    }
}
