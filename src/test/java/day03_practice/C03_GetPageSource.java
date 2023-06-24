package day03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_GetPageSource {

    // https://www.amazon.com/ adresine gidin
    // Kaynak Kodlarini konsola yazdiriniz
    // Kaynak Kodlarinda "Gateway" yazdigini test edin

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getPageSource());
        Assert.assertTrue(driver.getPageSource().contains("Gateway"));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
