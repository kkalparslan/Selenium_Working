package com.krafttechnologie.tests.day17_POM3;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.pages.ProfilePage;
import com.krafttechnologie.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ProfileTest extends TestBase {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    ProfilePage profilePage=new ProfilePage();

    @Test
    public void editProfile(){

        loginPage.loginUser();
        dashboardPage.myProfile_loc.click();
        profilePage.profileTabs("Edit Profile");

        profilePage.fullName.click();
        profilePage.fullName.sendKeys("Alican");

        profilePage.about.clear();
        profilePage.about.sendKeys("some words are here");

        profilePage.company.clear();
        profilePage.company.sendKeys("KRAFT");

        BrowserUtils.waitForPresenceOfElement(By.cssSelector("#terms"), 3);
        BrowserUtils.dragAndDropBy(profilePage.slider);

        Select select=new Select(profilePage.job);
        select.selectByVisibleText("QA Automation Engineer");

        profilePage.website.clear();
        profilePage.website.sendKeys("https://www.krafttechexlab.com/myprofile");

        profilePage.location.clear();
        profilePage.location.sendKeys("KIRIKKALE");

        profilePage.skills.clear();
        profilePage.skills.sendKeys("TestNG, Cucumber");

        //profilePage.save.click();
        BrowserUtils.clickWithJS(profilePage.save);

    }

    @Test
    public void addExperience(){

        loginPage.loginUser();
        dashboardPage.myProfile_loc.click();
        profilePage.profileTabs("Add Experience");

        profilePage.jobTitle.clear();
        profilePage.jobTitle.sendKeys("QA TESTER");

        profilePage.companyexperience.clear();
        profilePage.companyexperience.sendKeys("KRAFT");

        profilePage.locationExperience.clear();
        profilePage.locationExperience.sendKeys("ANKARA");

        profilePage.startYear.clear();
        profilePage.startYear.sendKeys("10/10/2022");

        profilePage.endYear.clear();
        profilePage.endYear.sendKeys("20/20/2023");

        profilePage.jobDescription.clear();
        profilePage.jobDescription.sendKeys("Cool workplace");

        profilePage.addExperienceBtn.click();
        BrowserUtils.waitFor(5);

    }

}

