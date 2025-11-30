package Buoi8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic_Auth1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://anhit-user:anhit@2025@anhitsolutions.cloud/");

         Thread.sleep(2000);//Chờ trang load

    }
}
