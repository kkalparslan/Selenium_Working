package com.krafttechnologie.tests.day1_basicKodsOfAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson_2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.google.com/");
        Thread.sleep(2000);

        WebElement element=driver.findElement(By.cssSelector(".gLFyf.gsfi"));
        element.click();
        element.sendKeys("my little pony");
        Thread.sleep(2000);
        driver.close();



    }
}
