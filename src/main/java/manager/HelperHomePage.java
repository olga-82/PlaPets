package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperHomePage extends HelperBase {
    public HelperHomePage(WebDriver driver) {
        super(driver);
    }

    private final String TAB_LOGOUT = " //div[@data-test-id='logout-container']";
    private final String BUTTON_ADD = "//*[@id='root']/div[1]/div/div[2]/button";
    private final String TAB_HOME = "//div[@data-test-id='navigation']/div[1]";
    private final String TAB_LOST = "//div[@data-test-id='navigation']/div[2]";
    private final String TAB_FOUND = "//div[@data-test-id='navigation']/div[3]";
    private final String TAB_SERVISES = "//div[@data-test-id='navigation']/div[4]";
    private final String TAB_FAVORITES = "//div[@data-test-id='navigation']/div[5]";
    private final String TAB_MY_PROFILE = " //div[@data-test-id='user-icon-container']";

    public void clickAddButton() {
        click(By.xpath(BUTTON_ADD));

    }
    public void isButtonAddPresent(){
        pause(5000);
        isElementPresent(By.xpath(BUTTON_ADD));

    }
    public void clickButtonHome() {
        click(By.xpath(TAB_HOME));
    }
    public void clickAddButt() {
        // click(By.cssSelector("label[for='terms-of-use']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector" +
                "('#root > div.sc-aXZVg.llOyaz > div > div.sc-gsFSXq.bnjPcz > button').click();");

//        Rectangle rect = wd.findElement(By.cssSelector("div.checkbox-container")).getRect();
//        int x = rect.getX()+5;
//        int y = rect.getY()+ rect.getHeight()/4;
//        Actions actions = new Actions(wd);
//        actions.moveByOffset(x,y).click().perform();
    }

    public void logout() {
        click(By.xpath(TAB_LOGOUT));
    }
}
//#root > div.sc-aXZVg.llOyaz > div > div.sc-gsFSXq.bnjPcz > button