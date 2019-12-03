package VyTrack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class Login {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        WebElement input = driver.findElement(By.name("_username"));
        input.sendKeys("user171");
        WebElement passw = driver.findElement(By.name("_password"));
        passw.sendKeys("UserUser123");
        WebElement button = driver.findElement(By.id("_submit"));
        button.click();
        String expectedUrl = "https://qa2.vytrack.com/";
        //use getCurrentUrl()==>get the actual URL.
        String actualUrl = driver.getCurrentUrl();
        //use if statement check expected result and actual result is same or not.
        if (expectedUrl.equals(actualUrl)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");

        }
        driver.close();
    }
}
