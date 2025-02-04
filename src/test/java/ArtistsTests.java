import org.testng.Assert;
import org.testng.annotations.Test;
import pom.AllSongs;
import pom.Artists;
import pom.LoginPage;

public class ArtistsTests extends BaseTest
{
    int artistsNumberInDB = 21;
    String songsLength = "04:32:57";

    @Test
    public void artistsInApp() { //User should be able to see artists in app
        LoginPage loginPage = new LoginPage(driver);
        Artists artists = new Artists(driver);
        loginPage.login();
        artists.clickArtistsBtn();
        Assert.assertEquals(artists.artistsAlbumsNumber(), artistsNumberInDB);
    }

    @Test
    public void searchArtistsUsingSearchField() { //User should be able to find artists using search field
        LoginPage loginPage = new LoginPage(driver);
        Artists artists = new Artists(driver);
        loginPage.login();
        artists.enterArtistNameInSearchField();
        Assert.assertFalse(artists.isNoneFoundDisplayed());
    }

    @Test
    public void playSelectedSong() { //User should be able to play a song of selected artist
        LoginPage loginPage = new LoginPage(driver);
        Artists artists = new Artists(driver);
        loginPage.login();
        artists.enterArtistName();
        artists.clickSelectedSong();
        Assert.assertTrue(artists.isSongPlaying());
    }


}
