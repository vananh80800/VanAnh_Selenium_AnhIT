package Buoi11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class UploadBySendKeys {
    public static void main(String[] args) throws InterruptedException{
        //Khởi tạo driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Mở trang web upload
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        //Đường dẫn file tuyệt đối
        String filePath = "C:\\Users\\vanhv\\OneDrive\\Hình ảnh\\Saved Pictures\\337390479_241915291590214_4577869236999805489_n.jpg";

        //Nhiều đường dẫn
//        String filePath = "C:\\Users\\vanhv\\OneDrive\\Hình ảnh\\Saved Pictures\\337390479_241915291590214_4577869236999805489_n.jpg\nC:\\Users\\vanhv\\OneDrive\\Hình ảnh\\Ảnh chụp màn hình\\2022-07-11.png";

        //Tìm input upload file
        WebElement uploadInput = driver.findElement(By.xpath("//input[@type='file']"));

        //Upload file bằng sendKeys()
        uploadInput.sendKeys(filePath);

        Thread.sleep(5000);

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