package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WYSIWYGEditorPage {

    private WebDriver driver;

    //Debido a que el switchTo().frame(); nos pide un webelement, entero o string
    //El localizador lo guardaremos en un string para poder usarlo
    private String iframeLocator = "mce_0_ifr";
    //private String editorIframe = String.valueOf(iframeLocator);

    //Localizador de area de entrada de texto
    private By textArea = By.id("tinymce");
    //Localizador de la sangria derecha (increase ident)
    private By increaseIdentLocator = By.cssSelector("div:nth-child(5) > button:nth-child(2)");

    public WYSIWYGEditorPage(WebDriver driver){
        this.driver = driver;
    }
    //Con esto entramos al iframe y ya podriamos trabajar con el html embebido
    private void switchToEditArea(){
        driver.switchTo().frame(iframeLocator);
    }
    //Y con esto salimos del iframe y hacemos el cambio al frame padre (Buenas practicas)
    public void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
    //Entrada de texto
    //Primero limpiaremos el editor
    public void clearTextArea(){
        switchToEditArea();
        WebElement figure = driver.findElement(textArea);
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).doubleClick().perform();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    //Ingresamos Texto al area de texto
    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }
    //Clickamos en la sangria derecha (increase ident)
    public void increaseIdent(){
        switchToMainArea();
        driver.findElement(increaseIdentLocator).click();
    }
    //Ver el texto en el editor
    public String getTextFromTextArea(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }
}
