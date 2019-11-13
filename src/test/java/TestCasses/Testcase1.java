package TestCasses;

/*
Step 1. Go to https://practice-cybertekschool.herokuapp.comStep
2. Click on “Sign Up For Mailing List”Step
3. Enter any valid nameStep
 4. Enter any valid emailStep 5. Click on “Sign Up” button
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class Testcase1 {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement signU= driver.findElement(By.xpath("//a[@href='/sign_up']"));
        signU.click();
        WebElement input= driver.findElement(By.name("full_name"));
        input.sendKeys("leyla");
        WebElement passw=driver.findElement(By.name("email"));
        passw.sendKeys("lbayramli92@gmail.com");
        WebElement button=driver.findElement(By.name("wooden_spoon"));
        button.click();

        WebElement message= driver.findElement(By.name("signup_message"));
        System.out.println(message.getText());
        String actualRes="“Thank you for signing up. Click the button below to return to the home page.";
        String expectRes=message.getText();
        if(actualRes.contains(expectRes)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

// //TAGNAME [@Attribute name='value']
        driver.close();

    }
}
