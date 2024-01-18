package helper;

import models.UserDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver driver) {
        super(driver);
    }

    private final String TEXT_LOGIN_PAGE = "//*[@id='root']/div[2]/div[1]/div/div[1]";
    private final String BUTTON_SIGN_IN = "//button[@type='button']";
    private final String MODAL_WINDOW_FOR_LOGIN = "//div[@data-test-id='modal-window']";
    private final String MODAL_WINDOW_BUTTON_SIGN_IN = "//div[@data-test-id='sign-in-button']";
    private final String INPUT_EMAIL = "//input[@type='email']";
    private final String INPUT_PASSWORD = "//input[@type='password']";
    private final String TERMS_LINK = " //span[@data-test-id='terms-link']";
    private final String BUTTON_CANCEL = " //*[@id='root']/div[6]/div/div/div[5]/div[2]/button[1]";
    private final String BUTTON_AGREE = "//*[@id='root']/div[6]/div/div/div[2]/button";
    private final String BUTTON_SUBMIT = " //*[@id='root']/div[6]/div/div/div[5]/div[2]/button[2]";
    private final String BUTTON_ADD = "//*[@id='root']/div[1]/div/div[2]/button";
    private final String TAB_LOGOUT = " //div[@data-test-id='logout-container']";

    public void openLoginWindow() {
        click(By.xpath(BUTTON_SIGN_IN));

    }

    public void openLoginForm() {
        click(By.xpath(MODAL_WINDOW_BUTTON_SIGN_IN));
    }

    public void fillLoginForm(UserDTO user) {
        type(By.xpath(INPUT_EMAIL), user.getEmail());
        type(By.xpath(INPUT_PASSWORD), user.getPassword());
    }

    public void reedTerms() {
        click(By.xpath(TERMS_LINK));
    }

    public void clickButtonAgree() {
        click(By.xpath(BUTTON_AGREE));
    }

    public void clickButtonSubmit() {
        click(By.xpath(BUTTON_SUBMIT));

    }

    public boolean IsHomePageOpen() {

        return isElementPresent(By.xpath(BUTTON_ADD));
    }

    public void isModalWindowPresent() {
        isElementPresent(By.xpath(MODAL_WINDOW_FOR_LOGIN));
    }

    public void isHomePagePresent() {
        wait(By.xpath(TEXT_LOGIN_PAGE));
    }

    public void isButtonAgreePresent() {
        waitElementToBeClickable(By.xpath(BUTTON_AGREE));

    }


    public void loginUser(UserDTO user) {

        isHomePagePresent();
        openLoginWindow();
        isModalWindowPresent();
        openLoginForm();
        fillLoginForm(user);
        reedTerms();
        isButtonAgreePresent();
        clickButtonAgree();
        clickButtonSubmit();
        Assert.assertTrue(IsHomePageOpen());

    }
    public void logout() {
        click(By.xpath(TAB_LOGOUT));
    }
}
