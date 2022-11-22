package com.tests.day15_POM;

import com.tests.TestBase;
import com.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPassword () {

        driver.get(ConfigurationReader.get("url"));
        WebElement usernameInput = driver.findElement(By.cssSelector("#email"));
        WebElement passwordInput = driver.findElement(By.cssSelector("#yourPassword"));

        usernameInput.sendKeys(ConfigurationReader.get("username"));
        passwordInput.sendKeys("145");
        driver.findElement(By.cssSelector(".btn.btn-primary.w-100")).click();
        WebElement warningMessage = driver.findElement
                (By.xpath("//div[contains(text(),'Email address or password is incorrect.')]"));

        Assert.assertEquals(warningMessage.getText(), "Email address or password is incorrect. Please check",
                "verify that user is not login");

    }
}
