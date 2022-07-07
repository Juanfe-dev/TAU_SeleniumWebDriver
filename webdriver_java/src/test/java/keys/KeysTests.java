package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KeysTests extends BaseTests {

    @Test
    public void testBackspace(){
        var keyPage = homePage.clickKeyPresses();
        //Usaremos una clase de selenium para ingresar una pulsacion de tecla
        // del backspace
        keyPage.enterText("A" + Keys.BACK_SPACE );

        //Verificaciones
        assertEquals(keyPage.getResult(),
                "You entered: BACK_SPACE");
    }

    @Test
    public void testHashTag(){
        var keyPage = homePage.clickKeyPresses();
        keyPage.enterHashTag();
    }


}
