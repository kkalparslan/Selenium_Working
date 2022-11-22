package com.tests.day13_jsexecutor_webTables;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.utilities.WebDriverFactory;

public class JSWorking {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void typeWithJS() throws InterruptedException {
        driver.get("https://selectorshub.com/xpath-practice-page/");
        WebElement firstName=driver.findElement(By.xpath("//input[@class='nameFld'][1]"));
        WebElement surName=driver.findElement(By.xpath("//input[@class='nameFld'][2]"));
//        String name="Alparslan"; // kod bloğuna isim vb bilgileri kendimizde girebiliriz..
//        String surname="Ozturk";
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('value', 'Alparslan')", firstName);
        Thread.sleep(1000);
        jse.executeScript("arguments[0].setAttribute('value', 'Öztürk')", surName);
        Thread.sleep(1000);

    }
    @Test
    public void scroll() throws InterruptedException {
        driver.get("https://www.krafttechnologie.com/");
        JavascriptExecutor js= (JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,3000);");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-3000);");
        Thread.sleep(2000);

    }
}
