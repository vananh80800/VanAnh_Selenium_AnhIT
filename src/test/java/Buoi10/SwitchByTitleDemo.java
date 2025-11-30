package Buoi10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Set;

public class SwitchByTitleDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://demo.nopcommerce.com/");

        // Lưu lại Window cha
        String parentID = driver.getWindowHandle();

        //Click mô tả tab mới
        driver.findElement(By.xpath("//a[@href='https://www.youtube.com/user/nopCommerce']")).click();
        driver.findElement(By.xpath("//a[@href='https://www.facebook.com/nopCommerce']")).click();

        Thread.sleep(2000);
        //Title bạn muốn chuyển đến
        String expectedTitle = "nopCommerce - Youtube";

        //Lấy tất cả tabs
        Set<String> allWindows = driver.getWindowHandles();

        //Lập qua từng tab và kiểm tra title
        for (String winID : allWindows) {
            driver.switchTo().window(winID);
            if (driver.getTitle().equals(expectedTitle)) {
                break;
            }
        }

        System.out.println("Đã chuyển đến tab có Title: " + driver.getTitle());

        boolean status = closeAllWindowsWithoutParent(driver, parentID);
        System.out.println("Chỉ còn tab cha: " + status);

        Thread.sleep(2000);
        // Click 1 phần tử ở tab cha
        driver.findElement(By.xpath("//a[text()='Apparel']")).click();

        Thread.sleep(3000);

        driver.quit();
    }

    public static boolean closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();

        for (String windowID : allWindows) {
            if (!windowID.equals(parentID)) {
                driver.switchTo().window(windowID);
                driver.close(); // đóng tab con
            }
        }

        // Chuyển về tab cha
        driver.switchTo().window(parentID);

        if (driver.getWindowHandles().size() == 1)
            return true;
        else
            return false;
    }
}