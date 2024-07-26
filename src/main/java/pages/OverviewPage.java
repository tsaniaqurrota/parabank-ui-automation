package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OverviewPage extends BasePage {
    private String overviewPageUrl = "https://parabank.parasoft.com/parabank/overview.htm";

    SidebarPage sidebarPage;

    @FindBy(xpath = "//*[@id=\"accountDetails\"]/h1")
    private WebElement accOverview;
    @FindBy(xpath = "//*[@id='accountTable']/tbody/tr")
    private List<WebElement> accountRows;


    public OverviewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        SidebarPage sidebar = new SidebarPage(driver);
    }

    public void openOverviewPage() {
        driver.get(overviewPageUrl);
    }

    public Map<String, Double> getAccountBalances(String... accountIds) {
        Map<String, Double> accountBalances = new HashMap<>();
        for (String accountId : accountIds) {
            String balanceText = driver.findElement(By.xpath("//td[contains(text(),'" + accountId + "')]/following-sibling::td[1]")).getText();
            double balance = Double.parseDouble(balanceText.replace("$", "").replace(",", ""));
            accountBalances.put(accountId, balance);
        }
        return accountBalances;
    }


}
