package ssg;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class GetMethods extends TestBase {
//    https://www.kitapyurdu.com/ adresine gidiniz.
//    Anasayfanın açıldığını sayfa URL’si ile doğrulayınız.
//    Anasayfanın açıldığını sayfa başlığı ile doğrulayınız.(Kitapyurdu, Kitapla buluşmanın en kolay yolu)
//    Anasayfada "Haftanın Yayınevi", "En Çok Satılanlar" ve "Ayın Yayınevleri" başlıklarının bulunduğunu doğrulayınız.
//    Üye girişi butonunun üzerindeki metnin "Giriş Yap" olduğunu doğrulayınız.
//    “Üye Ol” butonunun linkinin "https://www.kitapyurdu.com/index.php?route=account/register" olduğunu doğrulayınız.
//    En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin span tagı içerisinde olduğunu doğrulayınız.
//    En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin font ailesinin "Arial, Helvetica, sans-serif" olduğunu doğrulayınız.
//    Haftanın Yayınevi bölümündeki ilk kitabın resim genişliğinin 120, yüksekliğinin 174 olduğunu doğrulayınız.

    @Test
    public void getMethodlariTesti() {
        //Web sitesine gidilir
        driver.get("https://www.kitapyurdu.com/");

        //Url ile dogrulama yapilir
        String expectedUrl = "https://www.kitapyurdu.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        //Site sayfa basligi ile dogrulama yapilir
        String expectedTitle = "Kitapyurdu, Kitapla buluşmanın en kolay yolu";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        // Anasayfada bazı başlıkların bulunduğunun doğrulanir
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Haftanın Yayınevi"));
        Assert.assertTrue(pageSource.contains("En Çok Satılanlar"));
        Assert.assertTrue(pageSource.contains("Ayın Yayınevleri"));

        //Üye girişi butonunun üzerindeki metnin "Giriş Yap" olduğunu doğrulanir
        WebElement girisYapButtonu = driver.findElement(By.xpath("//*[@class='menu-top-button login']"));
        String girisYapText = girisYapButtonu.getText();
        Assert.assertEquals("Giriş Yap", girisYapText);

        //“Üye Ol” butonunun linkinin "https://www.kitapyurdu.com/index.php?route=account/register" olduğunu doğrulanir
        WebElement uyeOlButtonu = driver.findElement(By.linkText("Üye Ol"));
        String uyeOlLink = uyeOlButtonu.getAttribute("href");
        Assert.assertEquals("https://www.kitapyurdu.com/index.php?route=account/register", uyeOlLink);

        //En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin span tagı içerisinde olduğu doğrulanir.
        List<WebElement> enCokSatanYazarlar = driver.findElements(By.xpath("//*[@class='author line-clamp-2']"));
        for (WebElement w : enCokSatanYazarlar) {
            Assert.assertEquals("span",w.getTagName());
        }

        //En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin font ailesinin "Arial, Helvetica, sans-serif" olduğu doğrulanir.
        for (WebElement w : enCokSatanYazarlar) {
            Assert.assertEquals("Arial, Helvetica, sans-serif",w.getCssValue("font-family"));
        }

        //Haftanın Yayınevi bölümündeki ilk kitabın resim genişliğinin 120, yüksekliğinin 174 olduğu doğrulanir.
        WebElement ilkKitapResmi = driver.findElement(By.xpath("//*[@alt='Kurtuluş Günü']"));
        int resimGenisligi = ilkKitapResmi.getSize().getWidth();
        int resimYuksekligi = ilkKitapResmi.getSize().getHeight();
        Assert.assertEquals(120,resimGenisligi);
        Assert.assertEquals(174,resimYuksekligi);

    }
}
