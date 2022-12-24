package com.krafttechnologie.tests.day8_WebElements2;

import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class isSelected {

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
        WebElement checkBox2 = driver.findElement(By.cssSelector("#gridCheck2"));
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());

        Assert.assertTrue(checkBox2.isSelected(), "failed");
    }

    @Test
    public void test2() {

        driver.get("https://www.krafttechexlab.com/forms/checkbox");
        WebElement checkBox3 = driver.findElement(By.cssSelector("#gridCheck3"));
        System.out.println("checkBox3.isSelected() = " + checkBox3.isSelected());
        System.out.println("checkBox3.isEnabled() = " + checkBox3.isEnabled());

        Assert.assertTrue(checkBox3.isSelected(), "failed");
        Assert.assertFalse(checkBox3.isEnabled(), "failed ");

    }

    @Test
    public void test3() {

        driver.get("https://www.krafttechexlab.com/forms/radio");
        WebElement radio1Button = driver.findElement(By.cssSelector("#gridRadios1"));
        WebElement radio2Button = driver.findElement(By.cssSelector("#gridRadios2"));
        System.out.println("radio1Button.isSelected() = " + radio1Button.isSelected());
        System.out.println("radio2Button.isSelected() = " + radio2Button.isSelected());

        Assert.assertTrue(radio1Button.isSelected(), "failed");
        Assert.assertFalse(radio2Button.isSelected(), "failed");
        BrowserUtils.waitFor(2);
        radio2Button.click();
        BrowserUtils.waitFor(2);
        Assert.assertFalse(radio1Button.isSelected());
        Assert.assertTrue(radio2Button.isSelected());

    }
}
