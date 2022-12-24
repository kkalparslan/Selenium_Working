package com.krafttechnologie.tests.day15_POM;

import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPassword () {

        LoginPage loginPage = new LoginPage();
        driver.get(ConfigurationReader.get("url"));

        loginPage.userEmailInput_loc.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordInput_loc.sendKeys("some password");
        loginPage.submitButton_loc.click();

//        WebElement usernameInput = driver.findElement(By.cssSelector("#email"));
//        WebElement passwordInput = driver.findElement(By.cssSelector("#yourPassword"));
//
//        usernameInput.sendKeys(ConfigurationReader.get("username"));
//        passwordInput.sendKeys("145");
//        driver.findElement(By.cssSelector(".btn.btn-primary.w-100")).click();
//        WebElement warningMessage = driver.findElement
//                (By.xpath("//div[contains(text(),'Email address or password is incorrect.')]"));
//
//        Assert.assertEquals(warningMessage.getText(), "Email address or password is incorrect. Please check",
//                "verify that user is not login");
    }

        @Test
        public void wrongUsername(){
            LoginPage loginPage =new LoginPage();
            driver.get(ConfigurationReader.get("url"));

            loginPage.userEmailInput_loc.sendKeys("alparslan");
            loginPage.passwordInput_loc.sendKeys(ConfigurationReader.get("password"));
            loginPage.submitButton_loc.click();


            String actualMessage= loginPage.warningMessage_loc.getText();
            String expectedMessage="Email address or password is incorrect. Please check";

            Assert.assertEquals(actualMessage, expectedMessage,"FAIL");
        }

    }

