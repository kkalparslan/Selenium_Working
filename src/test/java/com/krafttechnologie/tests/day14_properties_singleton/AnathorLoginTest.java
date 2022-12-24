package com.krafttechnologie.tests.day14_properties_singleton;

import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        driver.findElement(By.cssSelector("#email")).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.cssSelector("#yourPassword")).sendKeys(ConfigurationReader.get("password")+ Keys.ENTER);


    }

}
