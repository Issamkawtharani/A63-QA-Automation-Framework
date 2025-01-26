import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.AllSongs;
import pom.HomePage;
import pom.LoginPage;

import java.util.Objects;

public class AllSongsTests extends BaseTest
{
    int allSongsCountNumber = 66;
    String songsLength = "04:32:57";
    int idCount = 0;
    @Test
    public void allSongsDisplayAsInDB() {
        LoginPage loginPage = new LoginPage(driver);
        AllSongs allSongs = new AllSongs(driver);
        loginPage.login();
        allSongs.clickAllSongsBtn();
        Assert.assertEquals(allSongs.allSongsNumber(), allSongsCountNumber);
    }

    @Test
    public void totalCountOfSongsShouldBeDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        AllSongs allSongs = new AllSongs(driver);
        loginPage.login();
        allSongs.clickAllSongsBtn();
        Assert.assertEquals(allSongs.isAllSongsCountDisplay().substring(11, 19), songsLength);
    }

    @Test
    public void idCorrectlyDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        AllSongs allSongs = new AllSongs(driver);
        loginPage.login();
        allSongs.clickAllSongsBtn();
        allSongs.idCountTotal();
        Assert.assertEquals(allSongs.idCountTotal(), allSongsCountNumber);
    }


}
