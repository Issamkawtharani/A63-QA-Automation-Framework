import org.openqa.selenium.Alert;
import org.openqa.selenium.json.JsonOutput;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

import java.util.Objects;


public class UpdateEmail extends BaseTest {

     //User Story 1: User should be able to update account email in app
    @Test(priority=1)
    public void updateEmailPreferenceProfile() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("issam.kawtharani@testpro.io")
                .providePassword("Issam@testpro1").clickSubmit();
        homePage.clickProfileName().provideCurrentPassword("Issam@testpro1")
                .provideEmailAddress("issam.kawtharani@gmail.com").clickSaveBtn();
        Assert.assertEquals(homePage.getNotificationMessage(), successMsg);
    }

        //User Story 5: User should be able to log in into app with updated email
        @Test (priority=2)
        public void loginWithUpdatedEmail () {
            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);
            loginPage.provideEmail("issam.kawtharani@gmail.com")
                    .providePassword("Issam@testpro1").clickSubmit();
            Assert.assertTrue(homePage.isAvatarDisplayed());
        }

        //User Story 6: User should be able to log in into app with updated email
        @Test (priority=3)
       public void loginWithOldEmail () {
            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);
            loginPage.provideEmail("issam.kawtharani@testpro.io")
                    .providePassword("Issam@testpro1").clickSubmit();
            Assert.assertEquals(driver.getCurrentUrl(), homePageAddress);
        }


    //User Story 2: Add validation to the email field: email must have @ symbol
                 // Show error message if email is not valid
    @Test (priority=4)
    public void updateEmailWithoutAtSign() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("issam.kawtharani@gmail.com")
                .providePassword("Issam@testpro1").clickSubmit();
        homePage.clickProfileName().provideCurrentPassword("Issam@testpro1")
                .provideEmailAddress("issam.kawtharanigmail.com").clickSaveBtn();
        System.out.println(homePage.getEmailField());
        Assert.assertEquals(homePage.getEmailField(), "issam.kawtharanigmail.com");
    }

    //User Story 2: Add validation to the email field: email must have dot .
    // Show error message if email is not valid
    @Test (priority=5)
    public void updateEmailWithoutDot() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("issam.kawtharani@gmail.com")
                .providePassword("Issam@testpro1").clickSubmit();
        homePage.clickProfileName().provideCurrentPassword("Issam@testpro1")
                .provideEmailAddress("issam.kawtharani@gmailcom").clickSaveBtn();
        Assert.assertNotEquals(homePage.getNotificationMessage(), "Profile updated.", "Success Message = Profile Updated");
    }


    //User Story 2: Add validation to the email field: email must have domain .
    // Show error message if email is not valid
    @Test (priority=6)
    public void updateEmailWithoutDomain() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("issam.kawtharani@gmailcom")
                .providePassword("Issam@testpro1").clickSubmit();
        homePage.clickProfileName().provideCurrentPassword("Issam@testpro1")
                .provideEmailAddress("issam.kawtharani@gmail.").clickSaveBtn();
        //Thread.sleep(3000);
        //System.out.println("email field retrieved: " + homePage.getEmailField());

        Assert.assertEquals(homePage.getEmailField(), "issam.kawtharani@gmail.");
    }




    //User Story 3: Prevent users from using + sign before @ symbol to prevent multiple
                 // account generation for the same user
    @Test (priority=7)
    public void updateEmailWithPlusSign() {

        //Update email with an existing email
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("issam.kawtharani@gmailcom")
                .providePassword("Issam@testpro1").clickSubmit();
        homePage.clickProfileName().provideCurrentPassword("Issam@testpro1")
                .provideEmailAddress("issam.kawtharani+@gmailcom").clickSaveBtn();
        Assert.assertNotEquals(homePage.getNotificationMessage(), successMsg);
            //User is able to update email with a "+" sign before @ symbol.
    }




    //User Story 4: If the new email is already in the database, show the message "this user already exists"
    @Test (priority=8)
    public void updateEmailWithExistingEmail() {

        //Update email with an existing email
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("issam.kawtharani+@gmailcom")
                .providePassword("Issam@testpro1").clickSubmit();
        homePage.clickProfileName().provideCurrentPassword("Issam@testpro1")
                .provideEmailAddress("issam.kawtharani+@gmailcom").clickSaveBtn();
        Assert.assertNotEquals(homePage.getNotificationMessage(), successMsg);
        //User is able to update email with an existing email.
    }

@Test (priority=9)
    public void updateEmailToTestpro() {

        //Update email with valid credentials
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("issam.kawtharani+@gmailcom")
                .providePassword("Issam@testpro1").clickSubmit();
        homePage.clickProfileName().provideCurrentPassword("Issam@testpro1")
                .provideEmailAddress("issam.kawtharani@testpro.io").clickSaveBtn();
        Assert.assertEquals(homePage.getNotificationMessage(), successMsg);
    }

/*
    @Test (dataProvider = "wrongEmailUpdate")
        public void updateEmailWithoutAtSign(String wrongEmail) {
        // Update Email without @ sign
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("issam.kawtharani@testpro.io")
                .providePassword("Issam@testpro1").clickSubmit();
        homePage.clickProfileName().provideCurrentPassword("Issam@testpro1")
                .provideEmailAddress(wrongEmail).clickSaveBtn();
        Assert.assertEquals(homePage.getErrorMessage(), successMsg);
    }

 */



}