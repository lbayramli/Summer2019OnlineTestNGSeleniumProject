package TestCasses;
/*
Step 1. Go to https://practice-cybertekschool.herokuapp.comStep
2. Click on “Registration Form”Step
3. Enter “testers@email” into email input box.Step
4. Verify that warning message is displayed: “email address is not a validEmail format is not correct
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase7 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement register=driver.findElement(By.xpath("//a[@href='/registration_form']"));
        register.click();

        WebElement email=driver.findElement(By.name("email"));
        email.sendKeys("testers@email");

        WebElement Messageresult= driver.findElement(By.xpath("//small[@style='display: block;']"));
        WebElement Messageresult2= driver.findElement(By.xpath("//small[.='Email format is not correct']"));
//By.xpath("//small[@style='display: block;']"

        Thread.sleep(3000);
        System.out.println(Messageresult.getText()+"\n"+Messageresult2.getText());

        String actualResult="email address is not a validEmail format is not correct";
         String expectedResult=Messageresult.getText()+Messageresult2.getText();

        if(actualResult.contains(expectedResult)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        driver.close();


    }
}
