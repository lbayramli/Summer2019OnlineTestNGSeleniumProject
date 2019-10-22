package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FindElementsTest {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        //STEP1. Open instructor in chrome and find locater for the elemenet
        //Step 2. Create object of Webelement
        //Step3: Use Webelement
        WebElement button=driver.findElement(By.id("form_submit"));
        //to click to the element
        button.click();
        BrowserUtils.wait(2);
        driver.close();
    }
}
