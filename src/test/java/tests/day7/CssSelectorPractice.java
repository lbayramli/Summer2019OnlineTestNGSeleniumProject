package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class CssSelectorPractice {
//which locater to use:
    //1.ID, 2.CSS,3.Xpath,4.Whatever
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/multiple_buttons");
        //lets find all buttons and click on them by one by
        // why I put . instead of space? because it's 2 class names .btn.btn-primary
        //in this case, we will find all buttons that have: class="btn btn-primary"
        // or like this [class='btn btn-primary'], no need for .
        //. means class name
        //# means id
        List<WebElement> buttons=driver.findElements(By.cssSelector(".btn.btn-primary"));
        //loop through list of buttons
         for(WebElement each:buttons){
          each.click();
         //clik every button one by one
         BrowserUtils.wait(1);
        ////get the message after click
         WebElement message=driver.findElement(By.cssSelector("#result"));
         // //print a text of that message
             System.out.println(message.getText());
}
         //find element with tag name that has a parent element with class name container
         WebElement header=driver.findElement(By.cssSelector(".container > h3"));
        System.out.println(header.getText());

        WebElement p = driver.findElement(By.cssSelector("[class='container'] > p"));
        System.out.println(p.getText());
// . IS USED FOR CLASS NAME IN CSS
driver.close();
    }
}
