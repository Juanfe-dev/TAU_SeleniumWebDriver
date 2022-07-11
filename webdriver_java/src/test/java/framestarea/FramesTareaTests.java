package framestarea;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FramesTareaTests extends BaseTests {

    @Test
    public void testFrames(){
        var framesTareaPage = homePage.clickFramesTarea();
        var nestedFramesPage = framesTareaPage.clickNestedFramesPage();

        nestedFramesPage.switchToUpFrame();
        nestedFramesPage.switchToUpLeftFrame();
        assertEquals(nestedFramesPage.getBodyText(), "LEFT");
        nestedFramesPage.switchToGeneralFrame();
        nestedFramesPage.switchToBottomFrame();
        assertEquals(nestedFramesPage.getBodyText(), "BOTTOM");
    }

}
