package exercise1SeleniumBasics;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium02 {

    @Test
    public void test (){
        EdgeDriver edgeDriver =new EdgeDriver();
        //get url
        edgeDriver.get("https://app.vwo.com/#/login");

        System.out.println(edgeDriver.getCurrentUrl());
        //Assert the URL validation testng assertion
        Assert.assertEquals(edgeDriver.getCurrentUrl(), "https://app.vwo.com/#/login");
        edgeDriver.close();

    }

}
