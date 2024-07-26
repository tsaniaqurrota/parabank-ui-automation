package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;
import pages.OpenAccPage;
import pages.SidebarPage;

import java.time.Duration;

public class NewAccStepDef {
    WebDriver driver;
    HomePage homePage;
    SidebarPage sidebarPage;
    OpenAccPage newAccountPage;
    LoginPage loginPage;

    public NewAccStepDef() {
        this.driver = Hooks.getDriver();
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.sidebarPage = new SidebarPage(driver);
        this.newAccountPage = new OpenAccPage(driver);
    }
    @Given("User has logged in")
    public void userHasLoggedIn() {
        homePage.open();
        loginPage.inputCredential("user123", "password");
        loginPage.clickLoginBtn();
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        assert driver.getCurrentUrl().equals("https://parabank.parasoft.com/parabank/overview.htm");
    }

    @When("User click open new account link button on sidebar")
    public void userClickOpenNewAccountLinkButtonOnSidebar() {
        sidebarPage.clickNewAccount();
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        assert driver.getCurrentUrl().equals("https://parabank.parasoft.com/parabank/openaccount.htm");
    }

    @And("User selects account type {string} and existing account")
    public void userSelectsAccountTypeAndExistingAccount(String accountType) {
        newAccountPage.selectAccountType(accountType);
    }

    @And("User click open new account")
    public void userClickOpenNewAccount() {
        newAccountPage.clickOpenNewAccount();
    }

    @Then("User new acc successfully created")
    public void userNewAccSuccessfullyCreated() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        // Get the new account ID
        String newAccountId = driver.findElement(By.xpath("//*[@id='newAccountId']")).getText();
        // Navigate to account overview
        sidebarPage.clickAccountOverview();
        // Verify the new account ID appears in the account overview table
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), '" + newAccountId + "')]"))
        );
    }


}
