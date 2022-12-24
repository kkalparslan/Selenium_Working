package com.krafttechnologie.tests.general;

import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.Driver;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ENTER;

public class BTKAkademi {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
        BrowserUtils.waitFor(2);
    }

    @Test
    public void LoginBTK(){
//        driver.get("https://www.btkakademi.gov.tr/");
//        WebElement girişButton=driver.findElement(By.xpath("//button[@class='PrimaryMedium-sc-6n0thy-0 dUJvTO normal-button']"));
//        girişButton.click();
//        BrowserUtils.waitFor(2);
//        WebElement eDevletButton=driver.findElement(By.xpath("//button[.='E-Devlet ile Giriş Yap ']"));
//        //System.out.println("eDevletButton.isEnabled() = " + eDevletButton.isEnabled());
//        eDevletButton.click();
//        WebElement TCButton=driver.findElement(By.xpath("//input[@name='tridField']"));
//        TCButton.sendKeys("15017265816");
//        WebElement sifreButton=driver.findElement(By.xpath("//input[@id='egpField']"));
//        sifreButton.sendKeys("Ec974125");
//        WebElement girisYapButton=driver.findElement(By.xpath("//input[@class='submitButton']"));
//        girisYapButton.click();


    }




}
