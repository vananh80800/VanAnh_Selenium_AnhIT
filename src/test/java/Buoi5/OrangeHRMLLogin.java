package Buoi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrangeHRMLLogin {
    public static void main(String[] args) throws InterruptedException {
        //khởi tạo trình duyệt
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize(); //mở trình duyệt toàn màn hình

        //Mở trang web lên
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

        //Nhập dữ liệu user name và mật khẩu
           //1.Khai báo biến element xpath
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));

        //Nhập dữ liệu
        userName.sendKeys("Admin");
        password.sendKeys("admin123");

        //Click login button
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();
    }
}
