package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesTareaPage {

    private WebDriver driver;
    //Locator del link Nested Frames
    private By nestedFramesLocator = By.cssSelector("a[href='/nested_frames']");
    //private String nestedFramesLink = driver.findElement(nestedFramesLocator).getAttribute("href");

    public FramesTareaPage(WebDriver driver){
        this.driver = driver;
    }

    public NestedFramesPage clickNestedFramesPage(){
        driver.findElement(nestedFramesLocator).click();
        return new NestedFramesPage(driver);
    }
}
