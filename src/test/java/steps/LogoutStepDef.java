package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;
import pages.SidebarPage;

public class LogoutStepDef {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    SidebarPage sidebarPage;

    public LogoutStepDef() {
        this.driver = Hooks.getDriver();
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.sidebarPage = new SidebarPage(driver);
    }
    @When("User click logout link button")
    public void userClickLogoutLinkButton() {
        sidebarPage.clickLogout();
    }

    @Then("User logouts successfully")
    public void userLogoutsSuccessfully() {
        assert driver.getCurrentUrl().equals("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
    }
}
