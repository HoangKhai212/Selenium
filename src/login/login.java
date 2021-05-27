package login;


//import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.function.Function;


public class login {
	
	String siteUrl = "https://sqa-bhxh.web.app";
	WebDriver driver;
	JavascriptExecutor js;

	
	@BeforeEach
	public void init() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

		driver = new ChromeDriver(options);
		js = (JavascriptExecutor) driver;

		driver.get(siteUrl + "/login");
		Thread.sleep(3000);
	}
	
	@AfterEach
	public void afterTest() {
		driver.close();
	}
	
	@Test
    public void loginDisplay() {
		assertAll("Hiển thị đăng nhập",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/login")),

				() -> assertEquals("*Mã BHXH",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[1]/div/div/label/span"))
						.getText()),
				() -> assertEquals("*Mật khẩu",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[2]/div/div/label/span"))
								.getText()),
				() -> assertEquals("ĐĂNG NHẬP",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[4]/button/span[1]"))
						.getText()),
				() -> assertEquals("ĐĂNG NHẬP",
						driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/div[2]/div/div/a[1]/span[1]"))
						.getText()),
				() -> assertEquals("ĐĂNG KÝ",
						driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/div[2]/div/div/a[2]/span[1]"))
						.getText()),
				() -> assertEquals("Trang chủ",
						driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/ul/li[1]/a"))
						.getText()),
				() -> assertEquals("Đăng nhập",
						driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/ul/li[2]/a"))
						.getText()),
				() -> assertEquals("https://sqa-bhxh.web.app/assets/images/logo_text.svg",
						driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/div[1]/div/a/img[1]")).getAttribute("src"))
		);
    }
	
	@Test
	// Test Login valid
	public void loginValid() throws InterruptedException {
		
		WebElement userInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[1]/div/div/div/input"));
		userInput.sendKeys("0000000001");
		
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		passwordInput.sendKeys("123456789");
		
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[4]/button")).click();

		Thread.sleep(5000);

		assertAll("Đăng nhập thành công", () -> assertEquals(siteUrl + "/", (String) driver.getCurrentUrl()),
				() -> assertEquals("0000000001 - NGUYỄN VĂN A",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/button/span[1]")).getText()));
	}
	
	@Test
	// Test Login with empty username
	public void loginEmptyUsername() throws InterruptedException {
		
		
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		passwordInput.sendKeys("123456789");
		
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[4]/button")).click();

		// Explicit waits freeze the thread, until the condition is resolves.
		String msg = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[1]/div/div/p")).getText();

		assertAll("Đăng nhập không thành công",
				() -> assertEquals(true, ((String) driver.getCurrentUrl() + "/login").contains(siteUrl + "/login")),
				() -> assertEquals("Mã BHXH không được để trống", msg));
	}
	@Test
	// Test Login with empty password
	public void loginEmptyPassword() throws InterruptedException {
		WebElement userInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[1]/div/div/div/input"));
		userInput.sendKeys("0000000001");
		
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[4]/button")).click();

		String msg = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[2]/div/div/p")).getText();

		assertAll("Đăng nhập không thành công",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()+"/login").contains(siteUrl + "/login")),
				() -> assertEquals("Mật khẩu không được để trống", msg));
	}
	
	@Test
	// Test Login with empty password
	public void loginEmptyUsernamePassword() throws InterruptedException {
		
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[4]/button")).click();

		String msg1 = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[2]/div/div/p")).getText();
		String msg2 = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[1]/div/div/p")).getText();
		assertAll("Đăng nhập không thành công",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()+"/login").contains(siteUrl + "/login")),
				() -> assertEquals("Mật khẩu không được để trống", msg1),
				() -> assertEquals("Mã BHXH không được để trống", msg2));
	}
	@Test
	// Test Login wrong username
	public void loginWrongUsername() throws InterruptedException {
		
		WebElement userInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[1]/div/div/div/input"));
		userInput.sendKeys("00000002");
		
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		passwordInput.sendKeys("123456789");
		
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[4]/button")).click();
	
		Thread.sleep(5000);

		 assertEquals(true, ((String) driver.getCurrentUrl()+"/login").contains(siteUrl + "/login"));
		 
				
	}
	
	@Test
	// Test Login wrong username
	public void loginWrongPassword() throws InterruptedException {
		
		WebElement userInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[1]/div/div/div/input"));
		userInput.sendKeys("0000000001");
		
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		passwordInput.sendKeys("123456");
		
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[4]/button")).click();
		
		Thread.sleep(5000);
		assertEquals(true, ((String) driver.getCurrentUrl()+"/login").contains(siteUrl + "/login"));
			
	}
}