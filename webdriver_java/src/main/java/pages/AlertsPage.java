package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    private WebDriver driver;

    //Locators del primer boton
    private By jsAlertBtn = By.cssSelector("button[onclick='jsAlert()']");


    //Locators del segundo boton
    private By jsConfirmBtn = By.cssSelector("button[onclick='jsConfirm()']");
    //Locators del tercer boton
    private By jsPromptBtn = By.cssSelector("button[onclick='jsPrompt()']");

    //Locator del campo de texto Result
    private By resultText = By.id("result");


    public AlertsPage(WebDriver driver){
        this.driver = driver;
    }
    //Disparador de el popup Js Alert
    public void triggerAlert(){
        driver.findElement(jsAlertBtn).click();
    }
    //Disparador de el popup Js Confirm
    public void triggerConfirm(){
        driver.findElement(jsConfirmBtn).click();
    }
    public void triggerPrompt(){
        driver.findElement(jsPromptBtn).click();
    }
    /**
     * SwitchTo(): Cambia desde el contexto actual en el DOM a algun otro.
     * Es decir de un elemento localizado a otro.
     * alert() y accept() presionan el "OK" del popup
     */
    //Clic en "ok" en el popup disparado por JS Alert Button
    public void JsBtn_acceptAlert(){
        driver.switchTo().alert().accept();
    }
    //Con el boton Confirm en vez de aceptar vamos a rechazar
    public void JsBtn_dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }
    public String getResult(){
        return driver.findElement(resultText).getText();
    }
    //Escribir en el campo de texto
    public void setTextField(String textInput){
        driver.switchTo().alert().sendKeys(textInput);
    }

}
