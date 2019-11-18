package TestCasses2TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase1 {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
    }

@AfterMethod
    public void teardown(){
        driver.close();
    }

    @Test (description = "Verify that warning message is displayed:")
    public void verifywarningmessage(){
        driver.findElement(By.xpath("//*[@href='/registration_form']")).click();
        WebElement dob=driver.findElement(By.name("birthday"));
        dob.sendKeys("“wrong_dob");
        String expectedResult="The date of birth is not valid";
        String actualResult=driver.findElement(By.xpath("//small[@data-bv-validator='date']")).getText();
        Assert.assertEquals(expectedResult,actualResult,"Invalid result");
    }

@Test (description = "Verify that following options for programming languages are displayed: c++, java, JavaScript")
    public void verifylanguages(){
        driver.findElement(By.xpath("//a[@*='/registration_form']")).click();
       WebElement Cplus=driver.findElement(By.xpath("//label[@for='inlineCheckbox1']"));
       WebElement java=driver.findElement(By.xpath("//label[@for='inlineCheckbox2']"));
       WebElement script=driver.findElement(By.xpath("//label[@for='inlineCheckbox3']"));

    Assert.assertTrue(Cplus.isDisplayed(),"It is not dispalyed");
    Assert.assertTrue(java.isDisplayed(),"It is not dispalyed");
    Assert.assertTrue(script.isDisplayed(),"It is not dispalyed");
    }

@Test
    public void verifyTest3(){
        driver.findElement(By.xpath("//a[@*='/registration_form']")).click();
      WebElement firstname=  driver.findElement(By.name("firstname"));
      firstname.sendKeys("L");
    String ExpectedResult="first name must be more than 2 and less than 64 characters long";
       String Actualresult=driver.findElement(By.xpath("//small[.='first name must be more than 2 and less than 64 characters long']")).getText();
       Assert.assertEquals(Actualresult,ExpectedResult,"Invalid result");

    }
//
    @Test
    public void Test4(){
        driver.findElement(By.xpath("//a[@*='/registration_form']")).click();
       WebElement lastname= driver.findElement(By.name("lastname"));
       lastname.sendKeys("L");
        String ExpectedResult="The last name must be more than 2 and less than 64 characters long";
        String Actualresult=driver.findElement(By.xpath("//small[.='The last name must be more than 2 and less than 64 characters long']")).getText();
        Assert.assertEquals(Actualresult,ExpectedResult, "Invalid result");
    }

    @Test
public void Test5(){
        driver.findElement(By.xpath("//*[@href='/registration_form']")).click();
        driver.findElement(By.name("firstname")).sendKeys("Lily");
        driver.findElement(By.name("lastname")).sendKeys("Bay");
        driver.findElement(By.name("username")).sendKeys("lbayramli");
        driver.findElement(By.name("email")).sendKeys("lbayramli92@gmail.com");
        driver.findElement(By.name("password")).sendKeys("1234abcde");
        driver.findElement(By.name("phone")).sendKeys("949-558-6871");
        driver.findElement(By.cssSelector("input[value='female']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("10/10/1990");
        driver.findElement(By.cssSelector("[id='inlineCheckbox2']")).click();
        Select jobTitle = new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
        jobTitle.selectByVisibleText("SDET");
        Select department = new Select(driver.findElement(By.cssSelector("[name='department']")));
        department.selectByVisibleText("Accounting Office");
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(3);

        String Expected = "You've successfully completed registration!";
        String Actual = driver.findElement(By.xpath("//p[contains(text(),'You')]")).getText();
        WebElement message =driver.findElement(By.xpath("//p[contains(text(),'You')]"));
        Assert.assertTrue(message.isDisplayed(),"It is not displayed");
        Assert.assertEquals(Actual,Expected, "Invalid Result");


    }
}
/*
  driver.findElement(By.name("firstname")).sendKeys("Leyla");
   driver.findElement(By.name("lastname")).sendKeys("Bay");
    driver.findElement(By.name("username")).sendKeys("lbayramli");
    driver.findElement(By.name("password")).sendKeys("abcd1234");
driver.findElement(By.xpath("//input[@placeholder ='571-000-0000']")).sendKeys("949-558-6871");
        driver.findElement(By.cssSelector("input[value='male']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("03/25/1990");
        driver.findElement(By.cssSelector("[id='inlineCheckbox2']")).click();
    Select select=new Select(driver.findElement(By.cssSelector("select[name='department']")));
        select.selectByVisibleText("Accounting Office");
    Select select1=new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
     select1.selectByVisibleText("SDET");

   driver.findElement(By.xpath("//button[@id='wooden_spoon']")).click();
       String Expect= "You've successfully completed registration!";
        String Actual = driver.findElement(By.xpath("//p[contains(text(),'You')]")).getText();
        WebElement message =driver.findElement(By.xpath("//p[contains(text(),'You')]"));
        Assert.assertTrue(message.isDisplayed(),"Message is not displayed");
       // Assert.assertEquals(Actual,Expect, "NOT DISPLAYED");
 */
