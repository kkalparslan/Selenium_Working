package com.tests.day1_basicKodsOfAutomation.day10_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class ExplicitlyWait {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // test case kodlarının arası yerine
        //buraya koyarsak ihtiyaç duyulan tüm findElement için çalışacak
        //driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start>button")).click();
        WebDriverWait wait=new WebDriverWait(driver,15);
        WebElement hello = driver.findElement(By.cssSelector("#finish>h4"));
        wait.until(ExpectedConditions.visibilityOf(hello));
        System.out.println("getText() = " + driver.findElement(By.xpath("//h4[text()='Hello World!']")).getText());

    }

    @Test
    public void test2(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        WebDriverWait wait=new WebDriverWait(driver,15);
        WebElement message = driver.findElement(By.xpath("//input[@type='text']"));
        wait.until(ExpectedConditions.elementToBeClickable(message));
        message.sendKeys("I am so tired today for working hard");
    }
}
