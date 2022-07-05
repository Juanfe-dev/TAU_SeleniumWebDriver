package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {

    //Intancio el driver
    private WebDriver driver;

    public void setUp(){
        //Asignamos propiedades al driver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        //Experimentemos con diferentes opciones para la ventana
        //Maximizar
        //driver.manage().window().maximize();
        //Fullscreen
        //driver.manage().window().fullscreen();
        //Resolucion personalizada
        driver.manage().window().setSize(new Dimension(390, 844));


        System.out.println(driver.getTitle());
        //driver.quit();
    }

    //Creamos el main para correr el programa
    public static void main(String[] args){
        BaseTests test = new BaseTests();
        test.setUp();
    }

}
