package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = "img[class='avatar']")
    WebElement avatarIcon;
    //Profile Name
    @FindBy(css = "span[class='name']")
    WebElement profileName;
    //Current Password
    @FindBy(css = "#inputProfileCurrentPassword")
    WebElement currentPswrd;
    //Name Field
    @FindBy(css = "#inputProfileName")
    WebElement nameField;
    //Email Field
    @FindBy(css = "#inputProfileEmail")
    WebElement emailField;
    //New Password Field
    @FindBy(css = "#inputProfileNewPassword")
    WebElement newPasswordField;
    //Save Button
    @FindBy(css = "button[class='btn-submit']")
    WebElement saveBtn;
    //Success Message
    @FindBy(css = ".success.show")
    WebElement successMsg;
    //Notification error message
    @FindBy(css = ".error")
    WebElement errorMessage;
    //Logout
    @FindBy(css = "a[data-testid='btn-logout']")
    WebElement logoutBtn;


    public HomePage(WebDriver givenDriver) { super(givenDriver); }


    //Changed the approach for assert

    public boolean isAvatarDisplayed() {
        return findElement(avatarIcon).isDisplayed();
    }


    public HomePage clickProfileName() {
        click(profileName);
        return this;
    }

    public HomePage provideCurrentPassword(String password) {
        findElement(currentPswrd).sendKeys(password);
        return this;
    }

    public HomePage provideName(String name) {
        findElement(nameField).clear();
        findElement(nameField).sendKeys(name);
        return this;
    }


    public HomePage provideEmailAddress(String email) {
        findElement(emailField).clear();
        findElement(emailField).sendKeys(email);
        return this;
    }

    public HomePage provideNewPassword(String password) {
        findElement(newPasswordField).sendKeys(password);
        return this;
    }

    public HomePage clickSaveBtn() {
        click(saveBtn);
        return this;
    }


    public boolean isProfileUpdatedMsgDisplayed() {
        return findElement(successMsg).isDisplayed();
    }

    public String getErrorMessage() {
        return findElement(errorMessage).getText();
    }

    public HomePage logoutFromApp() {
        click(logoutBtn);
        return this;
    }
}
