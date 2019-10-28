package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class ReadAttributesTest {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement input=driver.findElement(By.name("email"));
        //to read value of any attribute
        System.out.println(input.getAttribute("pattern"));
        input.sendKeys("random_email@gmail.com");
        //hw to read the value that entered inputBox
        // It is gonna be isnide value attribute
        System.out.println(input.getAttribute("value"));
        //if button has a type "submit" , we can use .submit method isntead of click as well
        WebElement retrieveButton=driver.findElement(By.id("form_submit"));
        retrieveButton.submit();
        driver.close();
    }
}
