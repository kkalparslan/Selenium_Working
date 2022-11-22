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

public class Task1 {
    /**
     * Note: @Test, @BeforeMethod ve @AfterMethod'u muhakkak kullanalım.
     * Note: Bağlantının yavaş olduğu, yükleme sürelerinin uzadığı yerlerde (ideal olmasada-şimdilik) Thread.sleep(...) kullanmayı unutmayalım.
     * Note: Günlük 6 saatin altına düşmeyelim.
     * Note: Duvarlarımızı stickerlarla dolduralım.
     * Note: Rüyalarımızda Java, Collection, OOP, Selenium, Maven, ChromeDriver(), vs. görmeyi unutmayalım.
     */

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
         * 1. "https://www.krafttechexlab.com/" sitesine git.
         * 2. 'Forms' butonuna tıkla.
         * 3. 'Radio butonuna tıkla'.
         * 4. İlk butonun seçili olduğunu doğrula.
         * 5. İlk butonun yanında "Checked Radio 1" yazıyor olduğunu doğrula.
         * 6. İlk butonun displayed olduğunu doğrula.
         * 7. İkinci butonun seçili olmadığını doğrula.
         * 8. İkinci butonun yanında 'Radio 2' yazdığını doğrula.
         * 9. İkinci butonun displayed olduğunu doğrula.
         * 10. Üçüncü butonun seçili olmadığını doğrula.
         * 11. Üçüncaü butonun disable (enable olmadığını) doğrula.
         * 12. Üçüncü butonun display olduğunu doğrula.
         */
        driver.get("https://www.krafttechexlab.com/");
        driver.findElement(By.xpath("(//i[@class='bi bi-chevron-down ms-auto'])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//i[@class='bi bi-circle'])[13]")).click();
        Thread.sleep(1000);
        WebElement checkBox1 = driver.findElement(By.cssSelector("#gridRadios1"));
        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected()); // true
        Assert.assertTrue(checkBox1.isSelected(),"FAIL");
        WebElement label = driver.findElement(By.tagName("label"));
        System.out.println("label.getText() = " + label.getText()); // Checked Radio 1
        System.out.println("checkBox1.isDisplayed() = " + checkBox1.isDisplayed()); // true
        Assert.assertTrue(checkBox1.isDisplayed(),"FAIL");
        WebElement checkBox2 = driver.findElement(By.cssSelector("#gridRadios2"));
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected()); // false
        Assert.assertFalse(checkBox2.isSelected(),"FAIL");
        WebElement label2 = driver.findElement(By.xpath("//label[@for='gridRadios2']"));
        System.out.println("label2.getText() = " + label2.getText());
        System.out.println("checkBox2.isDisplayed() = " + checkBox2.isDisplayed()); // true
        Assert.assertTrue(checkBox2.isDisplayed(), "FAIL");
        WebElement checkBox3 = driver.findElement(By.cssSelector("#gridRadios"));
        System.out.println("checkBox3.isSelected() = " + checkBox3.isSelected()); // false
        Assert.assertFalse(checkBox3.isSelected(), "FAIL");
        System.out.println("checkBox3.isEnabled() = " + checkBox3.isEnabled()); // false
        Assert.assertFalse(checkBox3.isEnabled(), "FAIL");
        System.out.println("checkBox3.isDisplayed() = " + checkBox3.isDisplayed()); // true
        Assert.assertTrue(checkBox3.isDisplayed(), "FAIL");

    }

}
