import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;
import pom.SmartPlaylist;

public class CreateNewSmartPlaylistTests extends BaseTest{
    String expectedMsg = "Created playlist \"My New Smart Playlist.\"";
    String expectedMsg2 = "Created playlist \"My New Smart Playlist Multiple Rules.\"";
    String expectedMsg3 = "Created playlist \"My New Smart Playlist Group.\"";



    @Test // User should be able to create a Smart playlist in app with one rule
    public void CreateNewSmartPlayList() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SmartPlaylist smartPlaylist = new SmartPlaylist(driver);
        loginPage.login();
        smartPlaylist.clickCreateNewPlaylistBtn();
        smartPlaylist.clickNewSmartPlaylistBtn();
        smartPlaylist.enterSmartPlaylistName();
        smartPlaylist.selectOptionFromSecondPlaylist();
        smartPlaylist.clickSaveBtn();
        Assert.assertEquals(smartPlaylist.isSuccessMsdDisplayed(), expectedMsg);
    }

    @Test // User should be able to create a Smart playlist in app with multiple rules
    public void CreateNewSmartPlayListMultipleRules() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SmartPlaylist smartPlaylist = new SmartPlaylist(driver);
        loginPage.login();
        smartPlaylist.clickCreateNewPlaylistBtn();
        smartPlaylist.clickNewSmartPlaylistBtn();
        smartPlaylist.enterSmartPlaylistName2();
        smartPlaylist.selectOptionFromSecondPlaylist();
        smartPlaylist.clickNewRuleBtn();
        smartPlaylist.selectOptionFromSecondPlaylistRule2();
        smartPlaylist.clickSaveBtn();
        Assert.assertEquals(smartPlaylist.isSuccessMsdDisplayed(), expectedMsg2);
    }

    @Test // User should be able to create a Smart playlist in app with Group
    public void CreateNewSmartPlayListWithGroup() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SmartPlaylist smartPlaylist = new SmartPlaylist(driver);
        loginPage.login();
        smartPlaylist.clickCreateNewPlaylistBtn();
        smartPlaylist.clickNewSmartPlaylistBtn();
        smartPlaylist.enterSmartPlaylistNameGroup();
        smartPlaylist.clickGroupBtn();
        smartPlaylist.selectOptionFromSecondPlaylist();
        smartPlaylist.selectOptionFromSecondPlaylistGroupRule2();
        smartPlaylist.clickSaveBtn();
        Assert.assertEquals(smartPlaylist.isSuccessMsdDisplayed(), expectedMsg3);
    }




}
