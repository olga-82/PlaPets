package manager;

import models.UserDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperLogin extends HelperBase{
    public HelperLogin(WebDriver driver) {
        super(driver);
    }
    private final String TEXT_HOME_ASSIGNMENT ="//*[@id='root']/div[2]/div[1]/div/div[1]";
    private final String BUTTON_SIGN_IN ="//button[@type='button']";
    private final String MODAL_WINDOW_FOR_LOGIN ="//div[@data-test-id='modal-window']";
    private final String MODAL_WINDOW_BUTTON_SIGN_IN ="//div[@data-test-id='sign-in-button']";
    private final String INPUT_EMAIL ="//input[@id='mui-11']";
    private final String INPUT_PASSWORD ="//input[@id='mui-16']";
    private final String BUTTON_SUBMIT =" //*[@id='root']/div[6]/div/div/div[5]/div[2]/button[2]";
    private final String BUTTON_ADD ="//*[@id='root']/div[1]/div/div[2]/button";

    public  void openLoginWindow() {
        click(By.xpath(BUTTON_SIGN_IN));

    }
public void  openLoginForm() {
        click(By.xpath(MODAL_WINDOW_BUTTON_SIGN_IN));
}

public void fillLoginForm(UserDTO user){
      type(By.xpath( INPUT_EMAIL), user);

}
    //sara123$



}
//*[@id="root"]/div[1]/div/div[2]/button
//div[@data-test-id='welcome-text']
//button[@type='button']
//div[@data-test-id='modal-window']
//div[@data-test-id='sign-in-button']
//input[@id='mui-16']
//input[@ id='mui-11']