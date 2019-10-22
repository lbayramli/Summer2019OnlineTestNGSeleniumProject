package tests.day3;


import org.openqa.selenium.WebDriver;

import utils.BrowserFactory;

public class BrowserFactoryTest {


    public static void main(String[] args) {
        //now we can get Webdriver method like below
        // getDriver() methd will return webdriver object
        //and we can use reference variable to work with that object
        WebDriver driver= BrowserFactory.getDriver("chrome");
// how we can print  a source code of the page?
        driver.get("http://practice.cybertekschool.com");
        // how we can print  a source code of the page?
        System.out.println(driver.getPageSource());
        driver.quit();
    }

}
