package day01_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // "https://testpages.herokuapp.com/styled/calculator" adresine gidin
        driver.get("https://testpages.herokuapp.com/styled/calculator");
        Thread.sleep(1500);

        // ilk kutucuga 20 giriniz
        driver.findElement(By.id("number1")).sendKeys("20");
        Thread.sleep(1500);

        // ikinci kutucuga 30 giriniz
        driver.findElement(By.id("number2")).sendKeys("30");
        Thread.sleep(1500);

        // calculate'e tıklayınız
        driver.findElement(By.id("calculate")).click();
        Thread.sleep(1500);

        // sonucu yazdırınız
        System.out.println("Sonuc: " + driver.findElement(By.xpath("//p//span")).getText());

        // sayfayi kapatiniz
        driver.close();

    }

}
