package Buoi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BTVN {
    public static void main(String[] args) throws InterruptedException {
        //khởi tạo trình duyệt
        WebDriver driver = new FirefoxDriver();
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

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement name = driver.findElement(By.xpath("//input[@name='full_name']"));
        WebElement phone = driver.findElement(By.xpath("//input[@name='mobile']"));
        WebElement languageDropdown = driver.findElement(By.xpath("//select[@name='language']"));


        // Xóa dữ liệu cũ và nhập dữ liệu mới
        name.clear();
        name.sendKeys("Nguyen Van Anh");

        phone.clear();
        phone.sendKeys("0912345678");

        email.clear();
        email.sendKeys("vananh80800@gmail.com");

        Select langSelect = new Select(languageDropdown);
        langSelect.selectByVisibleText("Vietnamese");

        String actualEmail = email.getAttribute("value");
        String exprctedEmail = "vananh80800@gmail.com";
        if (actualEmail.equals(exprctedEmail)) {
            System.out.println("TC PASSED:" + " " + actualEmail);
        } else {
            System.out.println("TC FAILED:" + " " + actualEmail);
        }


        String actualName = name.getAttribute("value");
        String expectedName = "Nguyễn Vân Anh"; // <-- chỉnh lại theo tên thật trên hệ thống
        if (actualName.equals(expectedName)) {
            System.out.println("Tên PASSED: " + actualName);
        } else {
            System.out.println("Tên FAILED: " + actualName);
        }


        String actualPhone = phone.getAttribute("value");
        String expectedPhone = "0978913089"; // <-- chỉnh theo dữ liệu thật
        if (actualPhone.equals(expectedPhone)) {
            System.out.println("Điện thoại PASSED: " + actualPhone);
        } else {
            System.out.println("Điện thoại FAILED: " + actualPhone);
        }


        String actualLanguage = langSelect.getFirstSelectedOption().getText();
        String expectedLanguage = "Vietnamese"; // <-- chỉnh theo giá trị thực tế trong dropdown
        if (actualLanguage.equals(expectedLanguage)) {
            System.out.println("Ngôn ngữ PASSED: " + actualLanguage);
        } else {
            System.out.println("Ngôn ngữ FAILED: " + actualLanguage);
        }

        driver.findElement(By.xpath("//button[@id='saveData']")).click();
        Thread.sleep(3000);

        //Click giới thiệu
        driver.findElement(By.xpath("//a[@data-original-title='Giới thiệu']")).click();

        WebElement tieuSu = driver.findElement(By.xpath("//textarea[@name='about']"));
        WebElement tieuDe = driver.findElement(By.xpath("//textarea[@name='bio']"));

        // Xóa dữ liệu cũ và nhập dữ liệu mới
        tieuSu.clear();
        tieuSu.sendKeys("vananh80800@gmail.com");
        tieuDe.clear();
        tieuDe.sendKeys("AnhIT_2025");

        //Click update button
        driver.findElement(By.xpath("//button[@id='saveData']")).click();
        Thread.sleep(2000);
    }
}
