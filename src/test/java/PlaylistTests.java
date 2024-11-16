import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.LoginPage;
import pagefactory.HomePage;

public class PlaylistTests extends BaseTest {

    @Test
    public void renamePlaylist() {
        String playlistName = "Test Pro Edited Playlist 2";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //Login to page
        loginPage.provideEmail("issam.kawtharani@testpro.io").providePassword("Issam@testpro1").clickSubmit();
        //Enter new playlist
        homePage.doubleClickPlaylist().enterNewPlaylistName(playlistName);
        //Changed the approach for assert from HW22
        Assert.assertEquals(homePage.getPlaylistName(), playlistName);
    }
}