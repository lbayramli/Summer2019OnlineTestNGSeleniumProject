package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestForClassNameLocater {
    public static void main(String[] args) {

        WebDriver driver= BrowserFactory.getDriver("chrome");
        //h1 h2 h3 is tags. H1 is the biggest
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
//h3 class="h3" Multple buttons <h3>
        //h3- it a class nme or avlue of class attribute
        //if class has text with a space that means it is two classes such as "h4 el" it has two classes
        WebElement heading=driver.findElement(By.className("h3"));
        //we can read the text of attributes
        System.out.println(heading.getText());
    }
}
