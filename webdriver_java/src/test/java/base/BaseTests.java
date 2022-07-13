package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import javax.imageio.IIOException;
import javax.xml.transform.Result;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseTests {

    //Intancio el driver
    //private WebDriver driver;
    private EventFiringWebDriver driver; //DEPRECATED
    protected HomePage homePage;
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }
    @BeforeClass
    public void setUp(){
        //Asignamos propiedades al driver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new EventReporter());
        goHome();
        /** Tests Chapter 4.1: */
        homePage = new HomePage(driver);

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
    }
    @AfterMethod
    public void takeScreenshot(ITestResult result){
        //Hay que hacer el casteo para trabajar con selenium
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        //Para la siguiente Files importaremos el commons de google en vez del javaio
        //Asignamos de directorio el screenshots
        //Ya que el .move tira excepcion hacemos un wrap en un trycatch
        try {
            Files.move(screenshot, new File("resources/screenshots/passes/"+result.getName()+"Passed.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/failures/"+result.getName()+"Failed.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    /** Una vez puestas las anotaciones de TestNG no necesitamos un metodo MAIN
    //Creamos el main para correr el programa
    public static void main(String args[]){
        BaseTests test = new BaseTests();
        test.setUp();
    }*/

    //Metodo para la clase 11 de Window.Navigation
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
}
