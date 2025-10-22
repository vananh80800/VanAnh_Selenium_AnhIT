import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDemo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); //tự động tải driver về
        WebDriver driver = new ChromeDriver(); //mở trình duyệt chrome

        driver.get("https://anhitsolutions.com/"); //truy cập trang web

        System.out.println("Tiêu đề trang:" +driver.getTitle());
    }
}