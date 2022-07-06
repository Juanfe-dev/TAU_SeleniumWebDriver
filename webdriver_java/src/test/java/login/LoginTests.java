package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//Heredamos BaseTests ya que ahi ya configuramos el driver e iniciamos el programa
public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin(){
        //Objeto creado en la clase BaseTests
        //Metodo creado en la clase HomePage
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUserName("tomsmith");
        loginPage.setPassWord("SuperSecretPassword!");
        //Como el siguiente metodo retorna una pagina, instanciamos un objeto de esta clase
        SecureAreaPage secureAreaPage = loginPage.loginSubmit();
        /** En este caso el texto en el pom es muy ambiguo, procedemos a verificar con un asserttrue
         * assertEquals( secureAreaPage.getAlertText(),
                "You logged into a secure area!",
                "Alert text is incorrect"); */
        assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"));


    }
}
