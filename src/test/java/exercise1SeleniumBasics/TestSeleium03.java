package exercise1SeleniumBasics;



import org.openqa.selenium.SearchContext;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import org.testng.annotations.Test;

public class TestSeleium03 {

    @Test
    //@Description("basics learning")
    public void test3(){
        //dynamic dispatch
        SearchContext searchContext = new ChromeDriver(); //SearchContext -->Parent ; ChromeDriver--> child
        ChromiumDriver chromiumDriver = new EdgeDriver(); //SearchContext -->Parent ChromiumDriver-->Parent of Edgedriver
                                                            // USE WHEN EXECUTING ON MULTIPLE BROWSER

        EdgeDriver edgeDriver=new EdgeDriver();
        edgeDriver.get("https://app.vwo.com/#/login");
        System.out.println(edgeDriver.getTitle());
        System.out.println(edgeDriver.getCurrentUrl());
        System.out.println(edgeDriver.getPageSource());
        edgeDriver.manage().window().maximize();
        Assert.assertEquals(edgeDriver.getCurrentUrl(), "https://app.vwo.com/#/login");

        edgeDriver.quit();

    }


}
