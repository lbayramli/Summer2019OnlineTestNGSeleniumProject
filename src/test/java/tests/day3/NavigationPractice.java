package tests.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class NavigationPractice {
    public static void main(String[] args) {
        //create a webdriver object o work with a browser
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize(); // to maxmize browser
        driver.get("http://google.com");

        BrowserUtils.wait(3); // wait for 3 sec ths is custom method
        //since the method is static we use class name to call the methos as a parametr ,
        //we provide number of seconds(time in seconds)

        System.out.println(driver.getTitle());

        driver.navigate().to("http://amazon.com");
        //navigate back to google
        driver.navigate().back(); // if we want to back to google
        driver.navigate().forward();// if we want to forward to amaazon
        driver.navigate().refresh(); // to refresh the web page
        driver.quit(); //shutdown browser

        //if we will call driver.get() after quit it wont work
        //if the  tab only one close()  we cannot use driver anymore we need to recreate and object of Webdriver
    }
}
