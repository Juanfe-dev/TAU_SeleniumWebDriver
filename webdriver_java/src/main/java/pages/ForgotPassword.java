package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/** NO PUDE TERMINAR LA TAREA YA QUE EL LINK EN LA WEB DE PRUEBA ESTA CAIDO

public class ForgotPassword {

    private By emailField = By.id("email");
    private By retrievePasswordSubmitBtn = By.id("form_submit");
    private WebDriver driver;

    public ForgotPassword(WebDriver driver){
        this.driver = driver;
    }

    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public SecureAreaPage loginSubmit(){
        driver.findElement(retrievePasswordSubmitBtn).click();
        return new SecureAreaPage(driver);
    }
}
*/