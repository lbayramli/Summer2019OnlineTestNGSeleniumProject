package TestCasses;
/*
Step 1. Go to https://practice-cybertekschool.herokuapp.comStep
2. Click on “Registration Form”Step
 3. Enter “user” into username input box.Step
 4. Verify that warning message is displayed: “The username must be more than 6 and less than 30 characters long”
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase6 {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement register=driver.findElement(By.xpath("//a[@href='/registration_form']"));
        register.click();

        WebElement username= driver.findElement(By.name("username"));
        username.sendKeys("user");

        WebElement result= driver.findElement(By.xpath("//small[@style='display: block;']"));
        System.out.println(result.getText());

        String actualResult="The username must be more than 6 and less than 30 characters long";
        String expectedResult=result.getText() ;

        if(actualResult.contains(expectedResult)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }

    }
}
