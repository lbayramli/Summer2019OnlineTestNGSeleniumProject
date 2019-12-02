package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

public abstract class BasePage {

    @FindBy(css = "div[class='loader-mask shown']")
    public WebElement loaderMask;



    public BasePage(){
        PageFactory.initElements(Driver.get(), this);

    }

        /**
         * This method stands for navigation in vytrack app
         * provide tab name, for example "Fleet" as a String
         * and module name, for example "Vehicles" as a String as well
         * then based on these values, locators will be created
         * @param moduleName
         * @param subModuleName
         */
        public void navigateTo(String moduleName, String subModuleName) {
                                       //tabname       //modulname
            String moduleLocator = "//*[normalize-space()='"+moduleName+"' and @class='title title-level-1']";
            String subModuleLocater="//*[normalize-space()='"+subModuleName+"' and @class='title title-level-2']";
                                                    //*[@class='title title-level-1' and contains(text), 'Fleet')]
                                                    // normalize =space is for the getting rid of empty spaces
            WebDriverWait wait=new WebDriverWait(Driver.get(),10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleLocator)));

            WebElement module=Driver.get().findElement(By.xpath(moduleLocator));

            wait.until(ExpectedConditions.visibilityOf(module));
            wait.until(ExpectedConditions.elementToBeClickable(module));
            module.click();// once we clik the module submodule shoudl be visible

            WebElement subModule=Driver.get().findElement(By.xpath(subModuleLocater));
            wait.until(ExpectedConditions.visibilityOf(subModule));
            subModule.click();
            //after navigation
            //wait until loader mask disapper
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));





        }
    }

