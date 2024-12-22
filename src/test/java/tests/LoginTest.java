package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    WebDriver driver;

    

    @BeforeEach
    public void setUp() {
        // Setup WebDriver and open the browser
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Wasri\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        // Corrected ChromeDriver path
        driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://agro.senzmate.com/login");
    }

    @Test
   public void SuccessLogin(){
    WebElement username =  driver.findElement(By.xpath("//input[@name = 'username']"));
    username.sendKeys(" usermv01");


    WebElement password =  driver.findElement(By.xpath("//input[@name = 'password']"));
    password.sendKeys("usermv0123");


   WebElement loginButton =  driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/form/button"));
   loginButton.click();


       String expectedTitle = "Ammah®";
       String actualTitle = driver.getTitle();
       if (expectedTitle.equals(actualTitle)){
           System.out.println("Actual Title same as expected");
       }else {
           System.out.println("Actual title not same as Expected");
       }


   }


   @Test
   public void IncorrectUsername(){
       WebElement incorrectUsername =  driver.findElement(By.xpath("//input[@name = 'username']"));
       incorrectUsername.sendKeys(" usermv456");


       WebElement password =  driver.findElement(By.xpath("//input[@name = 'password']"));
       password.sendKeys("usermv0123");


       WebElement loginButton =  driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/form/button"));
       loginButton.click();
   }

   

   @Test
   public void IncorrectPassword(){
       WebElement username =  driver.findElement(By.xpath("//input[@name = 'username']"));
       username.sendKeys(" usermv01");


       WebElement incorrectpassword =  driver.findElement(By.xpath("//input[@name = 'password']"));
       incorrectpassword.sendKeys("incorrect");


       WebElement loginButton =  driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/form/button"));
       loginButton.click();
   }
}