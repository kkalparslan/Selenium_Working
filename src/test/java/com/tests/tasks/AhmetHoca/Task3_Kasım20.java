package com.tests.tasks.AhmetHoca;

import com.tests.TestBase;
import com.utilities.ConfigurationReader;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class Task3_Kasım20 extends TestBase {
    /**
     * HW 1:
     *
     * Go to https://demoqa.com/automation-practice-form Links to an external site.
     * Formu doldur
     * Submit yap
     * Acilan Thanks for submitting the form tablosundaki bilgileri yazdir.
     * Thanks for submitting the form tablosundaki
     * Gender
     * Hobbies
     * State and City
     * Student Name elementlerinin assertion larine yap
     *
     * sayfayı minimize etmek için deneyelim
     * driver.manage().window().setPosition(new Point(15,15));
     * driver.manage().window().setSize(new Dimension(900,600));
     *  System.out.println("driver.manage().window().getPosition().getX() = " + driver.manage().window().getPosition().getX());
     *  System.out.println("driver.manage().window().getPosition().getY() = " + driver.manage().window().getPosition().getY());
     */



    @Test
    public void test() throws InterruptedException {
//        WebDriver driver=WebDriverFactory.getDriver("chrome");
//        driver.get("https://demoqa.com/automation-practice-form");
        JavascriptExecutor jse= (JavascriptExecutor) driver;



        driver.get(ConfigurationReader.get("url1"));
        driver.manage().window().setPosition(new Point(3,7));
        //driver.manage().window().setSize(new Dimension(1500,1200));
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(ConfigurationReader.get("firstname"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys(ConfigurationReader.get("lastname"));
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
        driver.findElement(By.cssSelector("#userNumber")).sendKeys("252525404040");
//        WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
//        dateOfBirthInput.clear();
//        dateOfBirthInput.sendKeys("10.10.10");
        driver.findElement(By.id("subjectsInput")).sendKeys("working");
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//label[.='Reading']")).click();
        WebElement chooseFile = driver.findElement(By.cssSelector("#uploadPicture"));

        chooseFile.sendKeys("C:\\Users\\Asus\\Desktop\\canvas url.docx");
        driver.findElement(By.id("currentAddress")).sendKeys("Karapürçek");
        WebElement stateButton = driver.findElement(By.xpath(" (//div[@class=' css-tlfecz-indicatorContainer'])[1]"));
        stateButton.click();
        WebElement state = driver.findElement(By.id("react-select-3-option-0"));
        state.click();
        WebElement cityButton = driver.findElement(By.xpath("//div[@class=' css-1wa3eu0-placeholder']"));
        cityButton.click();
        WebElement city = driver.findElement(By.id("react-select-4-option-0"));
        city.click();
        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
        submitButton.click();
        Thread.sleep(2000);
        System.out.println("getText() = " + driver.findElement(By.className("table-responsive")).getText());
        /**
         * getText() = Label Values
         * Student Name Alparslan Öztürk
         * Student Email alp@gmail.com
         * Gender Male
         * Mobile 2525254040
         * Date of Birth 22 November,2022
         * Subjects
         * Hobbies Reading
         * Picture canvas url.docx
         * Address Karapürçek
         * State and City NCR Delhi
         */

        WebElement gender = driver.findElement(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']//tr[3]"));
        System.out.println("gender.getText() = " + gender.getText()); // Gender Male
        WebElement hobies = driver.findElement(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']//tr[7]"));
        System.out.println("hobies.getText() = " + hobies.getText()); // Hobbies Reading
        WebElement stateAndCity = driver.findElement(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']//tr[10]"));
        System.out.println("stateAndCity.getText() = " + stateAndCity.getText()); // State and City NCR Delhi
        WebElement studentName = driver.findElement(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']//tbody//tr[1]"));
        System.out.println("studentName.getText() = " + studentName.getText()); // Student Name Alparslan Öztürk

    }

}
