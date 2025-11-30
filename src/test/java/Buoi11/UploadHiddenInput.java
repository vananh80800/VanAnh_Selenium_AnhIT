package Buoi11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UploadHiddenInput {
    public static void main(String[] args) throws InterruptedException{
        //Khởi tạo driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Mở trang web upload
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        //Đường dẫn file cần upload
        String filePath = "C:\\Users\\vanhv\\OneDrive\\Hình ảnh\\Saved Pictures\\337390479_241915291590214_4577869236999805489_n.jpg";

        //Đây là input upload thật nhưng bị ẩn
        WebElement hiddenInput =driver.findElement(By.xpath("//input[@type='file']"));

        //1.Hiện input lên = JavaScript( bỏ display:none hoặc opacity:0)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].style.display='block';" +
                        "arguments[0].style.opacity=1;" +
                        "arguments[0].style.visibility='visible';" +
                        "arguments[0].style.height='auto';" +
                        "arguments[0].style.width='auto';",
                hiddenInput
        );

        Thread.sleep(1000);

        //2.Upload bằng sendKeys
        hiddenInput.sendKeys(filePath);

        System.out.println("Upload file thành công");

        Thread.sleep(2000);
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
