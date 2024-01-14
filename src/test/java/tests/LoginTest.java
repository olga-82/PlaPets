package tests;

import models.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{


    @Test
    public void testLogin(){
        UserDTO user =  UserDTO.builder()
                .email("olgakolcina861@gmail.com")
                .password("sara123$")
                .build();
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
