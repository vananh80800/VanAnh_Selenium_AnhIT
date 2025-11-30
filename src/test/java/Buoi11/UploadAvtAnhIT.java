package Buoi11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadAvtAnhIT {
    public static void main(String[] args) throws InterruptedException, AWTException {
        //khởi tạo trình duyệt
        WebDriver driver = new ChromeDriver();
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

        //Click hình ảnh
        driver.findElement(By.xpath("//a[@data-original-title='Hình ảnh']")).click();

        //Click button upload ảnh
        driver.findElement(By.xpath("//button[@id='selectAvatarBtn']")).click();

        Thread.sleep(5000);

        //Đường dẫn file
        String filePath = "C:\\Users\\vanhv\\Downloads\\avatar-don-gian-dep.jpg";

        //Copy đường dẫn vào clipboard
        StringSelection ss = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        //Khởi tạo robot
        Robot robot = new Robot();
        robot.setAutoDelay(500);

        //Nhấn Ctrl+V để Paste
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.setAutoDelay(500);

        //Nhấn enter để xác nhận
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //Đợi xem thao tác hoàn tất
        Thread.sleep(2000);

        //Click button lựa chọn
        driver.findElement(By.xpath("//button[text()='Lựa chọn']")).click();

        //Click update button
        driver.findElement(By.xpath("//button[@id='saveData']")).click();
        Thread.sleep(2000);

        driver.quit();

    }
}
