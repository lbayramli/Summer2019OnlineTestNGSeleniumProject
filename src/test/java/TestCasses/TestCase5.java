package TestCasses;

/*
Step 1. Go to https://practice-cybertekschool.herokuapp.comStep
2. Click on “Registration Form”Step
3. Enter “123” into last name input box.Step
4. Verify that warning message is displayed: “The last name can only consist of alphabetical letters and dash”
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase5 {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement register= driver.findElement(By.xpath("//a[@href='/registration_form']"));
        register.click();

        WebElement lastname=driver.findElement(By.name("lastname"));
        lastname.sendKeys("123");

        WebElement result= driver.findElement(By.xpath("//small[@style='display: block;']"));
        System.out.println(result.getText());

        String actualResult="The last name can only consist of alphabetical letters and dash";
        String expectedResult=result.getText() ;

        if(actualResult.contains(expectedResult)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
driver.close();
    }
}
