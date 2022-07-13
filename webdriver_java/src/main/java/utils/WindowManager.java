package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver){
        this.driver = driver;
        //Agregamos esto el constructor
        navigate = driver.navigate();
    }

    //Metodo para retroceder un item en el historial del navegador
     public void goBack(){
        navigate.back();
     }
    //Metodo para avanzar un item en el historial del navegador
     public void goFoward(){
        navigate.forward();
     }
     //Refrescar pagina
     public void refreshPage(){
        navigate.refresh();
     }
     //Ir a pagina
     public void goTo(String url){
        navigate.to(url);
    }
     //Cambiar de pestaña
    public void switchToTab(String tabTitle){
        //.getWindowHandles() retorna todos los handles de las
        //ventanas o pestañas abiertas
        var windows = driver.getWindowHandles();

        System.out.println("Number of tabs " + windows.size());
        System.out.println("Window handles: ");
        windows.forEach(System.out::println);

        //Primera iteracion: switch a la primera ventana
        //... a la segunda ventana
        //etc...
        for (String window : windows){
            System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);

            System.out.println("Current window title: " + driver.getTitle());

            if(tabTitle.equals(driver.getTitle())){
                break;
            }
        }
    }
}
