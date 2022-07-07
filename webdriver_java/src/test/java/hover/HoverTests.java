package hover;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HoverTests extends BaseTests {

    @Test
    public void testHoverUser1(){
        //En el home damos clic en hovers link
        var hoversPage =  homePage.clickHovers();
        //nos paramos en el hover 1
        var caption = hoversPage.hoverOverFigure(1);

        //Hacemos las comprobaciones
        //Se desplego?
        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        //El titulo es correcto?
        assertEquals(caption.getTitle(),
                "name: user1",
                "Caption tittle incorrect");
        //El linkText es correcto?
        assertEquals(caption.getLinkText(),
                "View profile",
                "Caption link text incorrect");
        //El link es correcto? usamos endsWith ya que en el pom no se ve el link completo, solo el final
        assertTrue(caption.getLink().endsWith("/users/1"),
                "Caption link incorrect");
    }
}
