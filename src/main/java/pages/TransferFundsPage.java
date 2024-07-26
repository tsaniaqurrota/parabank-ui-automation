package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class TransferFundsPage extends BasePage {
    private String transferFundsPageUrl = "https://parabank.parasoft.com/parabank/transfer.htm";

    @FindBy(id = "amount")
    private WebElement transferAmountField;
    @FindBy(xpath = "//*[@id=\"fromAccountId\"]")
    private WebElement fromAccountIdDropdown;
    @FindBy(xpath = "//*[@id=\"toAccountId\"]")
    private WebElement toAccountIdDropdown;
    @FindBy(xpath = "//*[@id=\"transferForm\"]/div[2]/input")
    private WebElement transferBtn;

    public TransferFundsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void inputTransferAmount(String amount) {
        transferAmountField.sendKeys(amount);
    }

    public String selectFromAccount() {
        Select fromAccountSelect = new Select(fromAccountIdDropdown);
        WebElement selectedOption = fromAccountSelect.getFirstSelectedOption();
        String selectedAccountId = selectedOption.getText();
        return selectedAccountId;
    }

    public String selectToAccount() {
        Select toAccountSelect = new Select(toAccountIdDropdown);
        WebElement selectedOption = toAccountSelect.getFirstSelectedOption();
        String selectedAccountId = selectedOption.getText();
        return selectedAccountId;
    }
    public void submitTransfer() {
        transferBtn.click();
    }
}

