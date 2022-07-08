import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.*;

public class SliderTests extends BaseTests {

    @Test
    public void testMoveSliderToRight(){
        var sliderPage = homePage.clickHorizontalSlider();
        sliderPage.clickRightArrow(8);
        assertEquals(sliderPage.sliderPosition(), "4");
    }
}
