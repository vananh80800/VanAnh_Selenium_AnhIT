package Buoi6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Dropdown_Status {
    public static void main(String[] args) throws  InterruptedException{
        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Mở trang đăng nhập OrangeHRM
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

        // Đăng nhập
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()=' Login ']"));

        userName.sendKeys("Admin");
        password.sendKeys("admin123");
        loginButton.click();
        Thread.sleep(3000);

        // Chuyển sang menu Admin
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        Thread.sleep(3000);

        // Mở dropdown "Status"
        WebElement userRoleDropdown = driver.findElement(By.xpath("//label[text()='Status']/parent::div/following-sibling::div/div"));
        userRoleDropdown.click();
        Thread.sleep(1000);

        // Chọn item "Enabled"
        WebElement adminOption = driver.findElement(By.xpath("//div[@role='option']//span[text()='Enabled']"));
        adminOption.click();
        Thread.sleep(1000);

        // Lấy text hiện tại trong dropdown sau khi chọn
        String selectedText = userRoleDropdown.getText();
        System.out.println("Giá trị hiển thị sau khi chọn: " + selectedText);

        //So sánh kết quả mong đợi
        String expectedText = "Enabled";
        System.out.println("Giá trị mong đợi: " + expectedText);
        Assert.assertTrue(selectedText.contains(expectedText), "Giá trị trong dropdown không đúng");
    }
}
