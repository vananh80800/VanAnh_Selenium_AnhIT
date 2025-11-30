package Buoi10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Set;

public class SwitchByIDDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //Mở trang
        driver.get("https://demo.nopcommerce.com/");

        //Lưu lại ID tab cha
        String parentID = driver.getWindowHandle();

        //Click mở tab mới
        driver.findElement(By.xpath("//a[@href='https://www.youtube.com/user/nopCommerce']")).click();

        //Lấy tất cả windowm/tabs
        Set<String> allWindows = driver.getWindowHandles();

        //Chuyển sang tab mới bằng cách so sánh ID
        for (String winID : allWindows) {
            if (!winID.equals(parentID)) {
                driver.switchTo().window(winID);
                break;
            }
        }
        Thread.sleep(2000);
        System.out.println("Title tab mới: " + driver.getTitle());

        //Đóng tab mới
        driver.close();

        //Chuyển lại tab cha
        driver.switchTo().window(parentID);
        System.out.println("Title tab cha: " + driver.getTitle());
        driver.quit();
    }
}
