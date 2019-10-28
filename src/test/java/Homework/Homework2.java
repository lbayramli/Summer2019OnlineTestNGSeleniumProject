package Homework;


import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

// Verify Title
public class Homework2 {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://google.com");
        String expectedResult=driver.getTitle();
        String actualResult=driver.getTitle();
        if(actualResult.equals(expectedResult)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
      driver.close();




    }
}
