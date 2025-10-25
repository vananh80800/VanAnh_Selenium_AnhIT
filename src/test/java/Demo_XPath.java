import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_XPath {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); //tự động tải driver về
        WebDriver driver = new ChromeDriver(); //mở trình duyệt chrome

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //truy cập trang web

        //Dùng XPath để kiểm tra username và password'
        sleep(1000);
//        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
    }

    public static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
