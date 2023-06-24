package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle extends TestBase {

    @Test
    public void test01() {
        // 1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        bekle(2);

        // 2- url'in 'amazon' icerdigini test edelim
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("amazon"));
        String amazonHandle = driver.getWindowHandle();

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestbuyHandle = driver.getWindowHandle();
        bekle(2);

        // 4- title'in 'Best Buy' icerdigini test edelim
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.contains("Best Buy"));

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(amazonHandle);
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java", Keys.ENTER);
        bekle(2);

        // 6- arama sonuclarının 'Java' icerdigini test edelim
        WebElement result = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(result.getText());
        Assert.assertTrue(result.getText().contains("Java"));

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(bestbuyHandle);
        bekle(2);

        // 8- logonun gorundugunu test edelim
        WebElement logo = driver.findElement(By.xpath("(//img)[1]"));
        Assert.assertTrue(logo.isDisplayed());

    }
}
