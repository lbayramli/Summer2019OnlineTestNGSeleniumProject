package TestCasses;
/*
Step 1. Go to https://practice-cybertekschool.herokuapp.comStep
2. Verify that number of listed examples is equals to 48.Hint: use findElemnts() and size() methods
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCase2 {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
      List<WebElement> numbers= driver.findElements(By.className("list-group-item"));
        System.out.println(numbers.size());

        if(numbers.size()==48){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
driver.close();

    }
}
