package ui.pages;

import org.openqa.selenium.WebDriver;
import ui.base.SeleniumBase;

public class LoginPage extends SeleniumBase {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        navigateToUrl(config.getProperty("base.url"));
    }

    public void login(String username, String password) {
        enterInputValue(config.getLocator("usernameLocator"), username);
        enterInputValue(config.getLocator("passwordLocator"), password);
        clickButton(config.getLocator("loginButtonLocator"));
    }
}
