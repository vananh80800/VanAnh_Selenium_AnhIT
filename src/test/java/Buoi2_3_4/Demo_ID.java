package Buoi2_3_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_ID {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); //tự động tải driver về
        WebDriver driver = new ChromeDriver(); //mở trình duyệt chrome

        driver.get("https://live.techpanda.org/index.php/customer/account/login"); //truy cập trang web

        //Tìm kiếm element email theo id sau đó nhập email tự động vào textbox
        driver.findElement(By.id("email")).sendKeys("TestDemo@gmail.com");

        //Tìm kiếm element password theo name sau đó nhập mk
        driver.findElement(By.name("login[password]")).sendKeys("123456");
    }
}
