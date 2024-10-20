package mateusz.rusinowicz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public abstract class PageActions {
    protected WebDriver driver;
    private static final int TIMEOUT = 10;

    public PageActions(WebDriver driver) {
        this.driver = driver;
    }

    protected void clickElement(WebElement element) {
        waitForVisibility(element).click();
    }

    protected void sendKeysToElement(WebElement element, String text) {
        waitForVisibility(element).sendKeys(text);
    }

    protected WebElement waitForVisibility(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element));
    }
}