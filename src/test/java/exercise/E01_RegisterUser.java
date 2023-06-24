package exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class E01_RegisterUser {
    /*
    Test Case 1: Register User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */

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
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePagePicture = driver.findElement(By.xpath("//*[@class='logo pull-left']"));
        Assert.assertTrue(homePagePicture.isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //5. Verify 'New User Signup!' is visible
        WebElement newUser = driver.findElement(By.xpath("(//H2)[3]"));
        Assert.assertTrue(newUser.isDisplayed());
        //6. Enter name and email address
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Emre",Keys.TAB,"emretdjj@gmail.com");
        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//*[@class='btn btn-default'])[2]")).click();
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='title text-center'])[1]")).isDisplayed());
        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("(//div[@class='radio'])[1]")).click();
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("emytrfhhj@12",Keys.TAB,"28",Keys.TAB,"july",Keys.TAB,"1980");
        //10. Select checkbox 'Sign up for our newsletter!'
        //driver.findElement(By.xpath("(//*[@class='checkbox'])[1]")).click();
        //Thread.sleep(5000);
        //11. Select checkbox 'Receive special offers from our partners!'
        //driver.findElement(By.xpath("//*[@id='optin']")).click();
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[@id='first_name']")).
                sendKeys("Emre",Keys.TAB,"Sallabaci",Keys.TAB,"TechPro",Keys.TAB,
                        "Akcakoca yurt",Keys.TAB,"blok:25",Keys.TAB,"Canada",Keys.TAB,
                        "Ankara",Keys.TAB,"Ankara",Keys.TAB,"06258",Keys.TAB,"5557458585",Keys.TAB,Keys.ENTER);
        //14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b")).isDisplayed());
        //15. Click 'Continue' button
        //driver.findElement(By.xpath("//*[@class='ns-lz2pf-e-21']")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        //16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b")).isDisplayed());
        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//b")).isDisplayed());
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

    }
}
