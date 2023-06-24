package exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class E04_VerifyAllPruducts extends TestBase {
    @Test
    public void Test01() {
        //    1. Launch browser
        //    2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //    3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//*[@class='logo pull-left']"));
        WebElement textDown = driver.findElement(By.xpath("//*[@class='pull-left']"));
        assert logo.isDisplayed() && textDown.isDisplayed();

        //    4. Click on 'Products' button
        WebElement pruductsButton = driver.findElement(By.xpath ("//*[text()=' Products']"));
        pruductsButton.click();
        driver.navigate().back();
        driver.navigate().forward();

        //    5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement textAllProducts = driver.findElement(By.xpath("//*[text()='All Products']"));
        WebElement textDown2 = driver.findElement(By.xpath("//*[@class='pull-left']"));
        assert textAllProducts.isDisplayed() && textDown2.isDisplayed();

        //    6. The products list is visible
        List<WebElement> productslist = driver.findElements(By.xpath("//div[@class='product-overlay']"));
        for (WebElement w: productslist) {
            Assert.assertTrue(w.isDisplayed());
        }
        Assert.assertTrue(productslist.size() ==34);

        //    7. Click on 'View Product' of first product
        Actions actions =new Actions(driver);
        actions.scrollByAmount(0,500).perform();
        driver.findElement(By.xpath("(//*[text()='View Product'])[1]")).click();

        //    8. User is landed to product detail page
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/product_details/1";
        Assert.assertEquals(actualUrl, expectedUrl);

        //    9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        WebElement productName = driver.findElement(By.xpath("//*[text()='Blue Top']"));
        WebElement category = driver.findElement(By.xpath("(//p)[3]"));
        WebElement price = driver.findElement(By.xpath("//*[text()='Rs. 500']"));
        WebElement availability = driver.findElement(By.xpath("(//p)[4]"));
        WebElement condition = driver.findElement(By.xpath("(//p)[5]"));
        WebElement brand = driver.findElement(By.xpath("(//p)[6]"));
        assert productName.isDisplayed() && category.isDisplayed() && price.isDisplayed()&&
                availability.isDisplayed() && condition.isDisplayed() && brand.isDisplayed();

    }
}
