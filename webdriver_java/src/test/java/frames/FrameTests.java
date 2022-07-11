package frames;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testWYSIWYGEditor(){
        var editorPage = homePage.clickWYSIWYGEditor();
        String text1 = "Hello";
        String text2 = " World";

        //        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        editorPage.clearTextArea();
        assertEquals(editorPage.getTextFromTextArea(),"", "No esta vacio pa");
        editorPage.setTextArea(text1);
        editorPage.increaseIdent();
        editorPage.setTextArea(text2);

        assertEquals(editorPage.getTextFromTextArea(),
                text1 + text2,
                "Text from edit incorrect");

    }
}
