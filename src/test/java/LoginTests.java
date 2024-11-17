import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class LoginTests extends BaseTest {
    //Fluent interface example
    @Test
    public void loginValidEmailPassword() {
        //LoginPage loginPage = new LoginPage(driver);
        //HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("issam.kawtharani@testpro.io")
                 .providePassword("Issam@testpro1")
                 .clickSubmit();
        Assert.assertTrue(homePage.isAvatarDisplayed());
    }

    @Test
    public void loginInValidEmailPassword() {
        String url = "https://qa.koel.app/";
        //LoginPage loginPage = new LoginPage(driver);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("invalidemail@testpro.io ")
                .providePassword("wrongpassword@testpro1")
                .clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test (enabled = false)
    public void loginInEmptyEmailPassword() {
        String url = "https://qa.koel.app/";
        //LoginPage loginPage = new LoginPage(driver);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail(" ")
                .providePassword("")
                .clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}
