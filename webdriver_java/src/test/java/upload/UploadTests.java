package upload;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UploadTests extends BaseTests {

    @Test
    public void testUploadFile(){
        var uploadFileObject = homePage.clickUploadFile();
        //Subiremos el archivo Chromedriver.exe que esta en el directorio del proyecto resources
        uploadFileObject.uploadFile("C:\\Users\\jgomez\\Documents\\CampusSC\\IntellijWorkspace\\testautomationuniversity\\webdriver_java\\resources\\chromedriver.exe");
        assertEquals(uploadFileObject.getFileUpdate(),"chromedriver.exe");
    }

}
