package TestCasses2TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;


public class TestCase6 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.tempmailaddress.com/");
    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }
@Test
    public void TestCase6(){
        String email="mckale.arihan@iiron.us";
    String TempEmail = driver.findElement(By.id("email")).getText();
    driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
    driver.findElement(By.linkText("Sign Up For Mailing List")).click();
    //Sign Up Email
    driver.findElement(By.name("full_name")).sendKeys("Nathan Buttons");
    driver.findElement(By.name("email")).sendKeys(TempEmail);
    driver.findElement(By.name("wooden_spoon")).click();
    //Verify that Sign Up message is displayed
    WebElement SignUpText = driver.findElement(By.name("signup_message"));
    Assert.assertTrue(SignUpText.isDisplayed(), "Sign Up Message is not displayed");

    driver.get("https://www.tempmailaddress.com/");
    //Verify that sign up verification email is received
    WebElement ReceivedEmail = driver.findElement(By.xpath("//td[contains(text(),'do-not-reply@practice.cybertekschool.com')]"));
    String ActualEmail = ReceivedEmail.getText();
    ActualEmail = ActualEmail.trim();
    String ExpectedEmail = "do-not-reply@practice.cybertekschool.com";
    Assert.assertEquals(ActualEmail, ExpectedEmail, "Email is not received");
    ReceivedEmail.click();
    //Verify that Thank you message is displayed in the verification email from Cybertekschool
    String fromEmail = driver.findElement(By.id("odesilatel")).getText();
    String expectedFromEmail = "do-not-reply@practice.cybertekschool.com";
    Assert.assertEquals(fromEmail, expectedFromEmail, "Wrong Sender");
    String ActualSubject = driver.findElement(By.id("predmet")).getText();
    String ExpectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
    Assert.assertEquals(ActualSubject, ExpectedSubject, "Subject line is wrong");
    }


}