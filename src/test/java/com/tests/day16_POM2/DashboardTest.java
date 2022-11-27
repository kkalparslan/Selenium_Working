package com.tests.day16_POM2;

import com.pages.DashboardPage;
import com.pages.LoginPages;
import com.tests.TestBase;
import com.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends TestBase {

    LoginPages loginPages=new LoginPages();
    DashboardPage dashboardPage=new DashboardPage();


    @Test
    public void novigateToTabAndModule(){

        loginPages.loginUser();
        dashboardPage.navigateToModele("JavaScript", "Autocomplete");

        String actualTitle=dashboardPage.subTitle("Autocomplete");
        System.out.println("actualTitle = " + actualTitle);
        String expectedTitle="Autocomplete";
        System.out.println("expectedTitle = " + expectedTitle);

        Assert.assertEquals(actualTitle, expectedTitle, "FAIL");

    }

    @Test
    public void getUser(){
        loginPages.loginUser();
        dashboardPage.usersNames("Jhon Nash");
        String expectedUser="Jhon Nash";
        System.out.println("expectedName = " + expectedUser);
        String actualUser=dashboardPage.usersNames("Jhon Nash");
        System.out.println("actualName = " + actualUser);

        Assert.assertEquals(actualUser, expectedUser, "FAIL");
    }

    @Test
    public void myProfile() throws InterruptedException {

        loginPages.loginUser();
        dashboardPage.myProfile_loc.click();
        BrowserUtils.waitFor(2);

    }

    @Test
    public void aFmTitle(){

        loginPages.loginUser();

        System.out.println("Title = " + dashboardPage.aFmTitle_loc.getText());

    }

    @Test
    public void copyRight(){

        loginPages.loginUser();
        System.out.println("dashboardPage.copyRight.getText() = " + dashboardPage.copyRight_loc.getText());

    }



}
