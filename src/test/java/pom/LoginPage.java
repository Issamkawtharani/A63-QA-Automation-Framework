package pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.sql.Driver;


public class LoginPage extends BasePage {
    public LoginPage (WebDriver givenDriver) { super(givenDriver); }
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");

    public void provideEmail (String email) { findElement (emailField).sendKeys(email); }
    public void providePassword (String password) { findElement (passwordField).sendKeys(password); }
    public void clickSubmit() { findElement (submitBtn).click(); }

    public void login() {
        provideEmail("issam.kawtharani@testpro.io");
        providePassword("Issam@testpro1");
        clickSubmit();
    }
}