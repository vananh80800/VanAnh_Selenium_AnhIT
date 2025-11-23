package Buoi6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class DropdownExample {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //mở trình duyệt toàn màn hình

        //Mở trang web lên
        driver.get("https://egov.danang.gov.vn/reg");

        //Tìm dropdown "Tỉnh/ thành phố" theo id
        //Tìm cái xpath của dropdown sau gán vào biến dropdownElement
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='thuongtru_tinhthanh']"));
        //Tạo 1 đối tượng là selectCity chứa xpath của dropdown tỉnh thành phố
        Select selectCity = new  Select(dropdownElement);

        //In ra tất cả giá trị trong dropdown
        List<WebElement> listCity  =  selectCity.getOptions();//khai báo 1 list tên là listCity chứa toàn bộ option của dropdown
        System.out.println("Tổng số tỉnh/thành: " +listCity.size());//In ra màn hình tổng số option
        for(WebElement element : listCity){//dùng vòng lặp for để duyệt qua từng item của list city sau đó in ra từng item. In đến hết thì dừng
            System.out.println(" - " +  element.getText());
        }

        //Kiểm tra dropdown có phải Multi-Select ko
        Assert.assertFalse(selectCity.isMultiple(),"Không được phép chọn nhiều giá trị");

        //Chọn giá trị theo visible text
        selectCity.selectByVisibleText("tỉnh Bà Rịa - Vũng Tàu");
        Thread.sleep(1000);

        //Kiểm tra lại giá trị đã chọn
        String selectedText =  selectCity.getFirstSelectedOption().getText();
        System.out.println("Giá trị đã chọn: " + selectedText);
        Assert.assertEquals(selectedText, "tỉnh Bà Rịa - Vũng Tàu");
    }
}
