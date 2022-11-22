package com.tests.day13_jsexecutor_webTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.utilities.WebDriverFactory;

import java.util.List;

public class WebTables {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void printTable() throws InterruptedException {
        WebElement table=driver.findElement(By.xpath("//table[@class='table " +
                "table-light traversal-table']"));
        System.out.println("table.getText() = " + table.getText());
    }

    @Test
    public void printAllHeaders(){
        WebElement headers=driver.findElement(By.xpath("//table[@class='table " +
                "table-light traversal-table']/thead"));
        System.out.println("heads.getText() = " + headers.getText());
    }

    @Test
    public void printTableSıze(){
        List<WebElement> thSize=driver.findElements(By.xpath("//table[@class='table" +
                " table-light traversal-table']//th"));
        System.out.println("thSize() = " + thSize.size());

        List<WebElement> rwSize=driver.findElements(By.xpath("//table[@class='table " +
                "table-light traversal-table']//tr"));
        System.out.println("rwSize.size() = " + rwSize.size());

        List<WebElement> allRowWithoutHeaders=driver.findElements(By.xpath("//table[@class='table" +
                " table-light traversal-table']//tbody//tr"));
        System.out.println("allRowWithoutHeaders.size() = " + allRowWithoutHeaders.size());
    }

    @Test
    public void getRow() {
        WebElement row2 = driver.findElement(By.xpath("//table[@class='table" +
                " table-light traversal-table']//tbody//tr[2]"));
        System.out.println("heads.getText() = " + row2.getText());
    }

    @Test
    public void getAllRow() {
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@class='table " +
                "table-light traversal-table']//tbody//tr"));
        for (int i = 1; i <= allRows.size(); i++) {
            WebElement row=driver.findElement(By.xpath("//table[@class='table " +
                    "table-light traversal-table']//tbody//tr["+i+"]"));
            System.out.println("row.getText() = " + row.getText());
        }
    }
}
