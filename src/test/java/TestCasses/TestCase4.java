package TestCasses;

/*
Step 1. Go to https://practice-cybertekschool.herokuapp.comStep
2. Click on “Registration Form”Step
3. Enter “123” into first name input box.Step
4. Verify that warning message is displayed: “first name can only consist of alphabetical letters”
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase4 {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement register= driver.findElement(By.xpath("//a[@*='/registration_form']"));
        register.click();
        WebElement name=driver.findElement(By.xpath("//input[@*='form-control']"));
        name.sendKeys("123");

        WebElement result=driver.findElement(By.xpath("//small[@*='help-block']"));
        System.out.println(result.getText());
        String actualResult="first name can only consist of alphabetical letters";
        String expectedResult=result.getText();

        if(actualResult.contains(expectedResult)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        driver.close();
    }
}
