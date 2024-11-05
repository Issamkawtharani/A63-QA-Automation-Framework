import org.testng.annotations.Test;
import org.testng.Assert;

public class homework21 extends BaseTest {

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

}