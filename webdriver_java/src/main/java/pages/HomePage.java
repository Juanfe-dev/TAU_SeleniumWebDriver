package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Clase para todos los elementos del HomePage

public class HomePage {

    private WebDriver driver;
    private By formAuthenticationLink = By.linkText("Form Authentication");

    public HomePage(WebDriver driver){
        //CONSTRUCTOR
        this.driver = driver;
    }

    public LoginPage clickFormAuthentication(WebDriver driver){
        driver.findElement(formAuthenticationLink).click();
        /**
         * Al dar clic en el link nos manda a otra pagina con un login, en el patron POM debemos retornar esa pagina
         * El retorno debe ir acompañado del driver ya que las paginas necesitan el driver para interactuar con el navegador
         * Como es una nueva pagina, se debe crear una clase para esta
         */
        return new LoginPage(driver);
    }


}
