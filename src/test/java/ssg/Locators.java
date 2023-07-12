package ssg;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Locators extends TestBase {
    @Test
    public void locatorsTesti() {

        //https://www.kitapyurdu.com/ adresine gidilir.
        driver.get("https://www.kitapyurdu.com/");
        bekle(2);

        //“En Çok Satılanlar” bölümündeki ilk ürünü seçiniz.
        List<WebElement> enCokSatilanlarListesi = driver.findElements(By.className("pr-details"));
        String enCokSatanKitapIsmi = enCokSatilanlarListesi.get(0).getText().split("\n")[0];
        enCokSatilanlarListesi.get(0).click();
        bekle(2);

        //Seçilen ürüne ait sayfanın açıldığını doğrulayınız.

        String kitapAdi = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(enCokSatanKitapIsmi, kitapAdi);

        //“Devamını Oku…” butonuna basınız.
        WebElement devaminiOku = driver.findElement(By.partialLinkText("Devam"));
        devaminiOku.click();
        bekle(2);

        //Ürünü sepete ekleyiniz.
        WebElement sepeteEklemeButonu = driver.findElement(By.id("button-cart"));
        sepeteEklemeButonu.click();
        bekle(2);

        //Sepete gidiniz.
        WebElement sepetinizLinki = driver.findElement(By.linkText("sepetinize"));
        sepetinizLinki.click();
        bekle(2);

        //Ürüne ait kontrol kutusunu işaretleyiniz.
        WebElement kontrolKutusu = driver.findElement(By.name("cart_selection[]"));
        Assert.assertFalse(kontrolKutusu.isSelected());
        if(!kontrolKutusu.isSelected()){
            kontrolKutusu.click();
        }
        Assert.assertTrue(kontrolKutusu.isSelected());

        //Ürün miktarını değiştiriniz.
        WebElement urunMiktarKutusu = driver.findElement(By.name("quantity"));
        Assert.assertEquals("1",urunMiktarKutusu.getAttribute("value"));
        urunMiktarKutusu.clear();
        urunMiktarKutusu.sendKeys("3");
        Assert.assertEquals("3",urunMiktarKutusu.getAttribute("value"));

    }
}
        /*
        LOCATORS:

Selenium'da locatorlar 8 tanedir. Driver objesinden bir web element'in adresini bir methodla bulmasini isteriz.
Locator: Driver objesine web elementin adresini tarif etme yontemi

Genellikle id ve name unique olur.
className ise bir grubu ifade eder. Ornegin yazar isimleri var. Bu isimlerin tumu developer tarafindan bir class
icerisinde toplanir. Bir class ile cok sayida weblement bicimlendirilmis olur. Amacimiz unique bir degeri almak degil
bir class degerini almak ise locate alirken class attribute'unu kullaniriz.

Ilk urune tiklamamiz istenirse ilk urunu tek basina almamiz dogru olmaz. Cunku yarin bu ilk urun degismis olabilir. Urunleri
bir liste koyarsak urunler degistiginde dahi list icerisinde degisen dahil olmak uzere tum urunleri arayabiliriz.

TagName genellikle unique olmaz. Ayni taga sahip webelementleri bir seferde alabiliriz. Sinif olarak deger almak
istedigimizde class'da oldugu gibi tagName'i kullanabiliriz.

Linklerin tagi a tagidir. a tagi icerinde ornegun Giris Yap text'ini gorduk. Bu, linke ait text demektir. Bunu linkText
ya da partialLinkText ile alabiliriz. linkText'de textin tamamini, partialLinkText'de tamami ya da bir parcasini alabiliriz.

a tagi ile olusturulmus her webelement'de bir text yani link olmayabilir.

Test Görevi:
1-https://www.kitapyurdu.com/ adresine gidiniz.
 driver.get() methodunu kullanarak web sitesine gittik.

2-"En Çok Satılanlar" bölümündeki ilk ürünü seçiniz.
En cok satilanlar baslikli kisimda ilk urunun resmi ya da ismini alarak locate yapmamaliyiz. Cunku ilk urun degisebilir.
Bu nedenle bu urunlerin class ismini almak dogru olur. Ilk urunun adi uzerinde inspect yaptik ve attribute'u class degeri pr-details
olan kismi almaya karar verdik. Bunun uzerinde iken urunun uzeri mavi secili idi. pr-details'i aldik

driver.FindElements methodu icersine className ile locate'imizi yazdik. Bunu bir liste assign ettik. Tum urunler bir list icerisine alinmis oldu.
bir sout yazarak listemizde 0.inci indexte ne var ne yok baktik. Cantamdan Fil Cikti ve Mert Arik oldugunu gorduk. Ancak bize baslik kismi lazim ve bunu almamiz gerekir.
Cunku daha sonra baslik kismini dogrulamamiz gerekecek
Listelerde olan get() methodunu kullandik. index olarak 0'i yazdik
get(0).click(); Bu bize ilk urunu verir. Ilk urun degisse dahi bu yontemle bir problem olmayacak.

 3-Seçilen ürüne ait sayfanın açıldığını doğrulayınız.
 List'imizin 0.inci indexindeki basligi almamiz gerekir. Bunun icin split methodunu kullaniriz. anCokSatilanlarListesi.get(0).getText().split("\n")---> Bu satirdan bolme yapacak,
 [0] olarak indexi alinca ilk satiri aliriz.
 Bunu biz bir String'e assign ettik. Assertion icerisinde actual olarak kullanacagiz.
 console'da ilk urun ile ilgili veri iki satir halinde idi. Bize yazar ismi degil urun ismi lazim oldugundan ve urun ismi ilk satirda oldugundan ilk satiri aliriz.
 urun basligi icin h1 tagi kullanildigini HTML kodlarinda gorduk. //h1 yapinca unique oldugunu gorduk. Aslinda h1 tagi genelde class'i bir grubu ifade eder. Burada unique
 WebElement kitapAdi=driver.findElement(By.tagName("h1")); //kitap adinin tagi h1 Bunu assertion icersinde expected olarak yazacagiz.
 Assertion yaparken equals methodunu kullandik ve actual ile expected kitap adlarini karsilastirdik.


 4-"Devamını Oku…" butonuna basınız.
 Bu yazinin locate'ini aldik ve click methodu ile isteneni yaptik. devamini oku yazisinin text olarak yazildigini gorduk. PartialLinkText ile locate'i aldik. HTML kod sayfasinda
 sadece Devamini kismini yazdik. Bunun unique olmadigini gorduk. Kodda arama yapinca script tagi icerisinde ikinci kez kullanildigini gorduk. Script icersinde oldugu icin
 sorun olmadigini dusunduk. Kodu calistirdigimizda bir problem olmadi.

 5-Ürünü sepete ekleyiniz.
 sepete ekleme butonunun locate'ini aldik. a tagi icersinde id attribute'unu kullandik. id degeri button-chart. 4 tane oldugunu gorduk. tek tek otekileri kontrol ettik. Bunu # ile
 kontrol ettik. button basina # yazinca nerelerde ayni button ve degeri olduguna baktik. Problem olmayacagini dusunduk. click methodu ile ekleme yapmis olduk.


 6-Sepete gidiniz.
 sepetinizde weblementine tiklayinca ekranda Cantamdan Fil Cikti sepetinize eklendi yazisi cikti bunu handle etmek icin onun da locate'ini almamiz gerekecek. Bunun icin bu yazi cikar cikmaz
 HTML kod sayfasinda Elements kisminda olsak da Sources kismina tiklayip oradan ucgen sekilli pause kismina tiklayinca iki kisa cubuga donusan pause kismi ile ekrani dondurmus oluruz ve biz
 acik halde olan sonradan cikan kisma bu sayede mudahale edebiliriz.
 sepetinizde weblementinin lokate'ini linkText ile aldik ve click methodunu kullandik.


 7-Ürüne ait kontrol kutusunu işaretleyiniz.
 urun kontrol kutusunun locate'ini name locator'i ile aldik ve assertion yaptik. urun henuz secili olmadigi icin ya assertFalse(urunKontrolKutusu.isSelected());
 ya da assertTrue(!urunKontorlKutusu.isSleceted()); ile assertion yapariz ve secili degilse sectimek icin bir if statement olusturduk.


 8-Ürün miktarını değiştiriniz.
 Urun miktari kutucugunda 1 yazili. Biz bir urun sectik cunku. Onun uzerine gidip locate'ini name locator'i ile aldik.quantity miktara isaret ediyor.
 Assertion yaparken expected urun miktari 1 ve actual miktar da 1 ise testimiz gececek. actual miktari getAttribute() methodu ile belirledik.
 value attribute'unde miktar deger olarak verilmis. Bu nedenle getAttribute(value) yazdik ve bunu assertion yaparken kullandik.
 Urun miktarini degistirmek icin sendKeys methodunu kullandik. Ancak miktar kutucugu icerisinde baska bir miktar varsa karisiklik olmasin diye once clear() methdounu kullanarak
 o miktari sildik ve istedigimiz miktari ekledik.
         */