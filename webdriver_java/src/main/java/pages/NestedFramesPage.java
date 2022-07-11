package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {

    private WebDriver driver;


    //LOCALIZADORES DE LOS FRAMESETS
    //SUBGRUPO SUPERIOR DEL GENERAL
    //Retorna el locator del tag body dentro del frame que este
    private By bodyTag = By.tagName("body");
    //Localizador del frame superior dentro del defaultContent (html general)
    private String topFrameLocator = "frame-top";
    //Localizador del frame LEFT del frame superior dentro del general
    private String leftFrameLocator = "frame-left";
    //Localizador del frame Bottom inferior dentro del general
    private String bottomFrameLocator = "frame-bottom";

    public NestedFramesPage(WebDriver driver){
        this.driver = driver;
    }

    //Y con esto salimos del frame y hacemos el cambio al frame padre (Buenas practicas)
    public void switchToGeneralFrame(){
        driver.switchTo().defaultContent();
    }

    public void switchToUpLeftFrame(){
        driver.switchTo().frame(leftFrameLocator);
    }
    public void switchToBottomFrame(){
        driver.switchTo().frame(bottomFrameLocator);
    }
    public void switchToUpFrame(){
        driver.switchTo().frame(topFrameLocator);
    }
    public String getBodyText(){
        return driver.findElement(bodyTag).getText();
    }


}
