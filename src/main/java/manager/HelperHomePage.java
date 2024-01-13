package manager;

import org.openqa.selenium.WebDriver;

public class HelperHomePage extends HelperBase{
    public HelperHomePage(WebDriver driver) {
        super(driver);
    }
    private final String BUTTON_LOGOUT = " //div[@data-test-id='logout-container']";
    private final String BUTTON_ADD ="//*[@id='root']/div[1]/div/div[2]/button";
    private final String TAB_HOME = "//div[@data-test-id='navigation']/div[1]";
    private final String TAB_LOST = "//div[@data-test-id='navigation']/div[2]";
    private final String TAB_FOUND = "//div[@data-test-id='navigation']/div[3]";
    private final String TAB_SERVISES = "//div[@data-test-id='navigation']/div[4]";
    private final String TAB_FAVORITES = "//div[@data-test-id='navigation']/div[5]";
    private final String TAB_MY_PROFILE = " //div[@data-test-id='user-icon-container']";
    private final String BUTTON_LOST_MY_PET = " //div[@data-test-id='account-header-lost-found']/button[1]";
    private final String BUTTON_FOUND_MY_PET = " //div[@data-test-id='account-header-lost-found']/button[2]";
    private final String INPUT_TEXT  = " //*[@id='root']/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/div";

}
