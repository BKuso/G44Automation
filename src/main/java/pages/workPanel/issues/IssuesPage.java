package pages.workPanel.issues;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.workPanel.WorkPanelMenu;

public class IssuesPage extends WorkPanelMenu {

    public IssuesPage(WebDriver driver) {
        super(driver);
    }

    private final By newIssueButton = By.xpath("//a[@role='button']");
    private final By issueTitlesList = By.xpath("//a[@data-hovercard-type='issue']");

    public IssueCreationPage pressNewIssueButton(){
        this.driver.findElement(newIssueButton).click();
        return new IssueCreationPage(this.driver);
    }



}
