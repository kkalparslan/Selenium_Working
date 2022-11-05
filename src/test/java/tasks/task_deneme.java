package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class task_deneme {
    /**
     * tiens ana sayfaya git
     * gıda takviyeleri bölümünü seç
     * search box ta çinko yu arat
     * çıkan sayfanın title nı al
     *
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://m-tr.tiens.com/");

        driver.findElement(By.xpath("//div[text()='Onaylamak']")).click();

        WebElement element=driver.findElement(By.xpath("//input[@placeholder='Lütfen anahtar kelimeleri girin']"));
        element.click();
        Thread.sleep(1000);
        element.sendKeys("kitosan");
        WebElement searchbtton=driver.findElement(By.cssSelector(".icon.iconfont.tiens-search"));
        searchbtton.click();


    }


}
