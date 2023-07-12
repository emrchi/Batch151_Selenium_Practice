package day08_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FilesDownload extends TestBase {

    // 'https://the-internet.herokuapp.com/download' adresine gidiniz
    // some-file.txt dosyasini indirelim
    // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz


    @Test
    public void test01() {
        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
        bekle(2);

        //Dosyayi indirmeden ayni dosya yoluna sahip dosya varsa klasorden silelim ki hep ayni dosya olmasin klasorde

        File silinecekDosya = new File("C:\\Users\\emres\\Downloads\\some-file.txt");
        silinecekDosya.delete();

        // some-file.txt dosyasini indirelim
        WebElement text = driver.findElement(By.xpath("//*[text()='some-file.txt']"));
        text.click();

        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz
        //"C:\Users\emres\Downloads\some-file.txt"
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\some-file.txt";
        String dosyaYolu = farkliKisim + ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
