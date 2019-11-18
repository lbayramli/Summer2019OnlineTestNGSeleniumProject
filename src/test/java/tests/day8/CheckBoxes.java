package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

// command+option +L- TO ORGANIZE CODE
//SHORTCUTS :   driver = BrowserFactory.getDriver("chrome");
//        driver.get("http://practice.cybertekschool.com/");

public class CheckBoxes {
    private WebDriver driver; // private cause it will be used only in this class

    @BeforeMethod
    public void  setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Checkboxes")).click();
    }


@Test
public void Test1(){
//find all checkboxes
    //any checkbox will have [type='checkbox']
   List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type='checkbox']"));
    int index = 1;
    for (WebElement checkbox : checkboxes) {
        if(checkbox.isEnabled() && !checkbox.isSelected()){
            checkbox.click();
            System.out.println("Checkbox clicked: "+index);
            // "Checkbox " index + "clicked;
            //            //
        }else {
            System.out.println("Checkbox was not clicked: "+index);
        } //// "Checkbox " index + " not clicked;
        index++;
    }

}





    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

