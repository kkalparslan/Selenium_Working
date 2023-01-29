package com.krafttechnologie.tests.general;

import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.*;

import java.util.Set;

import static org.openqa.selenium.Keys.ENTER;

public class MHRS {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
//        driver.get("http://google.com");
//        WebElement searchBox = driver.findElement(By.xpath("//input[@class='gLFyf']"));
//        //searchBox.click();
//        searchBox.sendKeys(("mhrs")+ ENTER);
//        JavascriptExecutor jse= (JavascriptExecutor) driver;
//        jse.executeScript("arguments[0].scrollIntoView(true);"
//                +"arguments[0].click()",searchBox);
        driver.get("https://www.mhrs.gov.tr/");
        driver.manage().window().maximize();
        driver.findElement(By.className("headerRandevual")).click();
        BrowserUtils.waitFor(2);

        String currentTab = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) {
            if(!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        BrowserUtils.waitFor(4);
        //System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        WebElement tc = driver.findElement(By.xpath("//input[@id='LoginForm_username']"));
        tc.click();
        tc.sendKeys("15017265816");
        BrowserUtils.waitFor(2);
        WebElement psword=driver.findElement(By.xpath("//input[@id='LoginForm_password']"));
        psword.click();
        psword.sendKeys("Qw098765");
        WebElement login=driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-teal ant-btn-block']"));
        login.click();
        BrowserUtils.waitFor(3);


        driver.findElement(By.xpath("//button[@class='ant-btn']")).click();
//        Alert alert=driver.switchTo().alert();
//        alert.accept();
        BrowserUtils.waitFor(3);
        driver.findElement(By.xpath("(//div[@class='randevu-turu-grup-article'])[3]")).click();
        BrowserUtils.waitFor(3);
        driver.quit();

    }


}
