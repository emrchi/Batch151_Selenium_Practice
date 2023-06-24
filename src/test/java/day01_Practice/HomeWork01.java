package day01_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWork01 {

    // "https://www.amazon.com/" adresine gidiniz.
    // "https://www.n11.com/" adresine gidiniz.
    // amazon adresine geri donunuz
    // n11 adresine ilerleyiniz
    // sayfayi yenileyiniz
    // pencereyi kapat
    // Konsola "HER ŞEY YOLUNDA" yazdir

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // "https://www.amazon.com/" adresine gidiniz.
        driver.get("https://www.amazon.com/");
        Thread.sleep(1000);
        // "https://www.n11.com/" adresine gidiniz.
        driver.get("https://www.n11.com/");
        Thread.sleep(1000);
        // amazon adresine geri donunuz
        driver.navigate().back();
        Thread.sleep(1000);
        // n11 adresine ilerleyiniz
        driver.navigate().forward();
        Thread.sleep(1000);
        // sayfayi yenileyiniz
        driver.navigate().refresh();
        Thread.sleep(1000);
        // pencereyi kapat
        driver.close();
        // Konsola "HER ŞEY YOLUNDA" yazdir
        System.out.println("HER ŞEY YOLUNDA");
    }
}
