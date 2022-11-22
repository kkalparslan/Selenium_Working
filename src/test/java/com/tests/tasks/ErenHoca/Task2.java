package com.tests.tasks.ErenHoca;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Task2 {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        /**
         * TC-2
         *
         * 1. "https://www.krafttechexlab.com/" sitesine git.
         * 2. 'Forms' altındaki Checkbox butonunun displayed olmadığını doğrula.
         * 3. Forms'a tıkla.
         * 4. Forms' altındaki Checkbox butonunun displayed olduğunu doğrula.
         * 5. 'Checkbox' butonuna tıkla.
         * 6. İlk butonun select olmadığı doğrula.
         * 7. İlk butonun üzerini tıkla.
         * 8. İlk butonun select olduğunu doğrula.
         * 9. İkinci butonun select olduğunu doğrula.
         * 10. Üçüncü butonun disable (enable olmadığını) doğrula.
         * 11. Dördüncü butonun display olduğunu doğrula.
         */

        driver.get("https://www.krafttechexlab.com/");
        WebElement checkBox1 = driver.findElement(By.xpath("(//i[@class='bi bi-circle'])[14]"));
        System.out.println("checkBox.isDisplayed() = " + checkBox1.isDisplayed());
        Assert.assertFalse(checkBox1.isDisplayed(), "FAIL");
        driver.findElement(By.xpath("(//i[@class='bi bi-chevron-down ms-auto'])[2]")).click();
        Thread.sleep(1000);
        System.out.println("checkBox1.isDisplayed() = " + checkBox1.isDisplayed());
        Assert.assertTrue(checkBox1.isDisplayed(), "FAIL");
        WebElement checkBox2 = driver.findElement(By.xpath("(//i[@class='bi bi-circle'])[14]"));
        checkBox2.click();
        Thread.sleep(1000);
        WebElement firstButton = driver.findElement(By.cssSelector("#gridCheck1"));
        System.out.println("firstButton.isSelected() = " + firstButton.isSelected());
        Assert.assertFalse(firstButton.isSelected(), "FAIL");
        firstButton.click();
        Thread.sleep(1000);
        Assert.assertTrue(firstButton.isSelected(), "FAIL");
        WebElement secondButton = driver.findElement(By.cssSelector("#gridCheck2"));
        System.out.println("secondButton.isSelected() = " + secondButton.isSelected());
        Assert.assertTrue(secondButton.isSelected(), "FAIL");
        WebElement thirdButton = driver.findElement(By.cssSelector("#gridCheck3"));
        System.out.println("thirdButton.isEnabled() = " + thirdButton.isEnabled());
        Assert.assertFalse(thirdButton.isEnabled(), "FAIL");
        WebElement forthButton = driver.findElement(By.cssSelector("#gridCheck4"));
        System.out.println("forthButton.isDisplayed() = " + forthButton.isDisplayed());
        Assert.assertTrue(forthButton.isDisplayed());
        /**
         * checkBox.isDisplayed() = false
         * checkBox1.isDisplayed() = true
         * firstButton.isSelected() = false
         * secondButton.isSelected() = true
         * thirdButton.isEnabled() = false
         * forthButton.isDisplayed() = true
         */


    }
}
