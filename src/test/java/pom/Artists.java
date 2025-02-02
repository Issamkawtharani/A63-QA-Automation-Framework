package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Artists extends BasePage {

    int idCount = 0;

    public Artists(WebDriver givenDriver) {
        super(givenDriver);
    }

    By allArtistsAlbums = By.xpath("//div[@class='artists main-scroll-wrap as-thumbnails']//div[@class='info']");
    By artistsBtn = By.cssSelector("a[class='artists']");
    By searchField = By.xpath("//input[@placeholder='Press F to search']");
    By noneFound = By.xpath("//section[@class='songs']//p[contains(text(),'None found.')]");
    By playSong = By.xpath("//body/div[@id='app']/div[@id='main']/div[@id='mainWrapper']/section[@id='mainContent']/section[@id='searchExcerptsWrapper']/div[@class='main-scroll-wrap']/div[@class='results']/section[@class='songs']/ul/article[1]/span[1]");
    By soundBar = By.xpath("//img[@alt='Sound bars']");

    public void clickArtistsBtn() {
        findElement(artistsBtn).click();
    }

    public int artistsAlbumsNumber() {
        return driver.findElements(allArtistsAlbums).size();
    }

    public void enterArtistNameInSearchField() {
        findElement(searchField).sendKeys("Lobo Loco");
    }

    public boolean isNoneFoundDisplayed() {
        return findElement(noneFound).isDisplayed();

    }

    public void enterArtistName() {
        findElement(searchField).sendKeys("Robert John");
    }

    public void clickSelectedSong() {
        findElement(playSong).click();
    }

    public boolean isSongPlaying() {
        return findElement(soundBar).isDisplayed();

    }

}