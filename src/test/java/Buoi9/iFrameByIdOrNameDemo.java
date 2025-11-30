package Buoi9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class iFrameByIdOrNameDemo {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://demo");

        //Switch vào iframe theo ID hoặc name
        driver.switchTo().frame("iframeResult");

        //Tương tác trong iframe
        driver.findElement(By.id("fname")).sendKeys("Hello iframe!");

        //Quay về trang chính
        driver.switchTo().defaultContent();

        driver.quit();
    }
}
