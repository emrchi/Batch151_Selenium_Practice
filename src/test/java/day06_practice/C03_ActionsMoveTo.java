package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C03_ActionsMoveTo extends TestBase {
    @Test
    public void test01() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String ilksayfaHandle = driver.getWindowHandle();

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        WebElement dilSec = driver.findElement(By.xpath("//*[@class='icp-nav-link-inner']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dilSec).perform();
        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("//*[@class='icp-mkt-change-lnk']")).click();
        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm = driver.findElement(By.xpath("//*[@class='a-native-dropdown a-spacing-top-medium-plus a-declarative']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");
        actions.sendKeys(Keys.ESCAPE).perform();

        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//*[@class='a-button-input']")).click();

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        Set<String> windowHandles = driver.getWindowHandles();

        String ikincisayfaHandle = "";
        for(String handle : windowHandles){
            if(!handle.equals(ilksayfaHandle)){
                ikincisayfaHandle = handle;
            }
        }
        driver.switchTo().window(ikincisayfaHandle);
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Elektronik"));
    }
}
