package com.krafttechnologie.tests.day8_WebElements2;

import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.Driver;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class isDisplayed {

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
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement inputBox = driver.findElement(By.id("firstName"));
        System.out.println("inputBox.isDisplayed() = " + inputBox.isDisplayed());
        System.out.println("inputBox.isEnabled() = " + inputBox.isEnabled());
        System.out.println("inputBox.isSelected() = " + inputBox.isSelected());
    }

    @Test
    public void test2(){
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement genderButton = driver.findElement(By.xpath("//label[@class='custom-control-label'][1]"));
        System.out.println("genderButton.isDisplayed() = " + genderButton.isDisplayed());
        System.out.println("genderButton.isEnabled() = " + genderButton.isEnabled());
        System.out.println("genderButton.isSelected() = " + genderButton.isSelected());
        Assert.assertTrue(genderButton.isDisplayed(),"Failed");
        Assert.assertTrue(genderButton.isEnabled(), "failed");
        Assert.assertFalse(genderButton.isSelected(), "Failed");

    }

}
