package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {

    private WebDriver driver;
    private By figureBox = By.className("figure");
    private By boxCaption = By.className("figcaption");

    public HoversPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     *
     * @param index comienza en 1: cuando inspeccionamos la lista de elementos el navegador
     *              muestra que hay 3, por lo tanto el primero tendria indice 1
     *              para corregir eso se le resta 1 a la variable index y asi la lista si se podria llenar
     *              para 3 elementos de 0 a 2, esto lo podemos ver en el metodo a continuacion.
     */
    //Parar el cursor sobre un hover
    public FigureCaption hoverOverFigure(int index){

        //Usamos findElements en plural ya que hay varios elementos que pertenencen a la clase figure
        //Y para rastrearlos haremos una lista de ellos
        WebElement figure = driver.findElements(figureBox).get(index - 1); //Asi index comienza en 0 para la lista

        //Importamos las interacciones avanzadas de selenium
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform(); //perform: llevar a cabo
        /** Aqui ya estamos parados sobre el primer Hover entonces saldria ya se
        podria ver el string name: user1 y el link
        estos estan dentro de una clase en el pom llamada figcaption
        crearemos un modelo para este tipo de elementos por buenas practicas
        el cual pueda ser usado en un futuro en otros elementos que lo requieran */

        //retorna el figcaption con el que trabajara la clase de a continuacion
        return new FigureCaption(figure.findElement(boxCaption));

    }
    //INNER CLASS!!!! sobre lo mencionado anteriormente:
    public class FigureCaption{

        /** HAY 3 CLASS = FIGURE CAPTIONS LOS CUALES TIENEN LOS MISMOS PARAMETROS, POR ESO
         * SE CREA ESTA CLASE PARA TRABAJAR CON CADA UNO DE ELLOS
          */
        private WebElement caption;
        private By header = By.tagName("h5"); //tag h5 donde esta el primer figurecaption
        private By link = By.tagName("a"); //tag a donde esta el link del primer figurecaption
        public FigureCaption(WebElement caption){
            this.caption = caption;
        }

        public boolean isCaptionDisplayed(){
            return caption.isDisplayed();
        }

        public String getTitle(){
            return caption.findElement(header).getText();
        }

        public String getLink(){
            //El link esta dentro de una etiqueta "a" bajo un atributo href
            //getattribute permite pedir el atributo href
            return caption.findElement(link).getAttribute("href");
        }

        public String getLinkText(){
            return caption.findElement(link).getText();
        }



    }


}
