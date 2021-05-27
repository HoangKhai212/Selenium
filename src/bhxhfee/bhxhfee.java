package bhxhfee;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class bhxhfee {
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
		
		WebElement userInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[1]/div/div/div/input"));
		userInput.sendKeys("0000000001");
		
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		passwordInput.sendKeys("123456789");
		
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[4]/button")).click();

		Thread.sleep(5000);
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/ul/li[2]/a/img")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/ul/li[3]/a/span/span")).click();
		
		Thread.sleep(5000);
		
		
		
	}
	
	@AfterEach
	public void afterTest() {
		driver.close();
	}
	
	@Test
    public void bhxhFeeDisplay() {
		assertAll("Phí BHXH",
				
				//URL and navigation bar
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/phi-bhxh")),

				() -> assertEquals("https://sqa-bhxh.web.app/assets/images/logo_text.svg",
						driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/div[1]/div/a/img[1]"))
						.getAttribute("src")),
				() -> assertEquals("0000000001 - NGUYỄN VĂN A",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/button/span[1]"))
						.getText()),
				
				//header
				() -> assertEquals("Trang chủ",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/div/ul/li[1]/a"))
						.getText()),
				() -> assertEquals("Thông tin phí BHXH",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/div/ul/li[2]/a"))
						.getText()),
				
				//Thông tin phí BHXH
				
				//label
				() -> assertEquals("Thông tin cá nhân",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[1]/div/label"))
						.getText()),
				() -> assertEquals("Đối tượng:",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[1]/div/div[1]/div[1]"))
						.getText()),
				() -> assertEquals("Mã số BHXH:",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[1]"))
						.getText()),
				() -> assertEquals("CMND/CCCD:",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[1]/div/div[3]/div[1]"))
						.getText()),
				() -> assertEquals("Mã số thuế:",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[1]/div/div[4]/div[1]"))
						.getText()),
				() -> assertEquals("Tên đơn vị làm việc:",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[1]/div/div[5]/div[1]"))
						.getText()),
				() -> assertEquals("Mã đơn vị làm việc:",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[1]/div/div[6]/div[1]"))
						.getText()),
				() -> assertEquals("Cơ quan bảo hiểm xã hội thành phố:",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[1]/div/div[7]/div[1]"))
						.getText()),
				() -> assertEquals("Cơ quan bảo hiểm xã hội quận/huyện:",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[1]/div/div[8]/div[1]"))
						.getText()),
				() -> assertEquals("Thông tin tiền đóng",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[3]/div/label"))
						.getText()),
				() -> assertEquals("Lương của bạn",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[3]/div/div[1]/div[1]"))
						.getText()),
				() -> assertEquals("Số tiền đóng hàng tháng",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[3]/div/div[2]/div[1]"))
						.getText()),
				() -> assertEquals("Số tiền doanh nghiệp đóng",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[3]/div/div[3]/div[1]"))
						.getText()),
				() -> assertEquals("Số tiền thực phải đóng hàng tháng",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[3]/div/div[4]/div[1]"))
						.getText()),
				
				//info
				
				() -> assertEquals("Lao động hợp đồng",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[1]/div/div[1]/div[2]"))
						.getText()),
				() -> assertEquals("0000000001",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[2]"))
						.getText()),
				() -> assertEquals("000000000001",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[1]/div/div[3]/div[2]"))
						.getText()),
				() -> assertEquals("aaa9943",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[1]/div/div[4]/div[2]"))
						.getText()),
				() -> assertEquals("Tập đoàn VinGroup",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[1]/div/div[5]/div[2]"))
						.getText()),
				() -> assertEquals("vin999",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[1]/div/div[6]/div[2]"))
						.getText()),
				() -> assertEquals("Thành phố Hà Nội",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[1]/div/div[7]/div[2]"))
						.getText()),
				() -> assertEquals("BHXH Quận Ba Đình",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[1]/div/div[8]/div[2]"))
						.getText()),
				() -> assertEquals("40.000.000 ₫",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[3]/div/div[1]/div[2]"))
						.getText()),
				() -> assertEquals("3.200.000 ₫",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[3]/div/div[2]/div[2]"))
						.getText()),
				() -> assertEquals("7.000.000 ₫",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[3]/div/div[3]/div[2]"))
						.getText()),
				() -> assertEquals("3.200.000 ₫",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div/div/div[3]/div/div[4]/div[2]"))
						.getText())		
				
				);
		
	}
}
