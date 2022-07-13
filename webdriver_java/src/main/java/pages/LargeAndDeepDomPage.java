package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage {

    private WebDriver driver;
    private By table = By.id("large-table");

    public LargeAndDeepDomPage(WebDriver driver){
        this.driver = driver;
    }

    public void scrollToTable(){
        //Encontrar la tabla
        WebElement tableElement = driver.findElement(table);
        //Llamada del codigo JavaScript
        String script = "arguments[0].scrollIntoView();";
        //Ejecutador de codigo JavaScript de selenium
        //Casteo
        ((JavascriptExecutor)driver).executeScript(script, tableElement);
    }

}
