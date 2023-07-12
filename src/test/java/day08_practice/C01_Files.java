package day08_practice;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_Files {

    // masaustunde bir text dosyası olusturunuz
    // masaustunde text dosyasının olup olmadıgını test ediniz

    @Test
    public void test01() {
        // masaustunde bir text dosyası olusturunuz

        // masaustunde text dosyasının olup olmadıgını test ediniz
        // "C:\Users\emres\OneDrive\Desktop\Batch151.txt"

        //Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\emres\\OneDrive\\Desktop\\Batch151.txt")));

        //Yukarida ki dosya yolunu dinamik hale getirelim

        // "C:\Users\emres\OneDrive      \Desktop\Batch151.txt"
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\OneDrive\\Desktop\\Batch151.txt";

        String dosyaYolu = farkliKisim + ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
