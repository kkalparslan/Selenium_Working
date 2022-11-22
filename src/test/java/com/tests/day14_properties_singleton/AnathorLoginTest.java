package com.tests.day14_properties_singleton;

import com.tests.TestBase;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AnathorLoginTest extends TestBase {
    // class task
    // go to url
    // enter username
    // enter password
    // click login button

    @Test
    public void test(){
       // WebDriver driver=Driver.get();
        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.cssSelector("#email")).sendKeys(ConfigurationReader.get("username"));
        driver.findElement(By.cssSelector("#yourPassword")).sendKeys(ConfigurationReader.get("password")+ Keys.ENTER);


    }

}
