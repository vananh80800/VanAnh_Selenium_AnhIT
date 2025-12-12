package Buoi13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrangeHRM_JSExecutor {
    public static void main(String[] args) throws Exception{
        //1.Khởi tạo trình duyệt
        WebDriver  driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2.Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //3.Mo trang Login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //Lấy element
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));

        //Khoi tạo js
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Demo javascript excutor
        //Highlight user name:
        js.executeScript("arguments[0].style.border = '3px solid red'", username);

        //Nhập username bằng js:
        //js.executeScript("arguments[0].value='Admin';", username);
        js.executeScript("arguments[0].value='Admin'; arguments[0].dispatchEvent(new Event('input', {bubbles: true}));", username);

        //Highlight password
        js.executeScript("arguments[0].style.border = '3px solid red'", password);
        js.executeScript("arguments[0].value='admin123'; arguments[0].dispatchEvent(new Event('input', {bubbles: true}));", password);

        //Click bằng javas
        js.executeScript("arguments[0].click();", loginButton);

        //Lấy tiêu đề trang bằng js
        String tieuDe = (String)js.executeScript("return document.title;");
        System.out.println(tieuDe);

        //Scroll xuống cuối trang
        Thread.sleep(2000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        //Lấy URL trang dashboard
        String url = (String)js.executeScript("return document.URL;");
        System.out.println("Dashboard URL (JS): " + url);

        driver.quit();

    }
}
