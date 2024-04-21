package ui.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ui.utils.ConfigManager;

public abstract class SeleniumBase {
    protected WebDriver webDriver;
    protected ConfigManager config;

    public SeleniumBase(WebDriver webDriver) {
        this.webDriver = webDriver;
        String configFilePath = "ui/properties/config.properties";
        config = new ConfigManager(configFilePath);
    }

    protected void navigateToUrl(String url) {
        webDriver.get(url);
    }

    protected WebElement findElement(By locator) {
        return webDriver.findElement(locator);
    }

    protected void enterInputValue(By locator, String text) {
        WebElement inputElement = findElement(locator);
        inputElement.clear();
        inputElement.sendKeys(text);
    }

    protected void selectDropdownByValue(By locator, String value) {
        new Select(findElement(locator)).selectByValue(value);
    }

    protected void selectDropdownByIndex(By locator, int index) {
        new Select(findElement(locator)).selectByIndex(index);
    }

    protected void clickButton(By locator) {
        findElement(locator).click();
        pause();
    }

    protected void pause() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
