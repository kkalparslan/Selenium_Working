package com.tests.day15_POM;

import com.pages.LoginPages;
import com.tests.TestBase;
import com.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPassword () {

        LoginPages loginPages = new LoginPages();
        driver.get(ConfigurationReader.get("url"));

        loginPages.userEmailInput_loc.sendKeys(ConfigurationReader.get("userEmail"));
        loginPages.passwordInput_loc.sendKeys("some password");
        loginPages.submitButton_loc.click();

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
            LoginPages loginPages=new LoginPages();
            driver.get(ConfigurationReader.get("url"));

            loginPages.userEmailInput_loc.sendKeys("alparslan");
            loginPages.passwordInput_loc.sendKeys(ConfigurationReader.get("password"));
            loginPages.submitButton_loc.click();


            String actualMessage=loginPages.warningMessage_loc.getText();
            String expectedMessage="Email address or password is incorrect. Please check";

            Assert.assertEquals(actualMessage, expectedMessage,"FAIL");
        }

    }

