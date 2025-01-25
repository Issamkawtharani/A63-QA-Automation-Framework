import org.testng.Assert;
import org.testng.annotations.Test;
import pom.Albums;
import pom.BasePage;
import pom.HomePage;
import pom.LoginPage;

public class AlbumsTest extends BaseTest {
    String expectedAlbumName = "Disorganized Complexity EP";
    String expectedArtistName = "Herre Jorna";

    //Page Object Model example
    @Test
    public void albumsCoverExisting() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        Albums albums = new Albums(driver);
        loginPage.login();
        albums.clickAlbumsBtn();
        Assert.assertTrue(albums.isAlbumCoverPresent().isDisplayed());
    }

    @Test
    public void albumsName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        Albums albums = new Albums(driver);
        loginPage.login();
        albums.clickAlbumsBtn();
        Assert.assertEquals(albums.isAlbumNamePresent(), expectedAlbumName );
    }

    @Test
    public void artistsName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        Albums albums = new Albums(driver);
        loginPage.login();
        albums.clickAlbumsBtn();
        Assert.assertEquals(albums.isArtistNamePresent(), expectedArtistName );
    }

    @Test
    public void shuffleIconPresent() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        Albums albums = new Albums(driver);
        loginPage.login();
        albums.clickAlbumsBtn();
        albums.albumCoverMouseHover();
        Assert.assertTrue(albums.isShuffleIconPresent().isDisplayed());
    }

    @Test
    public void downloadIconPresent() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        Albums albums = new Albums(driver);
        loginPage.login();
        albums.clickAlbumsBtn();
        albums.albumCoverMouseHover();
        Assert.assertTrue(albums.isDownloadIconPresent().isDisplayed());
    }



}
