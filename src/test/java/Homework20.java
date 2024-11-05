import org.testng.annotations.Test;
import org.testng.Assert;

public class Homework20 extends BaseTest {

   @Test
   public void deletePlaylist() throws InterruptedException {
        String ExpectedPlaylistDeletedMsg = "Deleted playlist \"Test Pro Playlist.\"";
        provideEmail("issam.kawtharani@testpro.io");
        providePassword("Issam@testpro1");
        clickSubmit();
        openPlayList();
        clickDeletePlaylistBtn();
        clickOktBtn();
        Assert.assertEquals(getDeletedPlaylistMsg(), ExpectedPlaylistDeletedMsg);
   }
}