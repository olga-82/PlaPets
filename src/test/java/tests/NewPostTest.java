package tests;

import models.PetsPostDTO;
import models.UserDTO;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewPostTest extends BaseTest{
    @BeforeMethod
    public void precondition(){
//        UserDTO user  = UserDTO.builder()
//                .email("olgakolcina861@gmail.com")
//                .password("sara123$")
//                .build();
        app.getUser().loginUser(user);




    }
    @Test
    public void NewPostTest() {
        PetsPostDTO pets = PetsPostDTO.builder()
                .description("test description")
                .location("Tel Aviv")
                .contactsPhone("2345676543")
                .email("test@mail.com")
                .build();
        app.getUser().pause(5000);
        app.getHomePage().isButtonAddPresent();
        app.getHomePage().clickAddButton();
        app.getUser().pause(5000);
        app.getGreatPage().fillNewPost(pets);

    }


@AfterMethod
    public void postcondition(){

        app.getUser().logout();
}


}
