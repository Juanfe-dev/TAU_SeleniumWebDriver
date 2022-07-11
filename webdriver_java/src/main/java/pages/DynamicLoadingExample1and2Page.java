package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class DynamicLoadingExample1and2Page {

    private WebDriver driver;

    public DynamicLoadingExample1and2Page(WebDriver driver){
        this.driver = driver;
    }
    private By example1BtnLocator = By.xpath(" //a[contains(text(),'Example 1: Element on page that is hidden')]");
    private By example2BtnLocator = By.xpath(" //a[contains(text(),'Example 2: Element rendered after the fact')]");

    public DynamicLoadingExample1Page clickExample1(){
        driver.findElement(example1BtnLocator).click();
        return new DynamicLoadingExample1Page(driver);
    }
    public DynamicLoadingExample2Page clickExample2(){
        driver.findElement(example2BtnLocator).click();
        return new DynamicLoadingExample2Page(driver);
    }
}
