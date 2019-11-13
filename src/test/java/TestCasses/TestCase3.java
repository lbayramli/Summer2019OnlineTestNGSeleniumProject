package TestCasses;

/*
Step 1. Go to https://practice-cybertekschool.herokuapp.comStep
2. Click on “Multiple Buttons”Step
 3. Click on “Button 1”Verify that result message is displayed: “Clicked on button one!
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestCase3 {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement multi=driver.findElement(By.xpath("//a[@href='/multiple_buttons']"));
        multi.click();
        WebElement button1=driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button1.click();


        WebElement result= driver.findElement(By.id("result"));
        System.out.println(result.getText());

        String actualResult="Clicked on button one!";
        String expectedResult=result.getText();
        if(actualResult.contains(expectedResult)){
            System.out.println("Test Passes");
        }else{
            System.out.println("Test Failed");
        }
        driver.close();
    }
}
