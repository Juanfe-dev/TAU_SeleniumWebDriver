package alert;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {



    @Test
    public void testAcceptAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.JsBtn_acceptAlert();
        assertEquals(alertsPage.getResult(),
                "You successfully clicked an alert",
                "Result text incorrect");
    }

    @Test
    public void testGetTextFromAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.JsBtn_dismissAlert();
        assertEquals(text ,
                "I am a JS Confirm");
    }

    @Test
    public void textSetTextOnPrompt(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        String text = alertsPage.alert_getText();
        alertsPage.setTextField("mazamorra");
        alertsPage.JsBtn_acceptAlert();
        assertEquals(alertsPage.getResult() ,"You entered: mazamorra");
    }

}
