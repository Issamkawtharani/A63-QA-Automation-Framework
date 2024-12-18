import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    public String errorMessageUpdatePassword = "The new password must be at least 10 characters.";
    public String homePageAddress ="https://qa.koel.app/#!/profile";
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        //added chromeOptions arguments below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        actions = new Actions(driver);
        url = BaseURL;
        navigateToPage();
    }

    @AfterMethod

    public void closeBrowser(){
        driver.quit();
    }

    public void navigateToPage(){
        driver.get(url);
    }

    @DataProvider(name = "IncorrectPswrdRequirements")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][]{
                {"Issam@testpro1", "Issam@1"},
                {"Issam@testpro1", "ISSAM@1234567"},
                {"Issam@testpro1", "issam@1234567"},
        };
    }
}

