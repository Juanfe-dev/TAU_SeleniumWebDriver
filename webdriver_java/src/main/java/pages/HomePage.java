package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Clase para todos los elementos del HomePage

public class HomePage {

    private WebDriver driver;
    // private By formAuthenticationLink = By.linkText("Form Authentication"); No lo usamos ya a partir del cap 4.3
    public HomePage(WebDriver driver){
        //CONSTRUCTOR
        this.driver = driver;
    }

    /** Para el capitulo 4.3 no usaremos esta manera de dar click sino que
     * crearemos un metodo para dar clic a cualquiera link text, el cual pide
     * como parametro el texto del link a la hora de invocar este metodo, lo
     * llamaremos clickLink();
     *  public LoginPage clickFormAuthentication(){
        driver.findElement(formAuthenticationLink).click();
        return new LoginPage(driver);
    } */
    public LoginPage clickFormAuthentication() {
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }
    public HoversPage clickHovers(){
        clickLink("Hovers");
        return new HoversPage(driver);
    }
    public DropdownPage clickDropdown(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }
    public KeyPressesPage clickKeyPresses(){
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }
    public HorizontalSliderPage clickHorizontalSlider(){
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    public AlertsPage clickJavaScriptAlerts(){
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }

    public FileUploadPage clickUploadFile(){
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }
    public ContextMenuPage clickContextMenu(){
        clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }
    public WYSIWYGEditorPage clickWYSIWYGEditor(){
        clickLink("WYSIWYG Editor");
        return new WYSIWYGEditorPage(driver);
    }
    private void clickLink(String linktext){
        driver.findElement(By.linkText(linktext)).click();
    }
}
