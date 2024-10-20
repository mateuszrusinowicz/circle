package mateusz.rusinowicz.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageActions {
    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(id = "message")
    private WebElement loginMessage;

    private static final String LOGIN_SUCCESSFUL = "Login successful";

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getLoginMessage() {
        try {
            String message = loginMessage.getText();
            logger.info("Login message: " + message);
            return message;
        } catch (Exception e) {
            logger.error("Error getting login message: ", e);
            throw e;
        }
    }

    public HomePage verifySuccessLogInMessage() {
        waitForVisibility(loginMessage);
        Assert.assertEquals(LOGIN_SUCCESSFUL, getLoginMessage());
        return this;
    }
}