package dropdown;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTest extends BaseTests {

    @Test
    public void testSelectOption(){
        var dropDownPage = homePage.clickDropdown();
        String option = "Option 1";
        dropDownPage.selectFromDropdown(option);
        var selectedOptions = dropDownPage.getSelectedOptions();

        assertEquals(selectedOptions.size(),
                1,
                "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");
    }

}
