package com.krafttechnologie.tests.general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.krafttechnologie.utilities.WebDriverFactory;

public class Youtube {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://youtube.com");
        //(//h3[@class='LC20lb MBeuO DKV0Md'])[1]
        WebElement searchbox=driver.findElement(By.xpath("//input[@name='search_query']"));
        searchbox.sendKeys("ferdi tayfur");

    }
}
