package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {

    private WebDriver driver;
    private By boxArea = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
    }

     public void focusBox(){
        Actions actions = new Actions(driver);
        WebElement figure = driver.findElement(boxArea);
        actions.moveToElement(figure).perform();
        actions.contextClick(figure).perform();
    }

    public String getContextMenuText(){
        return driver.switchTo().alert().getText();
    }

    public void confirmContextMenuAlert(){
        driver.switchTo().alert().accept();
    }



}
