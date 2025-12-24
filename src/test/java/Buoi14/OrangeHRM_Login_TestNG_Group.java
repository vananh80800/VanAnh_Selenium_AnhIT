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

public class OrangeHRM_Login_TestNG_Group {
    WebDriver driver;
    WebDriverWait wait;

    //Khai bao before Method
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    //Login success
    @Test(groups = {"smoke"})
    public void testLoginSuccess() {
        //Nhap username
        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        userName.sendKeys("Admin");

        //Nhap pass
        WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        pass.sendKeys("admin123");

        //Click login button
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginButton.click();

        //Chờ Dashboard hien thi
        WebElement dashboardTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));

        //Assert thong tin
        Assert.assertTrue(dashboardTitle.isDisplayed(), "Login that bai, dashboard khong hien thi");
        System.out.println("Login Success");
    }

    //Login fail
    @Test(groups = {"regression"})
    public void testLoginFailed() {
//        // Cho login page load xong hẳn
//        wait.until(ExpectedConditions.presenceOfElementLocated(
//                By.xpath("//div[contains(@class,'orangehrm-login-container')]")
//        ));

        //Nhap username
        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        userName.sendKeys("Admin");

        //Nhap pass
        WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        pass.sendKeys("admin1234");

        //Click login button
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginButton.click();

        //Assert error message xuat hien
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(normalize-space(.), 'Invalid credentials')]")));

        Assert.assertTrue(errorMsg.isDisplayed(), "Regression test failed: Khong thay message loi");

        System.out.println("Regression test passed: Login fail dung nhu mong doi");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
