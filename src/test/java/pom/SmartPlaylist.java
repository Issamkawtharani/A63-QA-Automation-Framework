package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SmartPlaylist extends BasePage {

    public SmartPlaylist(WebDriver givenDriver) {
        super(givenDriver);
    }

    By createNewPlaylistBtn = By.xpath("//i[@title='Create a new playlist']");
    By newSmartPlaylistBtn = By.xpath("//li[@data-testid='playlist-context-menu-create-smart']");
    By enterSmartPlaylistNameField = By.xpath("//input[@name='name']");
    By secondDropList = By.xpath(      "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/select[2]");
    By secondDrpListRule2 = By. xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[3]/select[2]");
    By secondDrpListGroupRule2 = By. xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[2]/select[2]");
    By smartPlOptionsNameField = By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]");
    By smartPlOptionsNameFieldRule2 = By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[3]/span[1]/input[1]");
    By saveBtn = By.xpath("//button[normalize-space()='Save']");
    By successMsg = By.xpath("//div[@class='success show']");
    By newRuleBtn = By.xpath("//button[normalize-space()='Rule']");
    By groupBtn = By.xpath("//button[normalize-space()='Group']");
    By smartPlOptionsNameFieldRule3 = By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[2]/span[1]/input[1]");



    public void clickCreateNewPlaylistBtn() {
        findElement(createNewPlaylistBtn).click();
    }

    public void clickNewSmartPlaylistBtn() {
        findElement(newSmartPlaylistBtn).click();
    }

    public void clickGroupBtn() {
        findElement(groupBtn).click();
    }

    public void enterSmartPlaylistName() {
        findElement(enterSmartPlaylistNameField).sendKeys("My New Smart Playlist");
    }

    public void enterSmartPlaylistName2() {
        findElement(enterSmartPlaylistNameField).sendKeys("My New Smart Playlist Multiple Rules");
    }

    public void enterSmartPlaylistNameGroup() {
        findElement(enterSmartPlaylistNameField).sendKeys("My New Smart Playlist Group");
    }

    public void selectOptionFromSecondPlaylist() {
        WebElement secondPlaylistOption = driver.findElement(secondDropList);
        Select dropListOp = new Select(secondPlaylistOption);
        dropListOp.selectByVisibleText("begins with");
        findElement(smartPlOptionsNameField).sendKeys("k");
        //List<WebElement> options=dropListOp.getOptions();
        //System.out.println("Number of options in a drop down: "+options.size());
    }

    public void clickNewRuleBtn() {
        findElement(newRuleBtn).click();
    }

    public void selectOptionFromSecondPlaylistRule2() {
        WebElement secondPlaylistOption = driver.findElement(secondDrpListRule2);
        Select dropListOp = new Select(secondPlaylistOption);
        dropListOp.selectByVisibleText("contains");
        findElement(smartPlOptionsNameFieldRule2).sendKeys("b");
        //List<WebElement> options=dropListOp.getOptions();
        //System.out.println("Number of options in a drop down: "+options.size());
    }

    public void selectOptionFromSecondPlaylistGroupRule2() {
        WebElement secondPlaylistOption = driver.findElement(secondDrpListGroupRule2);
        Select dropListOp = new Select(secondPlaylistOption);
        dropListOp.selectByVisibleText("begins with");
        findElement(smartPlOptionsNameFieldRule3).sendKeys("d");
        //List<WebElement> options=dropListOp.getOptions();
        //System.out.println("Number of options in a drop down: "+options.size());
    }


    public void clickSaveBtn() {
        findElement(saveBtn).click();
    }

    public String isSuccessMsdDisplayed() {
        return findElement(successMsg).getText();
    }

}