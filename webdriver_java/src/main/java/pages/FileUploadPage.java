package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {

    private WebDriver driver;
    private By inputField = By.id("file-upload");
    private By uploadBtn = By.id("file-submit");
    //Localizador de la pagina despues de subir el archivo
    private By fileUploaded = By.id("uploaded-files");


    public FileUploadPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickUploadBtn(){
        driver.findElement(uploadBtn).click();
    }
    //Metodo para no usar la ventana de subir archivo sino generar la ruta absoluta de este en local
    public void uploadFile(String absolutePathOfFile){
        driver.findElement(inputField).sendKeys(absolutePathOfFile);
        clickUploadBtn();
    }

    public String getFileUpdate(){
    return driver.findElement(fileUploaded).getText();
    }



}
