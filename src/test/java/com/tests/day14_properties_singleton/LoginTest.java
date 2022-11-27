package com.tests.day14_properties_singleton;

import com.pages.DashboardPage;
import com.pages.LoginPages;
import com.tests.TestBase;
import com.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
   // WebDriver driver;
    LoginPages loginPages=new LoginPages();
    DashboardPage dashboardPage=new DashboardPage();

    @Test
    public void openBrowserUsingConfigurationReader() {

        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.name("email"))
                .sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.name("password"))
                .sendKeys(ConfigurationReader.get("password")
                        + Keys.ENTER);
        //actions.
        //wait.until(ExpectedConditions.visibilityOf(locator);
    }
    @Test
    public void loginWithMethod(){

        loginPages.loginUser();

        String actualTitle=dashboardPage.dashboardPageTitle("Dashboard");
        System.out.println("actualTitle = " + actualTitle);
        String expectedTitle="Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);

    }
}
