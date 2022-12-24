package com.krafttechnologie.tests.day9_WebElements3;

import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownWithSelect {
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
    public void dropDownTest() {
        driver.get("https://demoqa.com/select-menu");
        WebElement dropdownElement = driver.findElement(By.id("oldSelectMenu"));
        Select select=new Select(dropdownElement);
        String expectedOption="Red";
        String actualOption=select.getFirstSelectedOption().getText();
        System.out.println("expectedOption = " + expectedOption);
        System.out.println("actualOption = " + actualOption);
        Assert.assertEquals(actualOption,expectedOption,"faıled");

        BrowserUtils.waitFor(2);
        select.selectByValue("6");
        BrowserUtils.waitFor(2);
        select.selectByIndex(4);
        BrowserUtils.waitFor(2);
        select.selectByVisibleText("Magenta");
        BrowserUtils.waitFor(2);

        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());

    }
}
