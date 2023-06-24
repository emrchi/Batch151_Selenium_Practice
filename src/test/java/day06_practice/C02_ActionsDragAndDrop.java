package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ActionsDragAndDrop extends TestBase {
    @Test
    public void test01() {

        // https://demoqa.com/droppable adresine gidiniz
        driver.get("https://demoqa.com/droppable");

        // 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz
        Actions actions = new Actions(driver);
        WebElement DragMe = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement DropHere = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        actions.dragAndDrop(DragMe,DropHere).perform();

        // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz
        Assert.assertEquals("Dropped!",DropHere.getText());
    }
}
