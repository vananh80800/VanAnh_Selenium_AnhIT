package Buoi12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrangeHRM_FullWaitDemo {
    public static void main(String[] args) throws Exception{
        //1.Khởi tạo trình duyệt
        WebDriver  driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2.Implicit wait(Chờ theo thời gian mặc định)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //3.Mo trang Login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //4.Explicit wait(chờ theo điều kiện)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Code chuc nang Login
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        username.sendKeys("Admin");
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        password.sendKeys("admin123");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginButton.click();
    }
}
