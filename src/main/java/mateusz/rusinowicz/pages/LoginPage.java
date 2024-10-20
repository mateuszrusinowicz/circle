package mateusz.rusinowicz.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageActions {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordField;

    @FindBy(id = "login_btn")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage typeEmail(String email) {
        try {
            sendKeysToElement(emailInput, email);
            logger.info("Entered email: " + email);
        } catch (Exception e) {
            logger.error("Error entering email: ", e);
            throw e;
        }
        return this;
    }

    public LoginPage typePassword(String password) {
        try {
            sendKeysToElement(passwordField, password);
            logger.info("Entered password.");
        } catch (Exception e) {
            logger.error("Error entering password: ", e);
            throw e;
        }
        return this;
    }

    public HomePage clickSignIn() {
        try {
            clickElement(signInButton);
            logger.info("Clicked Sign In button.");
        } catch (Exception e) {
            logger.error("Error clicking Sign In button: ", e);
            throw e;
        }
        return new HomePage(driver);
    }
}