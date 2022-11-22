package com.tests.day14_properties_singleton;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.utilities.ConfigurationReader;
import com.utilities.WebDriverFactory;

public class PropertiesTest {
    @Test
    public void testName() {
        String browser = ConfigurationReader.get("browser");
        System.out.println("browser = " + browser);
        String url = ConfigurationReader.get("url");
        System.out.println("url = " + url);
    }

    @Test
    public void openBrowserUsingConfigurationReader() {
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.name("email"))
                .sendKeys(ConfigurationReader.get("username"));
        driver.findElement(By.name("password"))
                .sendKeys(ConfigurationReader.get("password")
                        + Keys.ENTER);
    }
}
