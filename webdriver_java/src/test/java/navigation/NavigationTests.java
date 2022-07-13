package navigation;

import base.BaseTests;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTests {

    @Test
    public void  testNavigator(){
        homePage.clickDynamicLoadingExample1and2().clickExample1();
        //El siguiente metodo esta en el BaseTests y fue creado alli para manipular la ventana
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goFoward();
        getWindowManager().goTo("https://www.google.com");
    }

    @Test
    public void testSwitchTab(){
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
    }

}
