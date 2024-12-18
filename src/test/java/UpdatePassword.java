import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class UpdatePassword extends BaseTest {
    //Make sure that the current password is Issam@testpro1
    //New Password is Issam@testpro2
    @Test
    public void updatePasswordProfilePreferences() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("issam.kawtharani@testpro.io")
                .providePassword("Issam@testpro1").clickSubmit();
        homePage.clickProfileName().provideCurrentPassword("Issam@testpro1")
                .provideName("Issam Kawtharani").provideEmailAddress("issam.kawtharani@testpro.io")
                .provideNewPassword("Issam@testpro2").clickSaveBtn();
        Assert.assertTrue(homePage.isProfileUpdatedMsgDisplayed());
    }

    // Update Password with less than 10 characters
    //(dataProvider = "IncorrectPswrdRequirements")
    @Test
    public void updatePasswordIncorrectRequirements() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("issam.kawtharani@testpro.io")
                .providePassword("Issam@testpro1").clickSubmit();
        homePage.clickProfileName().provideCurrentPassword("Issam@testpro1")
                .provideNewPassword("Issam@1").clickSaveBtn();
        Assert.assertEquals(homePage.getErrorMessage(), errorMessageUpdatePassword );


        // update profile with correct requirements
        driver.navigate().refresh();
        homePage.clickProfileName().provideCurrentPassword("Issam@testpro1")
                .provideNewPassword("Issam@testpro2").clickSaveBtn();
        Assert.assertTrue(homePage.isProfileUpdatedMsgDisplayed());

        //wait for 5 seconds in order to be able to click on logout button
        Thread.sleep(5000);

        //Logout from Application
        homePage.logoutFromApp();
        Thread.sleep(2000);
        
        //login with OLD Password
        loginPage.provideEmail("issam.kawtharani@testpro.io")
                .providePassword("Issam@testpro1")
                .clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), homePageAddress);


        //Login with CORRECT Password
        driver.navigate().refresh();
        loginPage.provideEmail("issam.kawtharani@testpro.io")
                .providePassword("Issam@testpro2")
                .clickSubmit();
        Assert.assertTrue(homePage.isAvatarDisplayed());
    }


    @Test
    public void updatePassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("issam.kawtharani@testpro.io")
                .providePassword("Issam@testpro2").clickSubmit();
        homePage.clickProfileName().provideCurrentPassword("Issam@testpro2")
                .provideNewPassword("Issam@testpro1").clickSaveBtn();
        Assert.assertTrue(homePage.isProfileUpdatedMsgDisplayed());
    }

}