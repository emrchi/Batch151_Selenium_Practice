package day03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_CheckBox {


    //checkbox butonlarda tüm checkbox seceneklerini isaretleyebiliriz

    // https://demo.guru99.com/test/radio.html adresine gidin
    // checkbox elementlerini locate edin
    // checkbox1 ve checkbox3  secili degil ise secin
    // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
    // checkbox2 elementinin secili olmadıgını test edin

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/radio.html");
        Thread.sleep(1500);
        WebElement checkBox1 = driver.findElement(By.id("vfb-6-0"));
        WebElement checkBox2 = driver.findElement(By.id("vfb-6-1"));
        WebElement checkBox3 = driver.findElement(By.id("vfb-6-2"));
        if(!checkBox1.isSelected()){
            checkBox1.click();
            Thread.sleep(1500);
        }
        if(!checkBox3.isSelected()){
            checkBox3.click();
            Thread.sleep(1500);
        }
        Assert.assertTrue(checkBox1.isSelected() && checkBox3.isSelected());
        Assert.assertFalse(checkBox2.isSelected());
    }

    @After
    public void tearDown() throws Exception {
        //driver.close();
    }
}
