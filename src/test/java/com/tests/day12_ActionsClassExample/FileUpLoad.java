package com.tests.day12_ActionsClassExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.utilities.WebDriverFactory;

public class FileUpLoad {
    /**
     * https://demoqa.com/upload-download
     */
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
    public void doubleClick() throws InterruptedException {

        driver.get("https://demoqa.com/upload-download");
        WebElement choosebuttn = driver.findElement(By.cssSelector("#uploadFile"));
        choosebuttn.sendKeys("C:\\Users\\Asus\\Desktop\\canvas url.docx");
                                         //C:\fakepath\canvas url.docx
        WebElement filemsj=driver.findElement(By.id("uploadedFilePath"));
        System.out.println("filemsj = " + filemsj.getText());
        String expected="canvas url.docx";
        String actual=filemsj.getText();
        System.out.println("actual = " + actual);
        Assert.assertTrue(actual.contains(expected));

    }
}
