package Buoi8;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Demo_alert_Cancel {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://anhit-basicform.surge.sh/");
        Thread.sleep(2000);

        //Tìm phần tử chứa chữ
        WebElement element = driver.findElement(By.xpath("//legend[text()='Submit and Reset form']"));

        //Scroll tới phần tử
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

        //Click button Arlert thông báo OK
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        Thread.sleep(2000);
        //Cancel alert
        alert.dismiss();
        Thread.sleep(500);

        // Lấy kết quả hiển thị sau khi Cancel
        String actualText = driver.findElement(By.id("result")).getText();
        String expectedText = "You clicked: Cancel";

        // Assert so sánh Actual vs Expected
        Assert.assertEquals(expectedText, actualText);

        System.out.println("ASSERT PASSED: Text hiển thị đúng sau khi Cancel!");

        driver.quit();
    }
}