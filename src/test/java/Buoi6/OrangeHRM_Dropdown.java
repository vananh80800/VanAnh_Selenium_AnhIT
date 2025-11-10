package Buoi6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class OrangeHRM_Dropdown {
    public static void main(String[] args) throws  InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Mở trang web lên
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()=' Login ']"));



        //Nhập dữ liệu
        userName.sendKeys("Admin");
        password.sendKeys("admin123");
        loginButton.click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[text()='User Role']/parent::div/following-sibling::div/div")).click();
        driver.findElement(By.xpath("//label[text()='User Role']/parent::div/following-sibling::div/div/div/following-sibling::div//span[text()='Admin']")).click();

        Thread.sleep(1000);

        // Chọn giá trị "Admin"
        WebElement optionAdmin = driver.findElement(By.xpath("//div[@role='option']//span[text()='Admin']"));
        optionAdmin.click();
        Thread.sleep(1000);

        // Lấy text sau khi chọn
        String selectedText = driver.findElement(By.xpath("//label[text()='User Role']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")).getText();

        // So sánh kết quả
        String expected = "Admin";
        if (selectedText.equals(expected)) {
            System.out.println("✅ Dropdown chọn đúng giá trị: " + selectedText);
        } else {
            System.out.println("❌ Dropdown chọn sai. Giá trị hiện tại: " + selectedText);
        }

//        //  Lấy lại text hiển thị sau khi chọn
//        System.out.println("Giá trị đã chọn: " + selectedText);
//
//        // 6Kiểm tra (giống như assert trong ví dụ dropdown tỉnh/thành)
//        Assert.assertEquals(selectedText, expected, "Giá trị dropdown không khớp!");
//
//        System.out.println("✅ Dropdown chọn đúng giá trị: " + selectedText);
    }
}


