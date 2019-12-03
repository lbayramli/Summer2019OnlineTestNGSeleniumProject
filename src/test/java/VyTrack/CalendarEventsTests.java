package VyTrack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.concurrent.TimeUnit;

public class CalendarEventsTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        //explicit wait
        wait = new WebDriverWait(driver, 10);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

        WebElement loaderMask = null;

        if (driver.findElements(By.cssSelector("div[class='loader-mask shown']")).size() > 0) {
            loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        }

        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
        activitiesElement.click();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();

        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }


    @Test
    public void Testcase1() {
        String expect = "Options";
        String actual = driver.findElement(By.cssSelector("div[class='btn btn-link dropdown-toggle']")).getText();
        Assert.assertEquals(actual, expect, "It is wrong");
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='btn btn-link dropdown-toggle']")).isDisplayed());
    }


    @Test
    public void Testcase2() {
        String expect = "1";
        String actual = driver.findElement(By.cssSelector("input[value='1']")).getAttribute("value");
        //  Assert.assertTrue(driver.findElement(By.cssSelector("input[value='1']")).isDisplayed());
        Assert.assertEquals(actual, expect, "It is not equal");
    }

    @Test
    public void TestCase3() {
        String expect = "25";
        String actual = driver.findElement(By.xpath("//button[@class='btn dropdown-toggle ']")).getText();
        Assert.assertEquals(actual, expect, "It is not equal");

    }

    @Test
    public void TestCase4() {
        String records = driver.findElement(By.xpath("//label[contains(text(),'21')]")).getText();
        int Actualrecords = driver.findElements(By.cssSelector("tr[class='grid-row row-click-action']")).size();
        Assert.assertTrue(records.contains(Actualrecords + ""));
    }

    @Test
    public void TestCase5() {
        int Actualnumb = driver.findElements(By.cssSelector("tr[class='grid-row row-click-action']")).size();
        driver.findElement(By.cssSelector("[class='btn btn-default btn-small dropdown-toggle']>input")).click();
        int rownumb = driver.findElements(By.cssSelector("[class='grid-row row-click-action row-selected']")).size();

        Assert.assertEquals(rownumb, Actualnumb);
    }






    @AfterMethod
    public void teardown() {
        driver.quit();
    }


}
