package Buoi8;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Demo_alert_SendKey {
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

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(1500);

        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());

        String expected = "VanAnh";
        alert.sendKeys(expected);
        alert.accept();
        Thread.sleep(2000);

        // Lấy kết quả từ trang
        WebElement result = driver.findElement(By.id("result"));
        String actual = result.getText();

        // Debug
        System.out.println("Actual: " + actual);

        // Assert
        Assert.assertTrue(actual.contains(expected), "FAIL: Actual không chứa expected.\nActual: " + actual + "\nExpected: " + expected);

        System.out.println("PASSED: Actual chứa expected.");

        driver.quit();
    }
}