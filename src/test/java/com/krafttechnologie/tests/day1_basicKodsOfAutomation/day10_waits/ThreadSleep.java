package com.krafttechnologie.tests.day1_basicKodsOfAutomation.day10_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.krafttechnologie.utilities.WebDriverFactory;

public class ThreadSleep {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("Chrome");
        //driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start>button")).click();
        Thread.sleep(5000); // thread koymayınca protest i beklemeden çıktığından texti alamıyor..
        System.out.println("driver.findElement(By.xpath(\"//h4[.='Hello World!']\")).getText() = " +
                "" + driver.findElement(By.xpath("//h4[.='Hello World!']")).getText());

    }
}
