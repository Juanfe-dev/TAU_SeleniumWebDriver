package contextmenu;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testContextMenu(){
        var cMenuPage = homePage.clickContextMenu();
        cMenuPage.focusBox();
        assertEquals(cMenuPage.getContextMenuText(), "You selected a context menu");
        cMenuPage.confirmContextMenuAlert();
    }
}
