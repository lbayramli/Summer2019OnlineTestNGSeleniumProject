package tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
 // if u have exception cant load a class
 //  that means that package name doesnt match with location of class itself
        ChromeDriver driver=new ChromeDriver();
        // to maxmize the browser
        driver.manage().window().maximize();
        driver.get("http://google.com");
        // we open a browser and now we want to navigate dfferem page witin same browser
    //URL can be passed as an object or as a String
        driver.navigate().to("http://amazon.com");
// if I want to come back to the previous page

       driver.navigate().back();
       //if I want to know URL of current website
        String url=driver.getCurrentUrl();
        System.out.println(url);
        //selenim can not close browser automaticly for this we use method close
        driver.close();



    }
}
