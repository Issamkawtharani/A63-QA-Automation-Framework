package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllSongs extends BasePage {

    public AllSongs(WebDriver givenDriver) {super(givenDriver); }

    By allSongsBtn = By.cssSelector("li a.songs");
    By firstSongElement = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    By choosePlaySongBtn = By.cssSelector("li.playback");
    By soundBarVisualizer = By.cssSelector("[data-testid = 'sound-bar-play']");


    public void chooseAllSongList() { findElement(allSongsBtn).click(); }

    public void contextClickFirstSong() { contextClick(firstSongElement); }

    public void choosePlayOption() { click(choosePlaySongBtn); }

    public boolean isSongPlaying() { return findElement(soundBarVisualizer).isDisplayed(); }


}
