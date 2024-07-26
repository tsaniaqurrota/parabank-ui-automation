package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class OpenAccPage extends BasePage {
    @FindBy(id = "type")
    private WebElement accountTypeDropdown;

    @FindBy(id = "fromAccountId")
    private WebElement existingAccountDropdown;

    @FindBy(xpath = "//*[@class='button'][@value='Open New Account']")
    private WebElement openNewAccountBtn;

    public OpenAccPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectAccountType(String accountType) {
        Select select = new Select(accountTypeDropdown);
        select.selectByVisibleText(accountType);
    }

    public void clickOpenNewAccount() {
        openNewAccountBtn.click();
    }
}
