package exercise1SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class TestSelenium05 {
    WebDriver webDriver = new EdgeDriver();
    String URL = "https://katalon-demo-cura.herokuapp.com/";

    public void testCura() {
        webDriver.get(URL);
        webDriver.manage().window().maximize();
        String title = "CURA Healthcare Servicea";
        //Validate page title HARD ASSERT
//        Assert.assertEquals(webDriver.getTitle(),title);

        if (webDriver.getPageSource().contains("CURA Healthcare Service")) {
            System.out.println("CURA Healthcare Service is Visible");
            Assert.assertTrue(true);


        } else {
            Assert.assertTrue(false);
        }
        webDriver.quit();


    }
}
