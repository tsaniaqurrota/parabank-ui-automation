package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    private String homePageUrl = "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC";

    @FindBy(xpath = "//a[contains(@href,'register.htm')]")
    private WebElement registerButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(homePageUrl);
    }

    public void clickRegisterBtn() {
        registerButton.click();
    }
}
