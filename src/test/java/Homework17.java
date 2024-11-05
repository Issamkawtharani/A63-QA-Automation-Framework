import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedMessage = "Added 1 song into \"Test Pro Playlist.\"";
        navigateToPage();
        provideEmail("issam.kawtharani@testpro.io");
        providePassword("Issam@testpro1");
        clickSubmit();
        Thread.sleep(2000);
        searchSong("Pluto");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist();
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);
    }
}
