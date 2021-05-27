package payment;

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

public class payment {
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
	}
	
	@AfterEach
	public void afterTest() {
		driver.close();
	}
	
	@Test
    public void paymentDisplay() {
		assertAll("Thanh toán BHXH",
				
				//URL and navigation bar
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/thanh-toan")),

				() -> assertEquals("https://sqa-bhxh.web.app/assets/images/logo_text.svg",
						driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/div[1]/div/a/img[1]"))
						.getAttribute("src")),
				() -> assertEquals("0000000001 - NGUYỄN VĂN A",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/button/span[1]"))
						.getText()),
				
				
				
				// hiển thị bảng lịch sử thanh toán
				() -> assertEquals("Lịch sử đóng bảo hiểm",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[1]/h1"))
						.getText()),
				// các cột
				() -> assertEquals("STT",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/thead/tr/th[1]"))
						.getText()),
				() -> assertEquals("Ngày đóng",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/thead/tr/th[2]"))
						.getText()),
				() -> assertEquals("Nội dung",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/thead/tr/th[3]"))
						.getText()),
				() -> assertEquals("Số tiền",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/thead/tr/th[4]"))
						.getText()),
				() -> assertEquals("Ngân hàng",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/thead/tr/th[5]"))
						.getText()),
				() -> assertEquals("Chi nhánh",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/thead/tr/th[6]"))
						.getText()),
				() -> assertEquals("Loại giao dịch",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/thead/tr/th[7]"))
						.getText()),
				
				//các hàng
				
				//hàng 1
				() -> assertEquals("1",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[1]/th"))
						.getText()),
				() -> assertEquals("2019-05-24 10:03:54.091",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[1]/td[1]"))
						.getText()),
				() -> assertEquals("Đóng BHXH Tháng 5 - 2019",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[1]/td[2]"))
						.getText()),
				() -> assertEquals("1.600.000 ₫",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[1]/td[3]"))
						.getText()),
				() -> assertEquals("Ngân hàng Nông nghiệp và Phát triển Nông thôn Việt Nam",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[1]/td[4]"))
						.getText()),
				() -> assertEquals("Chi nhánh Sở giao dịch - Phòng giao dịch số 2",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[1]/td[5]"))
						.getText()),
				() -> assertEquals("Chuyển tiền đi",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[1]/td[6]"))
						.getText()),
				
				//hàng 2
				() -> assertEquals("2",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[2]/th"))
						.getText()),
				() -> assertEquals("2020-05-20 10:03:54.091",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[2]/td[1]"))
						.getText()),
				() -> assertEquals("Đóng BHXH Tháng 5 - 2020",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[2]/td[2]"))
						.getText()),
				() -> assertEquals("1.600.000 ₫",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[2]/td[3]"))
						.getText()),
				() -> assertEquals("Ngân hàng Nông nghiệp và Phát triển Nông thôn Việt Nam",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[2]/td[4]"))
						.getText()),
				() -> assertEquals("Chi nhánh Sở giao dịch - Phòng giao dịch số 2",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[2]/td[5]"))
						.getText()),
				() -> assertEquals("Chuyển tiền đi",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[2]/td[6]"))
						.getText()),
				
				
				//hàng 3
				() -> assertEquals("3",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[3]/th"))
						.getText()),
				() -> assertEquals("2021-05-26 10:05:05.915",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[3]/td[1]"))
						.getText()),
				() -> assertEquals("Đóng BHXH Tháng 5 - 2021",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[3]/td[2]"))
						.getText()),
				() -> assertEquals("1.600.000 ₫",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[3]/td[3]"))
						.getText()),
				() -> assertEquals("Ngân hàng Nông nghiệp và Phát triển Nông thôn Việt Nam",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[3]/td[4]"))
						.getText()),
				() -> assertEquals("Chi nhánh Láng Hạ - Phòng giao dịch số 08",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[3]/td[5]"))
						.getText()),
				() -> assertEquals("Chuyển tiền đi",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div/div/div/div/table/tbody/tr[3]/td[6]"))
						.getText())
				);
	}
}
