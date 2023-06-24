package exercise;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class E05_SearchProduct extends TestBase {
    @Test
    public void test01() throws IOException {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean status = js.executeScript("return document.readyState").toString().equals("complete");
        Assert.assertTrue(status);

        //4. Click on 'Products' button
        WebElement productButton = driver.findElement(By.xpath("//*[text()=' Products']"));
        productButton.click();
        driver.navigate().back();
        driver.navigate().forward();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts = driver.findElement(By.xpath("//*[@class='title text-center']"));
        Assert.assertTrue(allProducts.isDisplayed());

        //6. Enter product name in search input and click search button
        driver.findElement(By.xpath("//*[@class='form-control input-lg']")).sendKeys("dress",Keys.TAB,Keys.ENTER);

        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchProducts = driver.findElement(By.xpath("//*[@class='title text-center']"));
        Assert.assertTrue(searchProducts.isDisplayed());

        //8. Verify all the products related to search are visible
        List<WebElement> products = driver.findElements(By.xpath("//*[@class='product-overlay']"));
        for (WebElement w: products){
            Assert.assertTrue(w.isDisplayed());
            System.out.println(w.getText());
        }

        //Take a screenShot
             /*
        -İlk olarak SS aldığımızda nereye kaydetmek istiyorsak oranın yolunu belirtelim
        -İkinci olarak TakesScreenShot arayüzünden obje oluştururuz
        -Üçüncü olarak FileUtils class'ından copyFile() methodu ile ts objemizi kullanarak getScreenShotAs methodu ile
        dosya yolunu belirteceğiz
            */
        String dosyayolu = "src/test/java/screenShots/screenShot.png";
        TakesScreenshot tss = (TakesScreenshot) driver;
        FileUtils.copyFile(tss.getScreenshotAs(OutputType.FILE), new File(dosyayolu));
    }
}
