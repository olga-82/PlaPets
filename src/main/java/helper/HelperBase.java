package helper;

import com.google.common.io.Files;
import manager.AppManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class HelperBase  {



    WebDriver driver ;
    public HelperBase( WebDriver driver) {
        this.driver = driver;
    }

    public  void  click(By locator) {
        driver.findElement(locator).click();
    }
    public void type(By locator, String text){
        WebElement element=driver.findElement( locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    public String getTextAttribute(String attribute,By locator) {
        return driver.findElement(locator).getAttribute(attribute);
    }
    public void clickRightMouse(By locator) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.contextClick(element).perform();
    }
    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }


    public void waitElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public WebElement wait(By locator) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5) );
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public  void takeScreenshot(String link) {
        File tmp=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenshot=new File(link);
        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}



