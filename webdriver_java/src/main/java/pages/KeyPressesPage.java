package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {

    private By inputField = By.id("target");
    private By resultText = By.id("result");
    private WebDriver driver;
    public KeyPressesPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterText(String text){
        driver.findElement(inputField).sendKeys(text);
    }
    public String getResult(){
        return driver.findElement(resultText).getText();
    }
    //Presionaremos Shift + 3, con el metodo Chord
    public void enterHashTag(){
       enterText(Keys.chord(Keys.SHIFT , "3" ) + " = HashTag");
    }
}
