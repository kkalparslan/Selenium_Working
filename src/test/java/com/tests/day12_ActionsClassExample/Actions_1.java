package com.tests.day12_ActionsClassExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.utilities.WebDriverFactory;

public class Actions_1 {
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
        // Action class ileri düzey etkileşimler sunar
        // doubleclick, drogganddropp, hover, rightclick ... vb
        // Action class seleniumdan gelri. webdriver constructor gibi parametre olarak atanır.
        // çünkü driveri browserla etkileşime geçebilmesi için..
        // perform ----> action ı tamamlamak için kullanılır.

        driver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement ciftclick = driver.findElement(By.id("double-click"));
        Actions actions=new Actions(driver);
        actions.doubleClick(ciftclick).perform();
        Thread.sleep(2000);
    }
    @Test
    public void dragAndDrop(){
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement drag=driver.findElement(By.id("draggable"));
        WebElement dropp=driver.findElement(By.id("droppable"));
        Actions actions=new Actions(driver);
        //actions.dragAndDrop(drag,dropp).perform();
        actions.moveToElement(drag).clickAndHold().moveToElement(dropp).release().perform();

    }
    @Test
    public void dragAndDrog2(){
        /**
     go to  https://www.krafttechexlab.com/javascript/droppable
     Drag Me to my target elementini Drop here elementinin uzerine surukle birak
     */

        driver.get("https://www.krafttechexlab.com/javascript/droppable");
        WebElement dragme = driver.findElement(By.cssSelector(".ui-widget-content.ui-draggable.ui-draggable-handle"));
        WebElement dropme=driver.findElement(By.cssSelector(".ui-widget-header.ui-droppable"));
        System.out.println("dropme.getText() = " + dropme.getText());
        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragme, dropme).perform();
        System.out.println("dropme.getText() = " + dropme.getText());
        String expected="Dropped!";
        Assert.assertEquals(dropme.getText(), expected, "FAIL");

    }
    @Test
    public void hover() throws InterruptedException {
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement element=driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        WebElement linkme=driver.findElement(By.xpath("(//a[.='Link 1'])[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(2000);
        Assert.assertTrue(linkme.isDisplayed());
        linkme.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        System.out.println("alert.getText() = " + alert.getText());
        String expected="Well done you clicked on the link!";
        Assert.assertEquals(alert.getText(), expected, "FAIL");
        alert.accept();
        Thread.sleep(2000);

    }






















}
