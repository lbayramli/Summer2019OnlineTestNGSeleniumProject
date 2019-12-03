package VyTrack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class LoginInvalid {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        WebElement input = driver.findElement(By.name("_username"));
        input.sendKeys("user");
        WebElement password = driver.findElement(By.name("_password"));
        password.sendKeys("User123$");

        WebElement button = driver.findElement(By.id("_submit"));
        button.click();

        String expectedResult = "Invalid user name or password.";
        WebElement actualResult = driver.findElement(By.cssSelector("[class='alert alert-error'] > div"));
        System.out.println(actualResult.getText());


        if (actualResult.equals(expectedResult)){
            System.out.println("Valid username and password");
        } else {
            System.out.println("Invalid username and password");


        }
        driver.close();

/*
ArrayList<String> InvalidUsernames = new ArrayList<>(Arrays.asList("storemanager", "user", "salesmanager"));
        String password = "UserUser123";
        for(int i =0; i<InvalidUsernames.size();i++) {

            BrowserUtils.wait(4);
            //this method open login page of VyTrack from chrome browser
            OpenLoginPage();
            //put invalid usernames
            BrowserUtils.wait(2);
            WebElement input = driver.findElement(By.xpath("//*[@id=\"prependedInput\"]"));
            input.sendKeys(InvalidUsernames.get(i));
            //put password: UserUser123
            BrowserUtils.wait(2);
            WebElement input2 = driver.findElement(By.xpath("//*[@id=\"prependedInput2\"]"));
            input2.sendKeys(password);
            //find LOGIN button
            WebElement button = driver.findElement(By.xpath("//*[@id=\"_submit\"]"));
            BrowserUtils.wait(2);
            //click on that button
            button.click();

            //finding elements with message "Invalid username or password"
            String InvalidMessage = "//*[@id=\"login-form\"]/fieldset/div[1]/div";
            WebElement element = driver.findElement(By.xpath(InvalidMessage));
            BrowserUtils.wait(2);
            //verifying that message "Invalid username or password"
            System.out.println(element.getText());

            driver.close();
        }


 */
    }
}
