package TestCasses;
/*
Step 1. Go to https://practice-cybertekschool.herokuapp.comStep
2. Click on “Registration Form”Step
3. Enter “5711234354” into phone number input box.Step
4. Verify that warning message is displayed: “Phone format is not correct”
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase8 {
    public static void main(String[] args) {

        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement register=driver.findElement(By.xpath("//a[@href='/registration_form']"));
        register.click();

        WebElement phone= driver.findElement(By.name("phone"));
        phone.sendKeys("5711234354");

        WebElement result= driver.findElement(By.xpath("//small[@style='display: block;']"));
        System.out.println(result.getText());

                String actualResult="Phone format is not correct";
        String expectedResult=result.getText();

        if(actualResult.contains(expectedResult)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        driver.close();
    }

}
