package exercise1SeleniumBasics;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KatalongE2E {

    @Test
    public void KatalongAppointment() {

        EdgeDriver edgeDriver = new EdgeDriver();
        String URL = "https://katalon-demo-cura.herokuapp.com/";
        edgeDriver.get(URL);
        edgeDriver.manage().window().maximize();
        String title = edgeDriver.getTitle();
        System.out.println(title);
        //Verify title page
        Assert.assertEquals(title, "CURA Healthcare Service");
        edgeDriver.findElement(By.id("menu-toggle")).click();
        edgeDriver.findElement(By.xpath("//a[text() =\"Login\"]")).click();
        String username = edgeDriver.findElement(By.xpath("//input[@aria-describedby=\"demo_username_label\"]")).getText();
        System.out.println(username);
        String password = edgeDriver.findElement(By.cssSelector("input[aria-describedby=\"demo_password_label\"]")).getText();
        System.out.println(password);
        edgeDriver.findElement(By.cssSelector("input[id=\"txt-username\"]")).sendKeys("John Doe");

        edgeDriver.findElement(By.cssSelector("input[id=\"txt-password\"]")).sendKeys("ThisIsNotAPassword");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        edgeDriver.findElement(By.cssSelector("button[id=\"btn-login\"]")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement dropdown = edgeDriver.findElement(By.id("combo_facility"));
        dropdown.click();
        Select select = new Select(dropdown);
        select.selectByValue("Hongkong CURA Healthcare Center");

        WebElement checkBox = edgeDriver.findElement(By.cssSelector("input[name=hospital_readmission]"));
        boolean isEnabled = checkBox.isEnabled();

        if (isEnabled == true) {
            checkBox.click();
        }
        WebElement Medicaid = edgeDriver.findElement(By.cssSelector("input[value=\"Medicaid\"]"));
        boolean medicaid = Medicaid.isSelected();
        if (medicaid == false) {
            Medicaid.click();

        }
        WebElement calender = edgeDriver.findElement(By.cssSelector("div[class=\"input-group-addon\"]"));
        calender.click();

        WebElement date = edgeDriver.findElement(By.xpath("//div[@class=\"datepicker-days\"]/table/tbody//td[text() = \"19\"]"));
        date.click();
        edgeDriver.findElement(By.cssSelector("textarea[name=\"comment\"]")).sendKeys("Test");
        edgeDriver.findElement(By.id("btn-book-appointment")).click();

        String pagetitle = edgeDriver.findElement(By.xpath("//h2[text()=\"Appointment Confirmation\"]")).getText();

        Assert.assertEquals(pagetitle, "Appointment Confirmation");


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        edgeDriver.quit();


    }


}
