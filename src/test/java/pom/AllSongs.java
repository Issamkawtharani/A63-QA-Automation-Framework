package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class AllSongs extends BasePage {

    int idCount = 0;

    public AllSongs(WebDriver givenDriver) {
        super(givenDriver);
    }

    By allSongsBtn = By.xpath("//a[normalize-space()='All Songs']");
    By allSongsCount = By.xpath("//table[@class='items']//tr");
    By allSongsCountDisplay = By.xpath("//span[contains(text(),'66 songs • 04:32:57')]");
    By listOfId = By.xpath("//tr//td[1]");

    public void clickAllSongsBtn() {
        findElement(allSongsBtn).click();
    }

    public int allSongsNumber() {
        return driver.findElements(allSongsCount).size();
    }

    public String isAllSongsCountDisplay() {
        return findElement(allSongsCountDisplay).getText();
    }

    public List<WebElement> allSongsIdDisplayed() {
        return driver.findElements(listOfId);
    }

    public int idCountTotal() {
        for (WebElement op : allSongsIdDisplayed()) {
            if (!Objects.equals(op.getText(), "")) {
                idCount++;
            }
        }
        return idCount;
    }

}