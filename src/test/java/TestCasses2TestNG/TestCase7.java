package TestCasses2TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestCase7 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }


        @Test
        public void Testcase7(){
            driver.findElement(By.linkText("File Upload")).click();
          WebElement upload= driver.findElement(By.id("file-upload"));
          upload.sendKeys("/Users/leylabayramli/Desktop/resume.txt");
          driver.findElement(By.cssSelector("input[value='Upload']")).click();

          String expected="File Uploaded!";
          String actual=driver.findElement(By.xpath("//h3[.='File Uploaded!']")).getText();
           Assert.assertEquals(expected,actual,"Invalid");

        }


    @Test
    public void TestCase8() {
        driver.findElement(By.linkText("Autocomplete")).click();
      driver.findElement(By.xpath("//input[@name='myCountry']")).sendKeys("United States of America");
       driver.findElement(By.cssSelector("input[value='Submit']")).click();

        String expected = "You selected: United States of America";
        String actual = driver.findElement(By.xpath("//p[text()='You selected: United States of America']")).getText();
        Assert.assertEquals(expected,actual, "Invalid");

    }

}
