package day4_css;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class Deneme {
    public static void main(String[] args) throws InterruptedException {
        // csswithId
        WebDriver driver= WebDriverFactory.getDriver("chrome");  // CEREN
        driver.get("https://www.google.com");
        Thread.sleep(2000);
        driver.get("https://www.amazon.com/");
        WebElement searchbox=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchbox.sendKeys("my little pony");
        WebElement clickbutton=driver.findElement(By.cssSelector("#nav-search-submit-button"));
        clickbutton.click();
        Thread.sleep(2000);
        driver.quit();

        // csswithclass

//        WebDriver driver= WebDriverFactory.getDriver("chrome"); // AZRA
//        driver.get("https://www.amazon.com/");
//        WebElement searchbox=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
//        searchbox.sendKeys("gezegenler");
//        Thread.sleep(2000);
//        WebElement clickbutton=driver.findElement(By.cssSelector(".nav-search-submit-text.nav-sprite.nav-progressive-attribute"));
//        clickbutton.click();
//        driver.quit();

    }
}
