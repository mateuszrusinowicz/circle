package mateusz.rusinowicz.tests;

import mateusz.rusinowicz.pages.LoginPage;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .typeEmail("test01@example.com")
                .typePassword("pass123")
                .clickSignIn()
                .verifySuccessLogInMessage();
    }
}