package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {
    @Test
    public void test01() {
        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String ilksayfaHandle = driver.getWindowHandle();

        // arama motoruna 'Oppo' yazıp aratın
        WebElement aramaMotoru = driver.findElement(By.id("searchData"));
        aramaMotoru.sendKeys("Oppo", Keys.ENTER);

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]")).click();

        // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin.
        Set<String> windowHandles = driver.getWindowHandles();

        String ikincisayfaHandle = windowHandles.stream().filter(t -> !t.equals(ilksayfaHandle)).findFirst().orElse("");
        
        System.out.println("Ikinci Sayfa Handle Degeri : " + ikincisayfaHandle );
        driver.switchTo().window(ikincisayfaHandle);
        System.out.println("Ikinci Sayfa Title" + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Türkiye"));

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(ilksayfaHandle);
        System.out.println("Ilk Sayfa Title" + driver.getTitle());


    }
}
