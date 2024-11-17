import org.testng.annotations.Test;
import org.testng.Assert;
import pom.LoginPage;
import pom.AllSongs;

public class SongTests extends BaseTest {

    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(driver);
        AllSongs allSongs = new AllSongs(driver);

        loginPage.provideEmail("issam.kawtharani@testpro.io");
        loginPage.providePassword("Issam@testpro1");
        loginPage.clickSubmit();
        allSongs.chooseAllSongList();
        allSongs.contextClickFirstSong();
        allSongs.choosePlayOption();
        Assert.assertTrue(allSongs.isSongPlaying());
    }
}