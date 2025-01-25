package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Albums extends BasePage
{
    public Albums (WebDriver givenDriver)
    {
        super(givenDriver);
    }

    By albumsBtn = By.xpath("//a[normalize-space()='Albums']");
    By albumsCover = By.xpath("//article[@class='item full']//a[@role='button'][contains(text(),'Play all songs in the album Disorganized Complexit')]");
    By albumName = By.xpath("//article[@class='item full']//a[@class='name'][normalize-space()='Disorganized Complexity EP']");
    By artistName = By.xpath("//article[@class='item full']//a[@class='artist'][normalize-space()='Herre Jorna']");
    By shuffleIcon = By.xpath("//article[@class='item full']//a[@title='Shuffle all songs in the album Arps']//i[@class='fa fa-random']");
    By downloadIcon = By.xpath("//article[@class='item compact']//a[@title='Download all songs in the album Disorganized Complexity EP']");

     //public void provideEmail (String email) { findElement (emailField).sendKeys(email); }
    //public void providePassword (String password) { findElement (passwordField).sendKeys(password); }
    public void clickAlbumsBtn() { findElement (albumsBtn).click(); }
    public WebElement isAlbumCoverPresent() { return findElement (albumsCover); }
    public String isAlbumNamePresent() { return findElement (albumName).getText(); }
    public String isArtistNamePresent() { return findElement (artistName).getText(); }
    public WebElement isShuffleIconPresent() { return findElement (shuffleIcon); }
    public WebElement isDownloadIconPresent() { return findElement (downloadIcon); }
    public void albumCoverMouseHover() { mouseHover (albumsCover); }

}
