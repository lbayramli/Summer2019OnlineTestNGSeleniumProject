package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;


public class WarmUp {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://cybertekschool.com/");
      //HOW to find all links? // every link ad a tah name <a>
      List <WebElement> links=driver.findElements(By.xpath("//a"));
        System.out.println("Number of links "+ links.size());
        //size of the list = number of links
        // findElement vs findElements
        // in case of find element, if there is no element found, you will exception
        //NoSuchElementException
        // findElement = only 1 webelements
        // findElements = 0 or more elements.
        // if list is empty, that means that element is not there
        // in this way, we can ensure that element doesn't present
        // //a[.='Home'] or //a[text()='Home'] - find link with text name Home

        //what is I want to print text all the links by one by

        for( WebElement each:links) {
         //to get rid of the empty spaces
            if (!each.getText().isEmpty()) {
                System.out.println(each.getText());
            }
        }
        driver.quit();
    }
}
