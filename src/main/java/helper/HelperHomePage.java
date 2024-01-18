package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HelperHomePage extends HelperBase {
    public HelperHomePage(WebDriver driver) {
        super(driver);
    }


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
    public void clickTabHome() {
        click(By.xpath(TAB_HOME));
    }
    public void clickTabLost() {
        click(By.xpath(TAB_LOST));
    }
    public void clickTabFound() {
        click(By.xpath(TAB_FOUND));
    }
    public void clickTabServise() {
        click(By.xpath(TAB_SERVISES));
    }
    public void clickTabFavorites() {
        click(By.xpath(TAB_FAVORITES));
    }




}
