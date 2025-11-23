package Buoi7;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrangeHRM_Radio {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        loginButton.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='My Info']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[text()='Female']/span")).click();



        //=================Thao tac Radio button voi JS==========================
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement radio = driver.findElement(By.xpath("//label[text()='Male']/span"));
        js.executeScript("arguments[0].click();", radio);
    }
}
