package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HorizontalSliderPage {

    private WebDriver driver;
    private By horizontalSlider = By.cssSelector("input[type=\"range\"");
    private By sliderResult = By.cssSelector("span[id='range']");
    public HorizontalSliderPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickRightArrow(int times){
        for(int i = 1; i <= times; i++){
            driver.findElement(horizontalSlider).sendKeys(Keys.ARROW_RIGHT);
        }
    }
    public String sliderPosition(){
        return driver.findElement(sliderResult).getText();
    }

}
