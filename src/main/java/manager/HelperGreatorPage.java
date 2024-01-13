package manager;

import org.openqa.selenium.WebDriver;

public class HelperGreatorPage extends HelperBase{
    public HelperGreatorPage(WebDriver driver) {
        super(driver);
    }
    private final String BUTTON_LOST_MY_PET = " //div[@data-test-id='account-header-lost-found']/button[1]";
    private final String BUTTON_FOUND_MY_PET = " //div[@data-test-id='account-header-lost-found']/button[2]";
    private final String INPUT_TEXT  = "//*[@id='root']/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/div";
    private final String  BROWSER_BUTTON = "//div[@data-test-id ='browse-button']";
    private final String INPUT_DESCRIPTION ="//*[@id='root']/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div";
    private final String  BUTTON_ADD_DESC = "//*[@id='root']/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/button";
}


