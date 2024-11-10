import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.Assert;
import pom.HomePage;
import pom.LoginPage;
import pom.AllSongs;

public class Homework22 extends BaseTest {

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