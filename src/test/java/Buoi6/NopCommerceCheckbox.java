package Buoi6;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class NopCommerceCheckbox {
    public static void main(String[] args) throws InterruptedException {
        //Mở trình duyệt
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //mở trình duyệt toàn màn hình

        //Mở trang web lên
        driver.get("https://demo.nopcommerce.com/register");

        //Lấy phần tử checkbox
        WebElement newsletterCheckbox = driver.findElement(By.xpath("//input[@id='NewsLetterSubscriptions_0__IsActive']"));

        //Scroll chậm để nhìn thấy
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 8 ; i++ ) { //scroll 8 lần
            js.executeScript("window.scrollBy(0, 150)");//mỗi lần 150px
            Thread.sleep(300);  // dừng 0.3s mỗi lần
        }

        //Đảm bảo phần tử nằm trong khung hình
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", newsletterCheckbox);
        Thread.sleep(1000);

        //Tick checkbox nếu chưa tick
        if(!newsletterCheckbox.isSelected()){
            newsletterCheckbox.click();
            System.out.println(" Checkbox 'Newsletter' đã được tick");
        }else{
            System.out.println(" Checkbox 'Newsletter' đã tick sẵn ");
//           newsletterCheckbox.click();
        }

        //Xác minh
        Assert.assertTrue(newsletterCheckbox.isSelected(), "Checkbox chưa được chọn");
        //Mong muốn là trả về true: đúng khi checkbox được chọn => đúng thì in câu lệnh trạng thái
        //nếu checkbox chưa được chọn show msg lỗi
        System.out.println("Trạng thái checkbox" + newsletterCheckbox.isSelected());
    }
}
