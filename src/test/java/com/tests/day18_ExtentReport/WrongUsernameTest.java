package com.tests.day18_ExtentReport;

import com.pages.LoginPages;
import com.tests.TestBase;
import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongUsernameTest extends TestBase {

    @Test
    public void wrongUsername(){
        LoginPages loginPages=new LoginPages();

        extentLogger=report.createTest("Wrong Username Test");
        //BrowserUtils.waitFor(1);
        extentLogger.info("Enter wrong username");
        loginPages.userEmailInput_loc.sendKeys("some userEmail");
        extentLogger.info("Enter correct password");
        loginPages.passwordInput_loc.sendKeys(ConfigurationReader.get("password"));
        extentLogger.info("Click login button");
        loginPages.submitButton_loc.click();
        String actualMessage=loginPages.warningMessage_loc.getText();
        extentLogger.info("Verify that Not log in");
        //Assert.assertEquals(actualMessage, "Email address or password incorrect. Please check");
        Assert.assertEquals(actualMessage, "Email address or password is incorrect. Please check");
        extentLogger.pass("PASSED");

    }

    @Test
    public void wrongPassword(){
        LoginPages loginPages=new LoginPages();

        extentLogger=report.createTest("Wrong Password Test");
        //BrowserUtils.waitFor(1);
        extentLogger.info("Enter correct userEmail");
        loginPages.userEmailInput_loc.sendKeys(ConfigurationReader.get("userEmail"));
        extentLogger.info("Enter wrong password");
        loginPages.passwordInput_loc.sendKeys("some password");
        extentLogger.info("Click login button");
        loginPages.submitButton_loc.click();
        String actualMessage=loginPages.warningMessage_loc.getText();
        extentLogger.info("Verify that Not log in");
        //Assert.assertEquals(actualMessage, "Email address or password incorrect. Please check");
        Assert.assertEquals(actualMessage, "Email address or password is incorrect. Please check");
        extentLogger.pass("PASSED");


    }


}
