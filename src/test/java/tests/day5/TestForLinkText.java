package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestForLinkText {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");
        //automcomplete is a text that we see in the link
        //place where it will navigate you specifed in href
        // It works only if the tagname is<a>
        //if you want to use  linkText or partialLinkText  locater element must start with <a>
        driver.findElement(By.linkText("Autocomplete")).click();

        BrowserUtils.wait(3);


        driver.quit();
    }
}