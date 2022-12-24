package com.krafttechnologie.tests.day8_WebElements2;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class isEnabled {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
        driver.get("https://www.krafttechexlab.com/forms/checkbox");
        WebElement checkBox1Button = driver.findElement(By.cssSelector("#gridCheck1"));
        System.out.println("checkBox1Button.isEnabled() = " + checkBox1Button.isEnabled());
        System.out.println("checkBox1Button.isDisplayed() = " + checkBox1Button.isDisplayed());
        System.out.println("checkBox1Button.isSelected() = " + checkBox1Button.isSelected());

        Assert.assertTrue(checkBox1Button.isEnabled(), "verify is failed");
        Assert.assertFalse(checkBox1Button.isSelected(),"failed");

    }
}
