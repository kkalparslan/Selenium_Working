package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class Task1 {
    /**
     * HW1:
     * 1.	https://www.krafttechexlab.com/Links to an external site. sayfasina git
     * 2.	Components module git
     * 3.	Alert segmesini ac
     * 4.	Acilan sayfadaki Alerts basligini yazdir.
     * HW2:
     * 1.	https://www.hepsiburada.com/Links to an external site. sayfasina git
     * 2.	Search box a Test Automation kelimesini yazdir
     * 3.	Arama butonuna click yaptir
     * 4.	“Test Automation ile ilgili 4 ürün bulduk” yazisini yazdir.
     */

    public static void main(String[] args) throws InterruptedException {
        //***HW1***
//        WebDriver driver= WebDriverFactory.getDriver("chrome");
//        driver.get("https://www.krafttechexlab.com/");
//        WebElement componentbox=driver.findElement(By.xpath("//a[text()='Components']"));
//        componentbox.click();
//
//        System.out.println("driver.getTitle() = " + driver.getTitle());




        //****HW2***
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.hepsiburada.com/");

        WebElement searchbox=driver.findElement(By.className("desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b"));
        searchbox.sendKeys("Test Automation");
        WebElement clickbttn=driver.findElement(By.cssSelector(".SearchBoxOld-cHxjyU99nxdIaAbGyX7F"));
        clickbttn.click();
        Thread.sleep(1000);
        String text=driver.findElement(By.className("searchResultSummaryBar-CbyZhv5896ASVcYBLKmx")).getText();
        System.out.println("text = " + text);


    }
}
