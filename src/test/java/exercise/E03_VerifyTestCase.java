package exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class E03_VerifyTestCase extends TestBase {

    @Test
    public void test01() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//*[@class='logo pull-left']"));
        Assert.assertTrue(logo.isDisplayed());

        //4. Click on 'Test Cases' button
        WebElement testCaseButton = driver.findElement(By.xpath ("//*[text()=' Test Cases']"));
        testCaseButton.click();
        driver.navigate().back();
        driver.navigate().forward();

        //5. Verify user is navigated to test cases page successfully
        String expectedURL = "https://automationexercise.com/test_cases";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,actualURL);

        WebElement textUp = driver.findElement(By.xpath("//*[@class='title text-center']"));
        WebElement textDown = driver.findElement(By.xpath("//*[@class='pull-left']"));
        assert textUp.isDisplayed() && textDown.isDisplayed();

    }
}
