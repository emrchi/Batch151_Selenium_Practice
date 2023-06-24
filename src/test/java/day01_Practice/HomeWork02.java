package day01_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWork02 {
    // "https://teknosa.com/" adresine gidiniz
    // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
    // Title'in "Teknoloji" kelimesini icerip icermedigini kontrol ediniz
    // URL'in "teknosa" kelimesini icerip icermedigini kontrol ediniz
    // "https://medunna.com/" adresine gidiniz
    // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
    // Title'in "MEDUNNA" kelimesini icerip icermedigini kontrol ediniz.
    // URL'in "medunna" kelimesini icerip icermedigini kontrol ediniz
    // teknosa adresine geri donunuz
    // Sayfayı yenileyiniz
    // medunna adresine ilerleyiniz
    // Sayfayı yenileyiniz
    // pencereyi kapat

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // "https://teknosa.com/" adresine gidiniz
        driver.get("https://teknosa.com/");
        Thread.sleep(1000);
        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        System.out.println(title);
        System.out.println(url);
        // Title'in "Teknoloji" kelimesini icerip icermedigini kontrol ediniz
        if(title.contains("Teknoloji")){
            System.out.println("Title Teknoloji kelimesini iceriyor.");
        }else System.out.println("Test Failed");
        // URL'in "teknosa" kelimesini icerip icermedigini kontrol ediniz
        if(url.contains("teknosa")){
            System.out.println("Url teknosa kelimesini iceriyor.");
        }else System.out.println("Test Failed");
        // "https://medunna.com/" adresine gidiniz
        driver.get("https://medunna.com/");
        Thread.sleep(1000);
        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        String titleMedduna = driver.getTitle();
        String urlMedduna = driver.getCurrentUrl();
        System.out.println(titleMedduna);
        System.out.println(urlMedduna);
        // Title'in "MEDUNNA" kelimesini icerip icermedigini kontrol ediniz.
        if(titleMedduna.contains("MEDUNNA")){
            System.out.println("Title Medunna kelimesini iceriyor.");
        }else System.out.println("Test Failed");
        // URL'in "medunna" kelimesini icerip icermedigini kontrol ediniz
        if(urlMedduna.contains("medunna")){
            System.out.println("Url medunna kelimesini iceriyor.");
        }else System.out.println("Test Failed");
        // teknosa adresine geri donunuz
        driver.navigate().back();
        Thread.sleep(1000);
        // Sayfayı yenileyiniz
        driver.navigate().refresh();
        Thread.sleep(1000);
        // medunna adresine ilerleyiniz
        driver.navigate().forward();
        Thread.sleep(1000);
        // Sayfayı yenileyiniz
        driver.navigate().refresh();
        Thread.sleep(1000);
        // pencereyi kapat
        driver.close();
    }
}
