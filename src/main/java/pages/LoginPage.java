package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    private String loginPageUrl = "https://parabank.parasoft.com/parabank/login.htm";


    @FindBy(xpath = "//*[@id=\"loginPanel\"]/form/div[1]/input")
    private WebElement usernameLogin;

    @FindBy(xpath = "//*[@id=\"loginPanel\"]/form/div[2]/input")
    private WebElement passwordLogin;
    @FindBy(xpath = "//*[@id=\"loginPanel\"]/form/div[3]/input")
    private WebElement btnLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage() {
        driver.get(loginPageUrl);
    }

    public void inputCredential(String username, String password) {
        usernameLogin.sendKeys(username);
        passwordLogin.sendKeys(password);
    }

    public void clickLoginBtn() {
        btnLogin.click();
    }
}
