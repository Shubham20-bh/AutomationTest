package exercise1SeleniumBasics;


import org.openqa.selenium.SearchContext;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestSelenium04 {
    @Test

    public void test04(){
        //dynamic dispatch
        //SearchContext searchContext = new ChromeDriver(); //SearchContext -->Parent ; ChromeDriver--> child
       // ChromiumDriver chromiumDriver = new EdgeDriver(); //SearchContext -->Parent ChromiumDriver-->Parent of Edgedriver
        // USE WHEN EXECUTING ON MULTIPLE BROWSER

        EdgeDriver edgeDriver=new EdgeDriver();
        String URL = "https://app.vwo.com/#/login";
      edgeDriver.get(URL);
        System.out.println(edgeDriver.getTitle());
        String Title= edgeDriver.getTitle();
        edgeDriver.manage().window().maximize();
        //Assertion
        Assert.assertEquals(edgeDriver.getCurrentUrl(), "https://app.vwo.com/#/login");
        assertThat(edgeDriver.getTitle()).isNotBlank().isNotEmpty().isEqualTo(Title);
        assertThat(edgeDriver.getCurrentUrl()).isEqualTo(URL);

        edgeDriver.quit();

    }
}
