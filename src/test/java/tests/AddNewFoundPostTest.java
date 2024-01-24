package tests;

import models.Gender;
import models.PetDTO;
import models.Type;
import models.UserDTO;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DataProviderCVS;

public class AddNewFoundPostTest extends BaseTest{
    @BeforeMethod
    public void precondition(){
        app.getUser().loginUser(user);

    }
    @Test(dataProvider="DataForPets",dataProviderClass = DataProviderCVS.class)
    public void AddNewFoundPost( PetDTO pet){
        app.getUser().pause(5000);
        app.getHomePage().isButtonAddPresent();
        app.getHomePage().clickAddButton();
        app.getUser().pause(5000);
        app.getGreatPage().fillFoundForm(pet);
        app.getGreatPage().GetText();
    }
    @Test
    public void AddNewLostPost(){
        app.getUser().pause(5000);
        app.getHomePage().isButtonAddPresent();
        app.getHomePage().clickAddButton();
        app.getUser().pause(5000);
        app.getGreatPage().fillLostForm(pet);
        app.getGreatPage().GetText();
    }

    @AfterMethod
    public void postCondition(){
        app.getUser().logout();



    }


}
