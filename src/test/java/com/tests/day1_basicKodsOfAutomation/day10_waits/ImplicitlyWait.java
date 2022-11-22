package com.tests.day1_basicKodsOfAutomation.day10_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class ImplicitlyWait {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // test case kodlarının arası yerine
        //buraya koyarsak ihtiyaç duyulan tüm findElement için çalışacak
        //driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test()  {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.cssSelector("#checkbox-example>button")).click();

        WebElement message = driver.findElement(By.xpath("//p[@id='message']"));
        String expected="It's gone!";

        Assert.assertEquals(message.getText(),expected);


    }
}
