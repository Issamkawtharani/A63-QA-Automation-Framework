import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ActionsClassPractice extends BaseTest {

   @Test
   public void deletePlaylist() throws InterruptedException {
        String ExpectedPlaylistDeletedMsg = "Deleted playlist \"Test Pro Playlist.\"";
        provideEmail("issam.kawtharani@testpro.io");
        providePassword("Issam@testpro1");
        clickSubmit();
        openPlayList();
        clickDeletePlaylistBtn();
        clickOkBtn();
        Assert.assertEquals(getDeletedPlaylistMsg(), ExpectedPlaylistDeletedMsg);
   }

   @Test
    public void renamePlaylist() {
        String updatedPlaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";
        provideEmail("issam.kawtharani@testpro.io");
        providePassword("Issam@testpro1");
        clickSubmit();
        doubleClickPlaylist();
        enterNewPlaylistName();
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
    }

    @Test
    public void playSong() {
        provideEmail("issam.kawtharani@testpro.io");
        providePassword("Issam@testpro1");
        clickSubmit();
        chooseAllSongList();
        contextClickFirstSong();
        choosePlayOption();
        Assert.assertTrue(isSongPlaying());
    }

    @Test
    public void hoverOverPlayButton() {
        provideEmail("issam.kawtharani@testpro.io");
        providePassword("Issam@testpro1");
        clickSubmit();
        Assert.assertTrue(hoverPlay().isDisplayed());
    }

    public WebElement hoverPlay() {
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return wait.until(ExpectedConditions.visibilityOf(play));
    }

    @Test
    public void countSongsInPlaylist() {
    //Prerequisite user created playlist named "Playlist Demo" with at least 1 song
    provideEmail("issam.kawtharani@testpro.io");
    providePassword("Issam@testpro1");
    clickSubmit();
    choosePlaylistByName("Playlist Demo");
    displayAllSongs();
    Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    //verifies if the playlist details song count is equal to the retrieved number of songs
}




}