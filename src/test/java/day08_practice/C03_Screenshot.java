package day08_practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_Screenshot extends TestBase {
    @Test
    public void test01() throws IOException {
    // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");

        try {
            driver.findElement(By.xpath("//div[@id='ins-editable-button-1580496494']")).click();
        } catch (Exception e) {
            System.out.println("cookies cikmadi");
        }

        // arama cubuguna oppo yazip enter'a basınız
        driver.findElement(By.id("search-input")).sendKeys("oppo", Keys.ENTER);

    // sonuc yazısını yazdiriniz
        System.out.println(driver.findElement(By.xpath("//*[@class='plp-panel-block1']")).getText());

    // ilk urunun fotografını cekin
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class=' prd '])[1]"));

        File kayit = new File("target/ekranGoruntusu/urun.jpeg");   // fotografi nereye kaydetmek istiyorsak o dosyayi yarattik
        File gecicidosya = ilkUrun.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(gecicidosya,kayit);   // gecicidosyaya kaydettigimiz fotoyu kayit objesi ile belirttigimiz dosyaya kopyaladik




    }
}
