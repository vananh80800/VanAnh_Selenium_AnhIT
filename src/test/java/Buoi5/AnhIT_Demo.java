package Buoi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AnhIT_Demo {
    public static void main(String[] args) throws InterruptedException{
        //khởi tạo trình duyệt
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize(); //mở trình duyệt toàn màn hình

        //Mở trang web lên
        driver.get("https://anhitsolutions.com/login");
        Thread.sleep(2000);

        //Nhập dữ liệu user name và mật khẩu
        //1.Khai báo biến element xpath
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));

        //Nhập dữ liệu
        userName.sendKeys("vananh80800@gmail.com");
        password.sendKeys("123123");

        //Click login button
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        Thread.sleep(2000);

        //Click cài đặt
        driver.findElement(By.xpath("//span[text()='Cài đặt']")).click();

        WebElement email =  driver.findElement(By.xpath("//input[@name='email']"));
        String actualEmail =  email.getAttribute("value");
        String exprctedEmail = "vananh80800@gmail.com";

        if(actualEmail.equals(exprctedEmail)){
            System.out.println("TC PASSED:" + " " + actualEmail);
        }else{
            System.out.println("TC FAILED:" + " "+ actualEmail);
        }
    }
}
