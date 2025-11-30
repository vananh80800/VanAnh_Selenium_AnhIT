package Buoi11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadByRobot {
    public static void main(String[] args) throws InterruptedException, AWTException {
        //Khởi tạo driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Mở trang web upload
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        //Tìm nút upload (nút custom)
        WebElement uploadButton = driver.findElement(By.xpath("//span[text()='Add files...']/parent::span"));
        uploadButton.click();

        Thread.sleep(5000);

        //Đường dẫn file
        String filePath = "C:\\Users\\vanhv\\OneDrive\\Hình ảnh\\Saved Pictures\\337390479_241915291590214_4577869236999805489_n.jpg";

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
        Thread.sleep(4000);

        // Lấy tên file hiển thị
        WebElement displayedFileNameElement = driver.findElement(By.xpath("//p[@class='name']"));
        String actualFileName = displayedFileNameElement.getText();

        // Lấy tên file từ đường dẫn
        String expectedFileName = filePath.substring(filePath.lastIndexOf("\\") + 1);

        // So sánh bằng Assert (TestNG)
        Assert.assertEquals(actualFileName, expectedFileName, "Tên tệp không khớp");

        System.out.println("Tên tệp khớp");

        driver.quit();
    }
}
