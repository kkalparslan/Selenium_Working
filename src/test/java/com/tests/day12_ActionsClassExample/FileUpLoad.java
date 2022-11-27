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
    public void uploadFile1() throws InterruptedException {

        //choose file elementini locate ediyoruz
        //sonrasinda sendKeys(file path)
        //File Path:
        //Windows icin: shift tusu+ dosya uzerinde sag click yapip Copy asPath seciyoruz
        //Mac icin: sag click+ option key+ Copy.....as PAthName (yol Adi olarak kopyala)

        driver.get("https://demoqa.com/upload-download");
        WebElement chooseFile = driver.findElement(By.cssSelector("#uploadFile"));
        chooseFile.sendKeys("C:\\Users\\Asus\\Desktop\\canvas url.docx");
                                         //C:\fakepath\canvas url.docx
        WebElement testmsj=driver.findElement(By.id("uploadedFilePath"));
        System.out.println("filemsj = " + testmsj.getText());
        String expected="canvas url.docx";
        String actual=testmsj.getText();
        System.out.println("actual = " + actual);
        Assert.assertTrue(actual.contains(expected));

    }

    @Test
    public void uploadFile2(){
        /**
         * test folder üzerinde sağ click Directory sec + resources seç file copy
         * et resources üzerine uzantısı .txt olacak şekilde paste yapılacak.
         * sonra projenin sistemdeki path ini alıyoruz:
         * String projectPath= System.getProperty("user.dir);
         * String FilePath="src/test/resources/canvas url.txt"
         */

        driver.get("https://demoqa.com/upload-download");
        WebElement chooseFile=driver.findElement(By.id("uploadFile"));

        String projectPath= System.getProperty("user.dir");
        String FilePath ="src/test/resources/canvas url.txt";

        String fullPath=projectPath+"/"+FilePath;
        chooseFile.sendKeys(fullPath);

        WebElement testmsj=driver.findElement(By.id("uploadedFilePath"));
        System.out.println("testmsj.getText() = " + testmsj.getText());
        String actual=testmsj.getText();
        String expected="canvas url.txt";
        Assert.assertTrue(actual.contains(expected));

    }


}
