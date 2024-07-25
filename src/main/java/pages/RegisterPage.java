package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class RegisterPage extends BasePage {
    private String registerPageUrl = "https://parabank.parasoft.com/parabank/register.htm";

    @FindBy(id = "customer.firstName")
    private WebElement firstnameField;

    @FindBy(name = "customer.lastName")
    private WebElement lastnameField;

    @FindBy(id = "customer.address.street")
    private WebElement addressstreetField;

    @FindBy(id = "customer.address.city")
    private WebElement addressCityField;

    @FindBy(id = "customer.address.state")
    private WebElement addressStateField;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[6]/td[2]/input")
    private WebElement addressCodeField;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneField;

    @FindBy(id = "customer.ssn")
    private WebElement ssnField;

    @FindBy(id = "customer.username")
    private WebElement usernameField;

    @FindBy(id = "customer.password")
    private WebElement passField;

    @FindBy(id = "repeatedPassword")
    private WebElement confirmPassField;

    @FindBy(xpath = "//*[@class='button'][@value='Register']")
    private WebElement submitBtn;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getRandomUsername() {
        Random rand = new Random();
        int userRand = rand.nextInt(10000);
        return "user" + userRand;
    }

    public void fillRegistrationForm(String firstName, String lastName, String street, String city, String state, String zipCode, String phone, String ssn, String password, String confirmPassword) {
        fillRegistrationForm(firstName, lastName, street, city, state, zipCode, phone, ssn, getRandomUsername(), password, confirmPassword);
    }

    public void fillRegistrationForm(String firstName, String lastName, String street, String city, String state, String zipCode, String phone, String ssn, String username, String password, String confirmPassword) {
        firstnameField.sendKeys(firstName);
        lastnameField.sendKeys(lastName);
        addressstreetField.sendKeys(street);
        addressCityField.sendKeys(city);
        addressStateField.sendKeys(state);
        addressCodeField.sendKeys(zipCode);
        phoneField.sendKeys(phone);
        ssnField.sendKeys(ssn);
        usernameField.sendKeys(username);
        passField.sendKeys(password);
        confirmPassField.sendKeys(confirmPassword);
    }

    public void submitForm() {
        submitBtn.click();
    }
}
