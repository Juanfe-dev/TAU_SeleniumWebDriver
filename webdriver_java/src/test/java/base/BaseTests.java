package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseTests {

    //Intancio el driver
    private WebDriver driver;

    public void setUp(){
        //Asignamos propiedades al driver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        // driver.get("https://the-internet.herokuapp.com/");

        /** Experimentemos con diferentes opciones para la ventana
        Maximizar
        driver.manage().window().maximize();
        Fullscreen
        driver.manage().window().fullscreen();
        Resolucion personalizada
        driver.manage().window().setSize(new Dimension(390, 844)); */

        /** A diferencia del curso de QualityStream aqui en vez declarar el localizador como miembro de clase
         * lo hacen como miembro de metodo
         */

        /**findElements en plural ya que buscaremos varias etiquetas "a" y crearemos una lista
        List<WebElement> links = driver.findElements(By.tagName("a"));
        //Imprimimos la cantidad de links que hay
        System.out.println(links.size());
         */

        /**Clic en un elemento que no exite "CualquierCosa" --> Falla el test
         * Excepcion: org.openqa.selenium.NoSuchElementException (MUY COMUN)
         *
        WebElement notExistElement = driver.findElement(By.linkText("CualquierCosa"));
        notExistElement.click();
         */

        /**Clic en inputs
        WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
        inputsLink.click();
         */

        /** TAREA: Chapter 2
         * En la web que estamos trabajando, ir a "Shifting Content>Example 1: Menu Element" y
         * decir cuantos elementos de el menu que aparece ahi hay
         *
         *         SOLUCION:
         *
         *         driver.get("https://the-internet.herokuapp.com/shifting_content/menu");
         *         List<WebElement> menuLinks = driver.findElements(By.tagName("li"));
         *         System.out.println(menuLinks.size());
         * */

        System.out.println(driver.getTitle());
        //driver.quit();
    }

    //Creamos el main para correr el programa
    public static void main(String[] args){
        BaseTests test = new BaseTests();
        test.setUp();
    }

}
