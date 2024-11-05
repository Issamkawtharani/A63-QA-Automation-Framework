import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException{
        provideEmail("Issam.kawtharani@testpro.io");
        providePassword("Issam@testpro1");
        clickSubmit();
        clickPlayNextBtn();
        clickPlayBtn();
        Assert.assertTrue(isSongPlaying());
    }

}

