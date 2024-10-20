package mateusz.rusinowicz.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @Before
    public void setUp() {
        try {
            Properties properties = new Properties();
            FileInputStream configStream = new FileInputStream("src/main/resources/config.properties");
            properties.load(configStream);
            String relativePath = properties.getProperty("chrome.driver.path");
            String absolutePath = new File(relativePath).getAbsolutePath();
            System.setProperty("webdriver.chrome.driver", absolutePath);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
            driver.get("https://circlek-public.github.io/cki-service-recruitment-task/");
            logger.info("Driver initialized and navigated to the test page.");
        } catch (IOException e) {
            logger.error("Error loading configuration: ", e);
            throw new RuntimeException(e);
        } catch (Exception e) {
            logger.error("Error during setup: ", e);
            throw e;
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Driver quit successfully.");
        }
    }
}