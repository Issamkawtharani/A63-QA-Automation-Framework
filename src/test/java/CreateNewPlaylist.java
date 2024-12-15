import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

import java.sql.SQLOutput;

public class CreateNewPlaylist extends BaseTest {

    @Test
    public void createNewPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("issam.kawtharani@testpro.io")
                .providePassword("Issam@testpro1").clickSubmit();
        homePage.clickPlusSign().clickCreateNewPlaylist()
                .enterPlaylistName("Test Pro Playlist");
        Assert.assertEquals(homePage.getMsgNotification(), createdPlaylist);
    }

    //To create a duplicated Playlist , make sure that Test Pro Playlist is already existed
    @Test
    public void createDuplicatedPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("issam.kawtharani@testpro.io")
                .providePassword("Issam@testpro1").clickSubmit();
        homePage.clickPlusSign().clickCreateNewPlaylist()
                .enterPlaylistName("Test Pro Playlist");
        Assert.assertEquals(homePage.getMsgNotification(), createdPlaylist);
    }

    //Create Playlist with 2 characters
    //User is able to create a Playlist with 2 characters
    @Test
    public void createPlaylistTwoChar() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("issam.kawtharani@testpro.io")
                .providePassword("Issam@testpro1").clickSubmit();
        homePage.clickPlusSign().clickCreateNewPlaylist()
                .enterPlaylistName("Tp");
        Assert.assertEquals(homePage.getMsgNotification(), createdPlaylistTwoChar);
    }

    @Test
    public void createPlaylistTenPlusChar() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("issam.kawtharani@testpro.io")
                .providePassword("Issam@testpro1").clickSubmit();
        homePage.clickPlusSign().clickCreateNewPlaylist()
                .enterPlaylistName("Tp1234567890");
        Assert.assertEquals(homePage.getMsgNotification(), createdPlaylistTenPlusChar);
    }

}
