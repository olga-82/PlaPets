package tests;


import helper.TestNGListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners(TestNGListener.class)
public class LoginTest extends BaseTest{


    @Test
    public void testLogin(){
        app.getUser().isHomePagePresent();
        app.getUser().openLoginWindow();
        app.getUser().isModalWindowPresent();
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().reedTerms();
        app.getUser().isButtonAgreePresent();
        app.getUser().clickButtonAgree();
        app.getUser().clickButtonSubmit();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().IsHomePageOpen());

    }
}
