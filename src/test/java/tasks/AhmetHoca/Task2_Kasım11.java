package tasks.AhmetHoca;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task2_Kasım11 {

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
        driver.quit();
    }
    @Test
    public void test1() {
        /**
         * 1. https://the-internet.herokuapp.com/dropdown sitesine git
         * Dropdown List den Option 2 yi sectir.
         */
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select selectMenu=new Select(dropdownElement);
        //selectMenu.selectByVisibleText("Option 2");
        String expextedOptions="Option 2";
        System.out.println("expextedOptions = " + expextedOptions);
        //selectMenu.selectByIndex(2);
        selectMenu.selectByValue("2");

        String actualOptıns=selectMenu.getFirstSelectedOption().getText();
        System.out.println("actualOptıns = " + actualOptıns);
        Assert.assertEquals(actualOptıns, expextedOptions, "fail");
    }

    @Test
    public void test2() throws InterruptedException {
        /**
         * 2. https://demoqa.com/checkbox sitesine git
         * Home klasorunu ac.
         * Desktop ve Download klasorlerini check yaptir
         * Check yapildigini da verify yaptir
         */
        driver.get("https://demoqa.com/checkbox");
        driver.findElement(By.cssSelector(".rct-icon.rct-icon-expand-close")).click();
        Thread.sleep(2000);
        List<WebElement> checkedButton = driver.findElements(By.cssSelector(".rct-icon.rct-icon-uncheck"));
        System.out.println("checkedButton.size() = " + checkedButton.size());
        checkedButton.get(1).click();
        Thread.sleep(1000);
        checkedButton.get(3).click();
        Thread.sleep(1000);
//        System.out.println("checkedButton.get(1).isSelected() = " + checkedButton.get(1).isSelected());
//        System.out.println("checkedButton.get(3).isSelected() = " + checkedButton.get(3).isSelected());
        // check yaptır anlaşılmadı test yarım kaldı.......................................
    }

    @Test
    public void test3() throws InterruptedException {
        /**
         * 3. https://www.krafttechexlab.com/forms/radio sitesine git
         * Radio 2 yi sectir.
         */
        driver.get("https://www.krafttechexlab.com/forms/radio");
        driver.findElement(By.cssSelector("#gridRadios2")).click();
        Thread.sleep(2000);
    }

    @Test
    public void test4(){
        /**
         * 4. https://demoqa.com/links sitesine git
         * li tag indeki tum elementlerin size ni aldir ve assert yaptir(expectedSize =32 olacak).
         */
        driver.get("https://demoqa.com/links");
        int expectedSize=32;
        System.out.println("expectedSize = " + expectedSize);
        List<WebElement>elements=driver.findElements(By.tagName("li"));
        System.out.println("elements.size() = " + elements.size());
        int actualSize=elements.size();
        Assert.assertEquals(actualSize,expectedSize,"FAIL");
        /**
         * expectedSize = 32
         * elements.size() = 33
         * java.lang.AssertionError: FAIL
         * Expected :32
         * Actual   :33
         */

    }

}
