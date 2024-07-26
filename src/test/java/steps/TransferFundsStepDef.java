package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class TransferFundsStepDef {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    SidebarPage sidebarPage;
    TransferFundsPage transferFundsPage;
    OverviewPage overviewPage;
    Map<String, Double> initialBalances = new HashMap<>();

    public TransferFundsStepDef() {
        this.driver = Hooks.getDriver();
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.sidebarPage = new SidebarPage(driver);
        this.transferFundsPage = new TransferFundsPage(driver);
        this.overviewPage = new OverviewPage(driver);
    }
    @When("User click transfer funds link button on sidebar")
    public void userClickTransferFundsLinkButtonOnSidebar() {
        sidebarPage.clickTransferFunds();
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        assert driver.getCurrentUrl().equals("https://parabank.parasoft.com/parabank/transfer.htm");

    }

    @And("User inputs valid {string}")
    public void userInputsValid(String transferAmount) {
        transferFundsPage.inputTransferAmount(transferAmount);
    }

    @And("User selects account for the transaction")
    public void userSelectsFromAccountToAccount() {
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fromAccountId\"]/option"))
        );
        transferFundsPage.selectFromAccount();
        transferFundsPage.selectToAccount();
    }

    @And("User clicks transfer")
    public void userClicksTransfer() {
        transferFundsPage.submitTransfer();
    }

    @Then("User transfer funds successfully with message ${string} has been transferred")
    public void userTransferFundsSuccessfullyWithMessage$HasBeenTransferred(String transferAmount) {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        WebElement amountResultElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"amountResult\"]"))
        );
        String actualTransferAmount = amountResultElement.getText();
        String expectedTransferAmount = "$" + transferAmount + ".00";
        assertEquals("The actual transfer amount should match the expected transfer amount", expectedTransferAmount, actualTransferAmount);

    }

    @And("User inputs invalid {string}")
    public void userInputsInvalid(String invalidTransferAmount) {
        transferFundsPage.inputTransferAmount(invalidTransferAmount);
    }

    @Then("User transfers funds failed with {string}")
    public void userTransferFundsFailedWith(String errorMessage) {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        WebElement errorElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"amountResult\"]"))
        );
        String actualErrorMessage = errorElement.getText();
        assertEquals("The error message should match the expected error message", errorMessage, actualErrorMessage);
    }
}
