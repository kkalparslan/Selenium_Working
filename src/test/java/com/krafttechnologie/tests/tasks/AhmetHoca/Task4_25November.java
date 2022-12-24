package com.krafttechnologie.tests.tasks.AhmetHoca;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.pages.ProfilePage;
import com.krafttechnologie.tests.TestBase;
import org.testng.annotations.Test;

public class Task4_25November extends TestBase {
    /**
     * HW:
     * https://www.krafttechexlab.com/login Links to an external site.sayfasina git
     * My Profile sayfasini ac
     * Add Education modulunde istenen bilgileri gir
     * Add Education buttona click yap
     * Dashboard page git
     * Guncelledigin userin profiline gitmek icin View Profile sekmesini ac
     * Acilan sayfada
     * Full Name
     * Job
     * Company isimlerini verify yap
     */

    @Test
    public void test1(){
        LoginPage loginPage =new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();
        ProfilePage profilePage=new ProfilePage();

        extentLogger=report.createTest("Verify Task");

        extentLogger.info("https://www.krafttechexlab.com/login Links to an external site.sayfasina git");
        loginPage.loginUser();

        extentLogger.info("My Profile sayfasini ac");
        dashboardPage.myProfile_loc.click();
        //BrowserUtils.waitFor(3);

        extentLogger.info("Add Education buttona click yap");
        profilePage.profileTabs("Add Education");
        //        extentLogger.info("Add Education modulunde istenen bilgileri gir");
//        //driver.findElement(By.xpath("(//li[@class='nav-item'])[9]")).click();
//
//        profilePage.addEducationBtn_loc.click();
//       // BrowserUtils.waitFor(3);

        profilePage.EducationModules("school", "Kraftech Batch 2");
        profilePage.EducationModules("degree", "high level");
        profilePage.EducationModules("study", "QA");
        //profilePage.EducationModules("fromdate", "25.07.2022");
        profilePage.fromDate_loc.clear();
        profilePage.fromDate_loc.sendKeys("25.07.2022");
        profilePage.EducationModules("currentedu", "null");
        profilePage.EducationModules("todateedu", "25.02.2023");
        //profilePage.EducationModules("description", "QA ENGINEER");
        //driver.findElement(By.xpath("(//textarea[@id='description'])[2]")).sendKeys("bla bla");
        profilePage.programDescription_loc.sendKeys("QA ENGINEER");

    }

}
