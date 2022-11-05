package day2_locators;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class IdLocator {
    public static void main(String[] args) throws InterruptedException {

        Faker faker = new Faker();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");

        driver.manage().window().maximize();

        WebElement inputUserName = driver.findElement(By.id("userName"));
        // inputUserName.sendKeys("AZRA"); indirdiğimiz faker clasından faker isimli bir
        // nesne ürettik ve isim ile mail bilgilerini bu classtan gele faik bilgilerle tamamladık
        inputUserName.sendKeys(faker.name().firstName());

        Thread.sleep(2000);

        WebElement inputEmail = driver.findElement(By.id("userEmail"));
        // inputEmail.sendKeys("azra@gmail.com");
        inputEmail.sendKeys(faker.internet().emailAddress());
        Thread.sleep(2000);

        driver.close();



    }
}
