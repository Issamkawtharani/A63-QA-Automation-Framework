import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver = null;
    public String url = "https://qa.koel.app/";

    public void navigateToPage() {
	    driver.get(url);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }


    public void searchSong(String name) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(name);
        Thread.sleep(2000);
    }

    public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }

    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
        Thread.sleep(2000);
    }

    public void clickAddToBtn() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToButton.click();
        Thread.sleep(2000);
    }

    public void choosePlaylist() throws InterruptedException {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'Test Pro Playlist')]"));
        playlist.click();
        Thread.sleep(2000);
    }

    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        notification.click();
        return notification.getText();
    }
@BeforeSuite
static void setupClass() {
    WebDriverManager.chromedriver().setup();
}

@BeforeMethod
public void launchBrowser() {
    //added chromeOptions arguments below to fix websocket error
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@AfterMethod
public void closeBrowser() {
        driver.quit();
}
}