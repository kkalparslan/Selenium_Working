package com.krafttechnologie.tests.tasks;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DifferentTest {
    // Page Object for the Google search page
    class GooglePage {
        private WebDriver driver;

        public GooglePage(WebDriver driver) {
            this.driver = driver;
        }

        public String search(String searchTerm) {
            WebElement searchInput = driver.findElement(By.name("q"));
            searchInput.sendKeys(searchTerm);
            searchInput.submit();
            return getFirstResultTitle();
        }

        public String getFirstResultTitle() {
            try {
                WebElement element = (new WebDriverWait(driver, 10))
                        .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h3.LC20lb")));
                return element.getText();
            } catch (Exception e) {
                return "No data found";
            }
        }
    }

    // Page Object for the Bing search page
    class BingPage {
        private WebDriver driver;

        public BingPage(WebDriver driver) {
            this.driver = driver;
        }

        public String search(String searchTerm) {
            WebElement searchInput = driver.findElement(By.name("q"));
            searchInput.sendKeys(searchTerm);
            searchInput.submit();
            return getFirstResultTitle();
        }

        public String getFirstResultTitle() {
            try {
                WebElement element = (new WebDriverWait(driver, 10))
                        .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.b_algo h2")));
                return element.getText();
            } catch (Exception e) {
                return "No data found";
            }
        }
    }

    // Page Object for the Yahoo search page
    class YahooPage {
        private WebDriver driver;

        public YahooPage(WebDriver driver) {
            this.driver = driver;
        }

        public String search(String searchTerm) {
            WebElement searchInput = driver.findElement(By.name("p"));
            searchInput.sendKeys(searchTerm);
            searchInput.submit();
            return getFirstResultTitle();
        }

        public String getFirstResultTitle() {
            try {
                WebElement element = (new WebDriverWait(driver, 10))
                        .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.title a")));
                return element.getText();
            } catch (Exception e) {
                return "No data found";
            }
        }
    }


}
