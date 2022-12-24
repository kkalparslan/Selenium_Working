package com.krafttechnologie.tests.day19_reviewAndXmlRunner;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.ProfilePage;
import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserInfo extends TestBase {
    /** Class Task
     * go to https://www.krafttechexlab.com/login web site // testBase de url hazır olduğu için bu aşamayı atladım
     * Login as a user
     * Verify that login is successful with account name
     * Click on My profile
     * Click on Edit Profile
     * Verify that email value
     * navigate back
     * Verify that Dashboard page with url
     */

    @Test
    public void userInfo(){
        LoginPage loginPage =new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();
        ProfilePage profilePage=new ProfilePage();
        extentLogger=report.createTest("User Info Verification");
        //extentLogger.info("go to https://www.krafttechexlab.com/login web site");
        extentLogger.info("Login as a user");
        loginPage.loginUser();

        String expectedAccountName="Alparslan";
        extentLogger.info("Verify that login is successful and account name is"+expectedAccountName);
//        String actual=driver.findElement(By.xpath("//li[@class='nav-item dropdown pe-3']")).getText();
//        System.out.println("actual = " + actual);
        String actualAccountName= loginPage.getAccountName_mtd(expectedAccountName);
        //String actualAccountName=driver.findElement(By.xpath("//span[.='Alparslan']")).getText();
        System.out.println("actualUser = " + actualAccountName);
        Assert.assertEquals(actualAccountName, expectedAccountName);

        extentLogger.info("Click on My profile");
        dashboardPage.myProfile_loc.click();

        extentLogger.info("Click on Edit Profile");
        profilePage.profileTabs("Edit Profile");

        String expectedEmail="alp@gmail.com";
        extentLogger.info("Verify that email value is"+expectedEmail);
//        String actualEmail=driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value");
//        System.out.println("actualEmail = " + actualEmail);
        Assert.assertEquals(profilePage.profilEmail_loc.getAttribute("value"), expectedEmail);

        extentLogger.info("navigate back");
        driver.navigate().back();

        extentLogger.info("Verify that Dashboard page with url");
        String actualUrl=driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);
        Assert.assertEquals(actualUrl, "https://www.krafttechexlab.com/index");
        extentLogger.pass("PASSED");



    }
}
