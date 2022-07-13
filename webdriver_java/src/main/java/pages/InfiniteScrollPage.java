package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {

    private WebDriver driver;
    By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Scrolls until paragraph with index specified is in view
     * @param index 1-based
     */
    public void scrollToParagraph(int index){
        //Codigo JavaScript
        //Hace scroll hasta la altura del body
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        //Declaro el ejecutador del script JavaScript
        var jsExecutor =(JavascriptExecutor)driver;

        while(getNumberOfParagraphsPresent() < index){
            //Ejecuto el script
            jsExecutor.executeScript(script);
        }
    }
    public int getNumberOfParagraphsPresent(){
        return driver.findElements(textBlocks).size();
    }

}
