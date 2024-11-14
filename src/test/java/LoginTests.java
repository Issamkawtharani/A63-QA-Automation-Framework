import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class LoginTests extends BaseTest {
    //Fluent interface example
    @Test
    public void loginValidEmailPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("issam.kawtharani@testpro.io")
                 .providePassword("Issam@testpro1")
                 .clickSubmit();
        Assert.assertTrue(homePage.isAvatarDisplayed());
    }
}
