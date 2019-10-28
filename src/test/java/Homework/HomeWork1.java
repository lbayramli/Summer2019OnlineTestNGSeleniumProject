package Homework;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserUtils;
//PRINT TITLE and URL


public class HomeWork1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://qa2.vytrack.com/user/login");
        BrowserUtils.wait(2);
        WebElement input=driver.findElement(By.name("_username"));
        input.sendKeys("user171");
        WebElement passw=driver.findElement(By.name("_password"));
        passw.sendKeys("UserUser123");
        WebElement button=driver.findElement(By.id("_submit"));
        button.click();
        driver.close();
    }
}
