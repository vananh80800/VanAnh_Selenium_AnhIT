package Buoi9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class iFrameByWebElementDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Mở trang anhIt
        driver.get("https://anhitsolutions.com/contact");

        //Lấy trang iframe bằng WebElement
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@title='YouTube video player']"));

        //Switch vào iframe bằng WebElement
        driver.switchTo().frame(iframeElement);

        //Tìm nút play bằng Xpath
        WebElement playButton = driver.findElement(By.xpath("//button[contains(@class,'ytp-large-play-button')]"));

        //Click Play
        playButton.click();

        //Chờ cho video chạy
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){}

        //Quay lại trang chính
        driver.switchTo().defaultContent();

        //Click khóa học
//        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Khoá học']")).click();

        Thread.sleep(3000);
        driver.quit();
    }
}
