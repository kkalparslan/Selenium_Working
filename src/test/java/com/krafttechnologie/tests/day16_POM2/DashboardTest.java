package com.krafttechnologie.tests.day16_POM2;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends TestBase {

    LoginPage loginPage =new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();


    @Test
    public void novigateToTabAndModule(){

        loginPage.loginUser();
        dashboardPage.navigateToModele("JavaScript", "Autocomplete");

        String actualTitle=dashboardPage.subTitle("Autocomplete");
        System.out.println("actualTitle = " + actualTitle);
        String expectedTitle="Autocomplete";
        System.out.println("expectedTitle = " + expectedTitle);

        Assert.assertEquals(actualTitle, expectedTitle, "FAIL");

    }

    @Test
    public void getUser(){
        loginPage.loginUser();
        dashboardPage.usersNames("Jhon Nash");
        String expectedUser="Jhon Nash";
        System.out.println("expectedName = " + expectedUser);
        String actualUser=dashboardPage.usersNames("Jhon Nash");
        System.out.println("actualName = " + actualUser);

        Assert.assertEquals(actualUser, expectedUser, "FAIL");
    }

    @Test
    public void myProfile() throws InterruptedException {

        loginPage.loginUser();
        dashboardPage.myProfile_loc.click();
        BrowserUtils.waitFor(2);

    }

    @Test
    public void aFmTitle(){

        loginPage.loginUser();

        System.out.println("Title = " + dashboardPage.aFmTitle_loc.getText());

    }

    @Test
    public void copyRight(){

        loginPage.loginUser();
        System.out.println("dashboardPage.copyRight.getText() = " + dashboardPage.copyRight_loc.getText());

    }



}
