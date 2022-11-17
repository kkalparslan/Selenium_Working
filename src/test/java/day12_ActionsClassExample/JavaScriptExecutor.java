package day12_ActionsClassExample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.Set;

public class JavaScriptExecutor {
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
    public void clickWithJS() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/floating_menu");
        WebElement link = driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        String titleBeforeClick=driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);
        //WebElement link = driver.findElement(By.linkText("//a[.='Elemental Selenium']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);"
                +"arguments[0].click()", link);
        Thread.sleep(2000);
        String currentTab = driver.getWindowHandle();
        System.out.println("currentTab = " + currentTab);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String tab : windowHandles) { // go and check one by one
            if(!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());

    }
}
