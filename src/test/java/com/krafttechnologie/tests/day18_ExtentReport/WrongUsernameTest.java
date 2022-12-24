package com.krafttechnologie.tests.day18_ExtentReport;

import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongUsernameTest extends TestBase {

    @Test
    public void wrongUsername(){
        LoginPage loginPage =new LoginPage();

        extentLogger=report.createTest("Wrong Username Test");
        //BrowserUtils.waitFor(1);
        extentLogger.info("Enter wrong username");
        loginPage.userEmailInput_loc.sendKeys("some userEmail");
        extentLogger.info("Enter correct password");
        loginPage.passwordInput_loc.sendKeys(ConfigurationReader.get("password"));
        extentLogger.info("Click login button");
        loginPage.submitButton_loc.click();
        String actualMessage= loginPage.warningMessage_loc.getText();
        extentLogger.info("Verify that Not log in");
        //Assert.assertEquals(actualMessage, "Email address or password incorrect. Please check");
        Assert.assertEquals(actualMessage, "Email address or password is incorrect. Please check");
        extentLogger.pass("PASSED");

    }

    @Test
    public void wrongPassword(){
        LoginPage loginPage =new LoginPage();

        extentLogger=report.createTest("Wrong Password Test");
        //BrowserUtils.waitFor(1);
        extentLogger.info("Enter correct userEmail");
        loginPage.userEmailInput_loc.sendKeys(ConfigurationReader.get("userEmail"));
        extentLogger.info("Enter wrong password");
        loginPage.passwordInput_loc.sendKeys("some password");
        extentLogger.info("Click login button");
        loginPage.submitButton_loc.click();
        String actualMessage= loginPage.warningMessage_loc.getText();
        extentLogger.info("Verify that Not log in");
        //Assert.assertEquals(actualMessage, "Email address or password incorrect. Please check");
        Assert.assertEquals(actualMessage, "Email address or password is incorrect. Please check");
        extentLogger.pass("PASSED");


    }


}
