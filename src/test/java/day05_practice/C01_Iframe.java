package day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Iframe extends TestBase {

    //Benim yaptigim Sekilde
    @Test
    public void test01() {
        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(3);

        // Videoyu izlemek icin Play tusuna basiniz
        driver.switchTo().frame(0);
        WebElement play = driver.findElement(By.xpath("//*[@class= 'ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        play.click();
        bekle(3);

        // videoyu durdurunuz
        WebElement pause = driver.findElement(By.xpath("//*[@class= 'video-stream html5-main-video']"));
        pause.click();
        bekle(3);

        // videoyu tam ekran yapınız
        actions.moveToElement(pause).doubleClick().perform();
        bekle(3);

        // videoyu calıstırınız
        actions.moveToElement(pause).click().perform();
        bekle(3);

        // videoyu kucultunuz
        actions.moveToElement(pause).doubleClick().perform();
        bekle(3);

        // videoyu durdurunuz
        actions.moveToElement(pause).click().perform();
        bekle(3);

        // Videoyu calistirdiginizi test ediniz
        WebElement youtubeLogosu = driver.findElement(By.xpath("//*[@class= 'ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeLogosu.isDisplayed());

        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();
        WebElement yazi = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(yazi.isDisplayed());
    }
    //burak Hocanin Yaptigi Sekilde
    @Test
    public void Test02() throws InterruptedException {

        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz

        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/x3kfyZJhC3U?rel=0&showinfo=0']"));
        driver.switchTo().frame(iframe);
        /*
        play'i dogru locate edip click yapmamıza ragmen videoyu calıstırmadı.
        Bunun üzerine HTML kodlarını inceleyince Play'in aslında bir iframe icerisinde oldugunu gördük
        Bu durumda önce iframe locate edip sonra switchTo() ile iframe'e gecmeliyiz
         */
        WebElement playTusu = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        playTusu.click();
        Thread.sleep(3000);

        // videoyu durdurunuz
        WebElement videoDurdur = driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
        videoDurdur.click();
        Thread.sleep(3000);

        // videoyu tam ekran yapınız
        WebElement tamEkran = driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']"));
        tamEkran.click();
        Thread.sleep(3000);

        // videoyu calıstırınız
        videoDurdur.click();
        Thread.sleep(3000);

        // videoyu kucultunuz
        tamEkran.click();
        Thread.sleep(3000);

        // videoyu durdurunuz
        videoDurdur.click();

        // Videoyu calistirdiginizi test ediniz
        WebElement youTubeYazisi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youTubeYazisi.isDisplayed());

        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();

        WebElement yazi = driver.findElement(By.xpath("//h1[text()='jQuery Flexy Plugin Demos']"));
        Assert.assertTrue(yazi.isDisplayed());


    }
}
