package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By userNameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By loginBtnLocator = By.cssSelector("#login  button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void setUserName(String username){
        driver.findElement(userNameLocator).sendKeys(username);
    }
    public void setPassWord(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }
    //Despues de dar en el boton Login nos enviara a otra pagina, esta debe ser retornada, y sera otra clase
    public SecureAreaPage loginSubmit(WebDriver driver){
        driver.findElement(loginBtnLocator).click();
        return new SecureAreaPage(driver);
    }
}
