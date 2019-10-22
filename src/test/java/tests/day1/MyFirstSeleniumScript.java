package tests.day1;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {
        // we have to setup webdriver based on the browser that we gonna use
        WebDriverManager.chromedriver().setup();
        //we need to create an object of appropriate class
        ChromeDriver driver=new ChromeDriver();
        //lets open google.com
        driver.get("http://google.com");
        // to read the page title
        //TEST 1 VERIFY THAT TITLE OF PAGE IS GOOGLE
        String actualResult=driver.getTitle();
        String expectedResult="Google";
        if(actualResult.equals(expectedResult)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test Failed");
        }
        driver.close();
    }
}
