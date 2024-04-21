package ui.utils;

import org.openqa.selenium.By;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class ConfigManager {
    private final Properties properties;

    public ConfigManager(String filePath) {
        properties = new Properties();
        loadProperties(filePath);
    }

    private void loadProperties(String filePath) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            if (inputStream == null) {
                throw new IOException("Unable to find " + filePath);
            }
            properties.load(inputStream);
        } catch (IOException ioException) {
            Logger.getLogger(ioException.getMessage());
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public By getLocator(String key) {
        String webLocatorType = properties.getProperty(key);

        if (webLocatorType != null) {
            String[] splitElements = webLocatorType.split(":", 2);

            if (splitElements.length == 2) {
                return getByType(splitElements[0], splitElements[1]);
            }
        }
        throw new IllegalArgumentException("Invalid locator key: %s".formatted(key));
    }

    private By getByType(String type, String value) {
        return switch (type) {
            case "id" -> By.id(value);
            case "linkText" -> By.linkText(value);
            case "partialLinkText" -> By.partialLinkText(value);
            case "name" -> By.name(value);
            case "tagName" -> By.tagName(value);
            case "xpath" -> By.xpath(value);
            case "className" -> By.className(value);
            case "cssSelector" -> By.cssSelector(value);
            default -> throw new IllegalArgumentException("%nInvalid locator type: %s".formatted(type));
        };
    }
}
