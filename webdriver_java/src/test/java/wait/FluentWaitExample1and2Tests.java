package wait;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample1and2Page;

import static org.testng.Assert.assertEquals;

public class FluentWaitExample1and2Tests extends BaseTests {

    @Test
    public void testExample1(){
        var dinamicExamples = homePage.clickDynamicLoadingExample1and2();
        var example1 = dinamicExamples.clickExample1();

        example1.clickStartBtn();
        example1.waitFinalMessage();
        assertEquals(example1.getFinalMessage(),
                "Hello World!",
                "Final Message not found");
    }

    @Test
    public void testExample2(){
        var dinamicExamples = homePage.clickDynamicLoadingExample1and2();
        var example2 = dinamicExamples.clickExample2();

        example2.clickStartBtn();
        example2.waitFinalMessage();
        assertEquals(example2.getFinalMessage(),
                "Hello World!",
                "Final Message not found");
    }
}
