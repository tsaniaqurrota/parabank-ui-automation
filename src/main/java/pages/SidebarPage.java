package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SidebarPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[1]/a")
    private WebElement newAcc;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[2]/a")
    private WebElement accOverview;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[3]/a")
    private WebElement transferFunds;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[4]/a")
    private WebElement billPay;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[5]/a")
    private WebElement findTransactions;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[6]/a")
    private WebElement updateContact;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[7]/a")
    private WebElement reqLoan;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[8]/a")
    private WebElement logoutLink;

    public SidebarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickNewAccount() {
        newAcc.click();
    }

    public void clickAccountOverview() {
        accOverview.click();
    }

    public void clickTransferFunds() {
        transferFunds.click();
    }

    public void clickBillPay() {
        billPay.click();
    }

    public void clickFindTransactions() {
        findTransactions.click();
    }

    public void clickUpdateContact() {
        updateContact.click();
    }

    public void clickRequestLoan() {
        reqLoan.click();
    }

    public void clickLogout() {
        logoutLink.click();
    }
}
