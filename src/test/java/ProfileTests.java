import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.LoginPage;
import pagefactory.ProfilePage;
import pagefactory.HomePage;

public class ProfileTests extends BaseTest {

    @Test
    public void changeCurrentTheme() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        loginPage.provideEmail("issam.kawtharani@testpro.io")
                .providePassword("Issam@testpro1")
                .clickSubmit();
        homePage.clickProfileIcon();
        profilePage.chooseVioletTheme();
        Assert.assertTrue(profilePage.isVioletThemeSelected());
    }

}