package com.krafttechnologie.tests.day1_basicKodsOfAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson_1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
       // driver.close();
        Thread.sleep(2000);

        //driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.quit();


    }
}
