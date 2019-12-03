package VyTrack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCases4 {
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
    public void TestCase1() {
        Actions action = new Actions(driver);
        WebElement dots = driver.findElement(By.xpath("//div//table//tbody//tr[13]//td[9]"));
        action.moveToElement(dots).perform();






    }     

    @Test
    public void TestCase2() {
        WebElement options = driver.findElement(By.xpath("//i[@class='fa-cog hide-text']"));
        options.click();
        for (int i = 2; i <= 7; i++) {
            WebElement checkbox = driver.findElement(By.xpath("//tr[\" + i + \"]//td[3]"));
            checkbox.click();
            Assert.assertFalse(checkbox.isSelected());

        }
    }

    @Test
    public void TestCase3() {
        driver.findElement(By.cssSelector("[title='Create Calendar event']")).click();
        WebElement LoaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(LoaderMask));
        driver.findElement(By.cssSelector("[class='caret']")).click();

        for (int i = 1; i >= 3; i++) {
            WebElement check = driver.findElement(By.xpath("//li[1]//button[@type='submit']"));
            check.click();
            Assert.assertTrue(check.isDisplayed(), "The " + i + " isnt Available");

        }

    }

    @Test
    public void TestCase4() {
        driver.findElement(By.cssSelector("[title='Create Calendar event']")).click();
        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).click();
        WebElement pagesubtitle = driver.findElement(By.cssSelector("[class='oro-subtitle']"));
        Assert.assertTrue(pagesubtitle.isDisplayed(), "Calendar events page isnt displayed");
    }


    @Test
    public void TestCase5() {
        driver.findElement(By.cssSelector("[title='Create Calendar event']")).click();
        WebElement LoaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(LoaderMask));
        WebElement startTime = driver.findElement(By.cssSelector("[class='input-small timepicker-input start ui-timepicker-input']"));
        startTime.click();
        driver.findElement(By.xpath("//li[contains(text(),'10:00 PM')]")).click();
        WebElement endTime = driver.findElement(By.cssSelector("[class='input-small timepicker-input end ui-timepicker-input']"));

        String actualendTime = endTime.getAttribute("value");
        System.out.println(actualendTime);
        String expectedendTime = "11:00 PM";
        Assert.assertTrue(endTime.isDisplayed());
        Assert.assertEquals(actualendTime, expectedendTime, "Difference time is not 1 hour");
    }


    @Test
    public void TestCase6() {
        driver.findElement(By.cssSelector("[title='Create Calendar event']")).click();
        WebElement LoaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(LoaderMask));
        WebElement startTime = driver.findElement(By.cssSelector("[class='input-small timepicker-input start ui-timepicker-input']"));
        startTime.click();
        driver.findElement(By.xpath("//li[contains(text(),'9:00 PM')]")).click();
        driver.findElement(By.cssSelector("[class='input-small timepicker-input end ui-timepicker-input']")).click();
        WebElement endtime = driver.findElement(By.cssSelector("[class='ui-timepicker-pm ui-timepicker-selected']:nth-of-type(3)"));
        String ActualEndTime = endtime.getText();
        String Expectedendime = "10:00 PM";
        Assert.assertEquals(ActualEndTime, Expectedendime);


    }

    @Test
    public void TestCase7() throws InterruptedException {
        driver.findElement(By.cssSelector("[title='Create Calendar event']")).click();
        WebElement LoaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(LoaderMask));
        WebElement alldayevent = driver.findElement(By.cssSelector("[data-name='field__all-day']"));
        alldayevent.click();
        Thread.sleep(4000);
        // Assert.assertTrue(alldayevent.isSelected());
        WebElement startime = driver.findElement(By.cssSelector("[class='input-small timepicker-input start ui-timepicker-input']"));
        Assert.assertFalse(startime.isDisplayed());
        WebElement endtime = driver.findElement(By.cssSelector("[class='input-small timepicker-input end ui-timepicker-input']"));
        Assert.assertFalse(endtime.isDisplayed());
    }

    @Test
    public void TestCase8() {
        driver.findElement(By.cssSelector("[title='Create Calendar event']")).click();
        WebElement LoaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(LoaderMask));
        WebElement repeatbox = driver.findElement(By.cssSelector("[data-name='recurrence-repeat']"));
        repeatbox.click();
        Assert.assertTrue(repeatbox.isSelected());
        WebElement options = driver.findElement(By.cssSelector("[data-name='recurrence-repeats']"));
        Select selectData = new Select(options);
        String Actualresult = selectData.getFirstSelectedOption().getText();
        String Expectedresult = "Daily";
        Assert.assertEquals(Actualresult, Expectedresult);
        List<WebElement> allOptions = driver.findElements(By.cssSelector("[data-name='recurrence-repeat']"));
        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }

    }

    @Test
    public void TestCase9() {

        driver.findElement(By.cssSelector("[title='Create Calendar event']")).click();
        WebElement LoaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(LoaderMask));
        WebElement repeatbox = driver.findElement(By.cssSelector("[data-name='recurrence-repeat']"));
        repeatbox.click();
        Assert.assertTrue(repeatbox.isSelected());
        WebElement repeateverybutton = driver.findElement(By.cssSelector("[checked='checked']"));
        Assert.assertTrue(repeateverybutton.isSelected());
        WebElement endsbutton = driver.findElement(By.cssSelector("[type='radio'][checked='']"));
        Assert.assertTrue(endsbutton.isSelected());
        WebElement summary = driver.findElement(By.xpath("//span[contains(text(),'Daily every ')]"));
        String actualtext = summary.getText();
        String expectedtext = "Daily every 1 day";
        Assert.assertEquals(actualtext, expectedtext);

    }

    @Test
    public void TestCase10() {
        driver.findElement(By.cssSelector("[title='Create Calendar event']")).click();
        WebElement LoaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(LoaderMask));
        WebElement repeatbox = driver.findElement(By.cssSelector("[data-name='recurrence-repeat']"));
        repeatbox.click();
        WebElement afterbox = driver.findElement(By.xpath("//*[contains(text(),'After')]"));
        afterbox.click();
        WebElement occurrencesbox = driver.findElement(By.cssSelector("[data-related-field='occurrences']"));
        occurrencesbox.click();
        occurrencesbox.sendKeys("10");
        occurrencesbox.click();
        WebElement summary = driver.findElement(By.xpath("//span[contains(text(),'Daily every ')]"));
        WebElement summary2 = driver.findElement(By.xpath("//span[contains(text(),'end after ')]"));
        Assert.assertTrue(summary.isDisplayed());
        Assert.assertTrue(summary2.isDisplayed());
    }

    @Test
    public void TestCase11() {
        driver.findElement(By.cssSelector("[title='Create Calendar event']")).click();
        WebElement LoaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(LoaderMask));
        WebElement repeatbox = driver.findElement(By.cssSelector("[data-name='recurrence-repeat']"));
        repeatbox.click();
        WebElement Bybox = driver.findElement(By.xpath("//*[@class='recurrence-subview-control__text'] [contains(text(),'By')]"));
        Bybox.click();
        WebElement datebox = driver.findElement(By.cssSelector("[class='datepicker-input hasDatepicker']"));
        datebox.click();
        datebox.sendKeys("Nov 18, 2021");
        WebElement summary = driver.findElement(By.xpath("//span[contains(text(),'Daily every ')]"));
        WebElement summary2 = driver.findElement(By.xpath("//span[contains(text(),'end by ')]"));
        Assert.assertTrue(summary.isDisplayed());
        Assert.assertTrue(summary2.isDisplayed());
             /*
             WebElement summaryall=driver.findElement(By.cssSelector("[data-name='recurrence-summary']"))  ;
             String Actualsummary = summaryall.getText();
             String Expectedsummary= "Daily every 1 day, end by Nov 18, 2021";
             Assert.assertEquals(Actualsummary,Expectedsummary);
                 */

        //WebElement timebox=driver.findElement(By.cssSelector("[class='timepicker-input ui-timepicker-input']")) ;
        // timebox.sendKeys("")

    }

    @Test
    public void TestCase12() {
        driver.findElement(By.cssSelector("[title='Create Calendar event']")).click();
        WebElement LoaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(LoaderMask));
        WebElement repeatbox = driver.findElement(By.cssSelector("[data-name='recurrence-repeat']"));
        repeatbox.click();
        WebElement options = driver.findElement(By.cssSelector("[data-name='recurrence-repeats']"));
        Select selectData = new Select(options);
        selectData.selectByVisibleText("Weekly");
        WebElement Mondaybox = driver.findElement(By.cssSelector("[type='checkbox'][value='monday']"));
        Mondaybox.click();
        WebElement Fridaybox = driver.findElement(By.cssSelector("[type='checkbox'][value='friday']"));
        Fridaybox.click();
        Assert.assertTrue(Mondaybox.isDisplayed());
        Assert.assertTrue(Fridaybox.isDisplayed());

        WebElement summary = driver.findElement(By.cssSelector("[data-name='recurrence-summary']"));
        String Actualsummary = summary.getText();
        String Expectedsummary = "Weekly every 1 week on Monday, Friday";
        Assert.assertEquals(Actualsummary, Expectedsummary);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}