package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class DynamicLoadingExample1Page {

    private WebDriver driver;
    private By startBtnLocator = By.xpath("//div[@id='start']/button");
    private By loadingLocator = By.id("loading");
    private By finalMessageLocator = By.id("finish");

    public DynamicLoadingExample1Page(WebDriver driver){
        this.driver = driver;
    }
    public void clickStartBtn(){
        driver.findElement(startBtnLocator).click();
    }
    public void waitFinalMessage(){
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingLocator)));
    }
    public String getFinalMessage(){
        return driver.findElement(finalMessageLocator).getText();
    }
}
