package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.RegisterPage;

import java.time.Duration;

public class RegisterStepDef {
    WebDriver driver;
    RegisterPage registerPage;
    HomePage homePage;

    public RegisterStepDef() {
        this.driver = Hooks.getDriver();
        this.homePage = new HomePage(driver);
        this.registerPage = new RegisterPage(driver);
    }

    @Given("^User is on parabank homepage$")
    public void userIsOnParabankHomepage() {
        homePage.open();
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftPanel']/h2"))
        );
    }

    @When("^User click register link button$")
    public void userClickRegisterLinkButton() {
        homePage.clickRegisterBtn();
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Signing up is easy!')]"))
        );
    }

    @And("^User inputs valid registration details$")
    public void userInputsValidRegistrationDetails() {
        registerPage.fillRegistrationForm(
                "John", "Doe", "123 Main St", "Springfield", "IL", "62701",
                "1234567890", "123-45-6789", "password", "password"
        );
    }

    @And("^User submits the registration form$")
    public void userSubmitsTheRegistrationForm() {
        registerPage.submitForm();
    }

    @Then("^User registers successfully$")
    public void userRegistersSuccessfully() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Your account was created successfully. You are now logged in.')]"))
        );
    }

    @And("User inputs registration details with existing username")
    public void userInputsRegistrationDetailsWithExistingUsername() {
        registerPage.fillRegistrationForm(
                "Jane", "Smith", "456 Oak St", "Springfield", "IL", "62701",
                "1234567890", "123-45-6789", "user123", "password", "password"
        );
    }

    @Then("User gets alert username already exists")
    public void userGetsAlertUsernameAlreadyExists() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'This username already exists.')]"))
        );
    }

    @And("User inputs registration details with mismatched passwords")
    public void userInputsRegistrationDetailsWithMismatchedPasswords() {
        registerPage.fillRegistrationForm(
                "Jane", "Smith", "456 Oak St", "Springfield", "IL", "62701",
                "1234567890", "123-45-6789", "password", "password0"
        );
    }

    @Then("User gets error password did not match")
    public void userGetsErrorPasswordDidNotMatch() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Passwords did not match.')]"))
        );
    }


    @And("^User inputs registration details with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void userInputsRegistrationDetailsWith(String firstName, String lastName, String street, String city, String state, String zipCode, String phone, String ssn, String username, String password, String confirmPassword) {
        registerPage.fillRegistrationForm(
                firstName, lastName, street, city, state, zipCode, phone, ssn, username, password, confirmPassword
        );
    }

    @Then("^User gets error \"([^\"]*)\"$")
    public void userGetsError(String errorMessage) {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + errorMessage + "')]"))
        );
    }
}
