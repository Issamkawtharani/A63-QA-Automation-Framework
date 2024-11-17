import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.oer.its.etsi102941.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import javax.print.DocFlavor;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLPermission;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    public String newPlaylistName = "Sample Edited Playlist";
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})

    public void setUpBrowser (String BaseURL) throws MalformedURLException {
        threadDriver.set(pickBrowser (System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        url = BaseURL;
        navigateToPage(BaseURL);
    }
    public void launchBrowser(String BaseURL) throws MalformedURLException {

      /*  driver = pickBrowser(System.getProperty("browser"));
        //added chromeOptions arguments below to fix websocket error

        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        //driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        actions = new Actions(driver);
        url = BaseURL;
        navigateToPage(); */
    }

    @AfterMethod


    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
    }

    public void closeBrowser(){ driver.quit(); }

    public void navigateToPage(String url){
        getDriver().get(url);
    }

    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    public static WebDriver pickBrowser (String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        String gridURL = " http://172.20.9.129:4444"; //replace with your grid url
        //java -jar selenium-server-4.XX.0.jar standalone --selenium-manager true
        switch (browser) {
            case "firefox": // gradle clean test -Dbrowser=firefox
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();

            case "Microsoft Edge": // gradle clean test -Dbrowser-MicrosoftEdge
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);

            case "grid-edge": // gradle clean test -Dbrowser-grid-edge
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-firefox": // gradle clean test -Dbrowser-grid-firefox
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-chrome": // gradle clean test -Dbrowser-grid-chrome
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "cloud":
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }

    }

    public static WebDriver lambdaTest() throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("130");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "issam.kawtharani");
        ltOptions.put("accessKey", "OqxUgyUe41hgs87BQkCDzqpyh7l6pCxyygRfPuN1xxlVz8khTO");
        ltOptions.put("project", "Untitled");
        ltOptions.put("name", "TestPro");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver (new URL(hubURL), browserOptions);
    }

}