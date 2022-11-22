package com.tests.day14_properties_singleton;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.utilities.Driver;

public class SingletonTest {

//    @Test
//    public void test1(){
//     //   Singleton singleton=new Singleton();
//        String driver1=Singleton.getInstance();
//        String driver2=Singleton.getInstance();
//
//        System.out.println("driver1 = " + driver1);
//        System.out.println("driver2 = " + driver2);
//    }
//
//    @Test
//    public void test2() {
//        // WebDriver driver= WebDriverFactory.getDriver("chrome");
//        WebDriver driver = Driver.get();
//        driver.get(ConfigurationReader.get("url"));
//    }

    @Test
    public void test3() throws InterruptedException {
       // WebDriver driver= WebDriverFactory.getDriver("chrome");
        WebDriver driver = Driver.get();
        driver.get("https://demoqa.com/upload-download");
        Thread.sleep(2000);
        //Driver.closeDriver();

    }

    @Test
    public void test4() {
       // WebDriver driver= WebDriverFactory.getDriver("chrome");
        WebDriver driver = Driver.get();
        driver.get("https://webdriveruniversity.com/Actions/index.html");

    }
}
