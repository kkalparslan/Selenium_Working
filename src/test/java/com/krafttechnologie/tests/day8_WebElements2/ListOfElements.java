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

import java.util.List;

public class ListOfElements {

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
        driver.get("https://www.krafttechexlab.com/javascript/clicks");
        List<WebElement> clicksmeButtons = driver.findElements(By.xpath("//button[@class='btn btn-primary']"));
        System.out.println("clicksmeButtons.size() = " + clicksmeButtons.size());
        for (WebElement buttons:clicksmeButtons) {
            System.out.println(buttons.getText());
            System.out.println(buttons.isDisplayed());
        }
        Assert.assertEquals(clicksmeButtons.size(),4,"failed");

        clicksmeButtons.get(2).click();
        BrowserUtils.waitFor(5);
    }
}
