package exercise;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;

public class E02_ContactUsForm extends TestBase {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Click on 'Contact Us' button
        //5. Verify 'GET IN TOUCH' is visible
        //6. Enter name, email, subject and message
        //7. Upload file
        //8. Click 'Submit' button
        //9. Click OK button
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        //11. Click 'Home' button and verify that landed to home page successfully


    @Test
    public void test01() {
        //1. Launch browser

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//*[@class='logo pull-left']"));
        Assert.assertTrue(logo.isDisplayed());
        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[@class='fa fa-envelope']")).click();
        //5. Verify 'GET IN TOUCH' is visible
        WebElement text = driver.findElement(By.xpath("//*[text()='Get In Touch']"));
        Assert.assertTrue(text.isDisplayed());
        //6. Enter name, email, subject and message
        Faker faker = new Faker();
        WebElement name = driver.findElement(By.xpath("(//*[@class ='form-control'])[1]"));
        name.sendKeys(faker.name().name(), Keys.TAB, "fdshjxclxn@gmail.com", Keys.TAB,faker.address().country(),Keys.TAB,faker.howIMetYourMother().quote());
        //7. Upload file
        WebElement chooseFile = driver.findElement(By.xpath("(//*[@class='form-control'])[5]"));
        String dosyaYolu = "C:\\Users\\emres\\Downloads\\C01_Odev.java";
        chooseFile.sendKeys(dosyaYolu);
        //8. Click 'Submit' button
        WebElement submit = driver.findElement(By.xpath("(//*[@class='form-group col-md-12'])[4]"));
        submit.submit();
        //9. Click OK button
        driver.switchTo().alert().accept();
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement text2 = driver.findElement(By.xpath("//*[@class='status alert alert-success']"));
        Assert.assertTrue(text2.isDisplayed());
        //11. Click 'Home' button and verify that landed to home page successfully
        WebElement home = driver.findElement(By.xpath("//*[@class='fa fa-angle-double-left']"));
        home.click();
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='aswift_1']"));
        driver.switchTo().frame(iframe);
        try {
            driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
        } catch (Exception e) {
            System.out.println("Kucuk reklam penceresi var");
        }
        try {
            WebElement ad = driver.findElement(By.xpath("//*[@id='ad_iframe']"));//kucuk reklam frame'i
            driver.switchTo().frame(ad);
            driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
        } catch (Exception e) {
            System.out.println("Kucuk reklam penceresi yok");
        }

        String expectedURL = "https://automationexercise.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,actualURL);


    }
}
