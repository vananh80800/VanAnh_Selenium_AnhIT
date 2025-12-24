package Buoi14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRM_Login_Priority_TestNG {
    WebDriver driver;
    WebDriverWait wait;

    //Khai bao before Method
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']"))).sendKeys("Admin");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']"))).sendKeys("admin123");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
    }


    //Priority = 1 -> Kiem tra dashboard
    @Test(priority = 1)
    public void verifyDashboard() {
        //Chờ Dashboard hien thi
        WebElement dashboardTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));

        //Assert thong tin
        Assert.assertTrue(dashboardTitle.isDisplayed(), "Login that bai, dashboard khong hien thi");
        System.out.println("DASHBOARD VERIFIED");
    }

    //Priority = 2 -> Logout
    @Test(priority = 2)
    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='oxd-userdropdown-name']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']"))).click();

        WebElement btnLogout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));

        Assert.assertTrue(btnLogout.isDisplayed(), "Logout that bai");
        System.out.println("LOGOUT DONE");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
