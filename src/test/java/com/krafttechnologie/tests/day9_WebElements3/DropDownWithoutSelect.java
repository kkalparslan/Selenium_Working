package com.krafttechnologie.tests.day9_WebElements3;

import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownWithoutSelect {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void dropDownWithoutSelectTest() {
        driver.get("https://demoqa.com/select-menu");
        WebElement dropdownmenu = driver.findElement(By.xpath("(//div[@class=' css-1wa3eu0-placeholder'])[1]"));
        System.out.println("dropdownmenu.getText() = " + dropdownmenu.getText());

        Assert.assertEquals(dropdownmenu.getText(), "Select Option", "failed");
        dropdownmenu.click();
        BrowserUtils.waitFor(3);

        WebElement group2Option1 = driver.findElement(By.id("react-select-2-option-1-0"));
        group2Option1.click();
        BrowserUtils.waitFor(2);
        WebElement getTextElment = driver.findElement(By.xpath("//div[@class=' css-1uccc91-singleValue']"));
        System.out.println("getTextElment.getText() = " + getTextElment.getText());

        Assert.assertEquals(getTextElment.getText(), "Group 2, option 1", "failed");

    }

    /**
    1. go to http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
    2. DropDowns Menusunden SQL,TestNG ve CSS seceneklerini seç
     */
    @Test
    public void dropdownTest1(){
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        WebElement dropdownmenu1 = driver.findElement(By.id("dropdowm-menu-1"));
        dropdownmenu1.click();
        Select select=new Select(dropdownmenu1);
        select.selectByVisibleText("SQL");
        BrowserUtils.waitFor(2);
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());

        WebElement dropdownmenu2=driver.findElement(By.id("dropdowm-menu-2"));
        dropdownmenu2.click();
        Select select1=new Select(dropdownmenu2);
        select1.selectByValue("testng");
        BrowserUtils.waitFor(2);
        System.out.println("select1.getFirstSelectedOption().getText() = " + select1.getFirstSelectedOption().getText());

        WebElement dropdownmenu3= driver.findElement(By.id("dropdowm-menu-3"));
        dropdownmenu3.click();
        Select select2=new Select(dropdownmenu3);
        select2.selectByIndex(1);
        BrowserUtils.waitFor(2);
        System.out.println("select2.getFirstSelectedOption().getText() = " + select2.getFirstSelectedOption().getText());


    }
}
