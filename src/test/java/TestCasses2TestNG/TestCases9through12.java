package TestCasses2TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestCases9through12 {
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
    public void Testcase9() {
driver.findElement(By.linkText("Status Codes")).click();

    }


}