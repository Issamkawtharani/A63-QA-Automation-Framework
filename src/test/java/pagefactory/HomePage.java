package pagefactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = "img[class='avatar']")
    WebElement avatarIcon;
    //Plus sign
    @FindBy(xpath = "//i[@title='Create a new playlist']")
    WebElement plusSign;
    //New Playlist
    @FindBy(xpath = "//li[@data-testid='playlist-context-menu-create-simple']")
    WebElement newPlaylistBtn;
    //Enter New Playlist Name
    @FindBy(css = "input[name='name']")
    WebElement newPlaylistName;
    //Success Message Notification
    @FindBy(xpath = "//div[@class='success show']")
    WebElement successMsgNotification;


    public HomePage(WebDriver givenDriver) { super(givenDriver); }

    public HomePage clickPlusSign() {
        click(plusSign);
        return this;
    }

    public HomePage clickCreateNewPlaylist() {
        click(newPlaylistBtn);
        return this;
    }

    public HomePage enterPlaylistName(String name) {
        newPlaylistName.sendKeys(name);
        newPlaylistName.sendKeys(Keys.ENTER);
        return this;
    }

    public String getMsgNotification() {
        return successMsgNotification.getText();
    }

}
