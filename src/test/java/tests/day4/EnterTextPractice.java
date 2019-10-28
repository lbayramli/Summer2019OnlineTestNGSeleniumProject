package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class EnterTextPractice {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        //go to webpag
        WebElement inputBox=driver.findElement(By.name("email"))   ;
        inputBox.sendKeys("random@email.com"); // enter valid email
        WebElement button=driver.findElement(By.id("form_submit"));
        //to click to the element
        button.click();
        String expectedUrl="http://practice.cybertekschool.com/email_sent";
        String actualResult= driver.getCurrentUrl();
        if(expectedUrl.equals(actualResult)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
        BrowserUtils.wait(2);
        driver.close();
    }
}
