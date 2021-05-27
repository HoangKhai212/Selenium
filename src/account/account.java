package account;

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

public class account {
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

		Thread.sleep(10000);
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/ul/li[1]/a/img")).click();
		
		Thread.sleep(10000);
	}
	
	@AfterEach
	public void afterTest() {
		driver.close();
	}
	
	@Test
    public void accountDisplay() {
		assertAll("Khai báo thông tin BHXH",
				
				//URL and navigation bar
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/tai-khoan")),

				() -> assertEquals("https://sqa-bhxh.web.app/assets/images/logo_text.svg",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div[1]/div/a/img[1]"))
						.getAttribute("src")),
				() -> assertEquals("0000000001 - NGUYỄN VĂN A",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/button/span[1]"))
						.getText()),
				
				//header
				() -> assertEquals("Home",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/div/ul/li[1]/a"))
						.getText()),
				() -> assertEquals("Khai báo thông tin",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/div/ul/li[2]/a"))
						.getText()),
				
				
				//khai báo form
				() -> assertEquals("Khai báo thông tin sử dụng thẻ Bảo hiểm xã hội",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[1]/div/div/div/div/h1"))
						.getText()),
				() -> assertEquals("Bạn là:",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/legend"))
						.getText()),
				() -> assertEquals("Lao động hợp đồng",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/div/label[1]/span[2]"))
						.getText()),
				() -> assertEquals("Lao động tự do",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/div/label[2]/span[2]"))
						.getText()),
				
			
				//Thông tin người lao động
				() -> assertEquals("*Mã số bảo hiểm xã hội",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[2]/div/div/label/span"))
						.getText()),
				() -> assertEquals("0000000001",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[2]/div/div/div/input"))
						.getAttribute("value")),
				
				() -> assertEquals("*Số CMND/HC/CC",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[3]/div/div/label/span"))
						.getText()),
				() -> assertEquals("000000000001",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[3]/div/div/div/input"))
						.getAttribute("value")),
				
				() -> assertEquals("*Họ Tên",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/label/span"))
						.getText()),
				() -> assertEquals("Nguyễn Văn A",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/div/input"))
						.getAttribute("value")),
				
				() -> assertEquals("*Ngày sinh",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/label/span"))
						.getText()),
				() -> assertEquals("1999-06-04",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/div/input"))
						.getAttribute("value")),
				
				() -> assertEquals("*Mã số thuế",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[6]/div/div/label/span"))
						.getText()),
				() -> assertEquals("aaa9943",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[6]/div/div/div/input"))
						.getAttribute("value")),
				
				() -> assertEquals("*Lương",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[7]/div/div/label/span"))
						.getText()),
				() -> assertEquals("40000000",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[7]/div/div/div/input"))
						.getAttribute("value")),
				// đơn vị làm việc
				() -> assertEquals("*Tên đơn vị làm việc",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[8]/div/div/label/span"))
						.getText()),
				() -> assertEquals("Tập đoàn VinGroup",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[8]/div/div/div/input"))
						.getAttribute("value")),
				
				() -> assertEquals("*Mã đơn vị làm việc",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[9]/div/div/label/span"))
						.getText()),
				() -> assertEquals("vin999",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[9]/div/div/div/input"))
						.getAttribute("value")),
				//Cơ quan thuế
				() -> assertEquals("Cơ quan BHXH",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[10]/label"))
						.getText()),
				() -> assertEquals("*BHXH Thành phố",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/label"))
						.getText()),
				() -> assertEquals("Thành phố Hà Nội",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/div/input"))
						.getAttribute("value")),
				
				() -> assertEquals("*BHXH Quận/Huyện",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/label"))
						.getText()),
				() -> assertEquals("BHXH Quận Ba Đình",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/div/input"))
						.getAttribute("value")),
				
				
				// địa chỉ
				() -> assertEquals("Địa chỉ liên hệ",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[13]/label"))
						.getText()),
				() -> assertEquals("*Thành phố",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/label"))
						.getText()),
				() -> assertEquals("Thành phố Hồ Chí Minh",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/div/input"))
						.getAttribute("value")),
				
				() -> assertEquals("*Quận/Huyện",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[15]/div/div/label"))
						.getText()),
				() -> assertEquals("Quận 1",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[15]/div/div/div/input"))
						.getAttribute("value")),
				
				() -> assertEquals("*Xã/Phường",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[16]/div/div/label"))
						.getText()),
				() -> assertEquals("Phường Nguyễn Trung Trực",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[16]/div/div/div/input"))
						.getAttribute("value")),
				
				() -> assertEquals("*Số nhà, ngõ (ngách, hẻm), đường phố, tổ (thôn, xóm, ấp)",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[17]/div/div/label/span"))
						.getText()),
				() -> assertEquals("Số 62 ngõ 32 phố Phúc Xá",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[17]/div/div/div/input"))
						.getAttribute("value")),
				
				//Thông tin khác
				() -> assertEquals("*Số điện thoại",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[18]/div/div/label/span"))
						.getText()),
				() -> assertEquals("0337059931",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[18]/div/div/div/input"))
						.getAttribute("value")),
				
				() -> assertEquals("*Email",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[19]/div/div/label/span"))
						.getText()),
				() -> assertEquals("test@gmail.com",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[19]/div/div/div/input"))
						.getAttribute("value")),
				
				//Nút khai báo
				() -> assertEquals("KHAI BÁO THÔNG TIN",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[20]/button/span[1]"))
						.getText())				
		);
    }
	
	@Test
	//Test thay đổi thông tin tên
	public void editHoTen() throws InterruptedException {
		WebElement hotenInput = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/div/input"));
		hotenInput.clear();
		Thread.sleep(100);
		hotenInput.sendKeys("Nguyễn Văn B") ;
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[20]/button")).click();

		Thread.sleep(5000);
		
		assertAll("Sửa tên",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/tai-khoan")),
				() -> assertEquals("Nguyễn Văn B",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/div/input"))
						.getAttribute("value")),
				() -> assertEquals("0000000001 - NGUYỄN VĂN B",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/button/span[1]"))
						.getText())				
				);
	}
	
	@Test
	//Test thay đổi thông tin ngày sinh
	public void editNgaySinh() throws InterruptedException {
		WebElement ngaysinhInput = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/div/input"));
		ngaysinhInput.clear();
		ngaysinhInput.sendKeys("12/02/1999") ;
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[20]/button")).click();

		Thread.sleep(5000);
		
		assertAll("Sửa ngày sinh",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/tai-khoan")),
				() -> assertEquals("1999-12-02",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/div/input"))
						.getAttribute("value"))			
				);
	}
	
	@Test
	//Test thay đổi thông tin mã số thuế
	public void editMaSoThue() throws InterruptedException {
		WebElement mstInput = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[6]/div/div/div/input"));
		mstInput.clear();
		mstInput.sendKeys("aaa888") ;
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[20]/button")).click();

		Thread.sleep(5000);
		
		assertAll("Sửa mã số thuế",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/tai-khoan")),
				() -> assertEquals("aaa888",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[6]/div/div/div/input"))
						.getAttribute("value"))				
				);
	}
	
	@Test
	//Test thay đổi thông tin Lương
	public void editLuong() throws InterruptedException {
		WebElement luongInput = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[7]/div/div/div/input"));
		luongInput.clear();
		luongInput.sendKeys("100000000") ;
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[20]/button")).click();

		Thread.sleep(5000);
		
		assertAll("Sửa lương",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/tai-khoan")),
				() -> assertEquals("100000000",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[7]/div/div/div/input"))
						.getAttribute("value"))				
				);
	}
	
	@Test
	//Test thay đổi thông tin tên đơn vị làm viec
	public void editTenDonVi() throws InterruptedException {
		WebElement tenDonViInput = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[8]/div/div/div/input"));
		tenDonViInput.clear();
		tenDonViInput.sendKeys("VinGroup") ;
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[20]/button")).click();

		Thread.sleep(5000);
		
		assertAll("Sửa tên đơn vị",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/tai-khoan")),
				() -> assertEquals("VinGroup",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[8]/div/div/div/input"))
						.getAttribute("value"))			
				);
	}
	
	@Test
	//Test thay đổi thông tin mã đơn vị làm việc
	public void editMaDonVi() throws InterruptedException {
		WebElement maDVInput = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[9]/div/div/div/input"));
		maDVInput.clear();
		maDVInput.sendKeys("vin888") ;
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[20]/button")).click();

		Thread.sleep(5000);
		
		assertAll("Sửa mã đơn vị",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/tai-khoan")),
				() -> assertEquals("vin888",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[9]/div/div/div/input"))
						.getAttribute("value"))				
				);
	}
	@Test
	//Test thay đổi BHXH thành phố
	public void editBHXHThanhPho() throws InterruptedException {
		WebElement Input = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/div/input"));
		Input.clear();
		Input.sendKeys("Thành phố Hà Nội") ;
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[20]/button")).click();

		Thread.sleep(5000);
		
		assertAll("Sửa BHXH thành phố",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/tai-khoan")),
				() -> assertEquals("Thành phố Hà Nội",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/div/input"))
						.getAttribute("value"))				
				);
	}
	@Test
	//Test thay đổi thông tin BHXH quận huyện
	public void editBHXHQuanHuyen() throws InterruptedException {
		WebElement Input = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/div/input"));
		Input.clear();
		Input.sendKeys("BHXH Quận Ba Đình") ;
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[20]/button")).click();

		Thread.sleep(5000);
		
		assertAll("Sửa BHXH quận huyện",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/tai-khoan")),
				() -> assertEquals("BHXH Quận Ba Đình",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/div/input"))
						.getAttribute("value"))				
				);
	}
	@Test
	//Test thay đổi thông tin thanhpho
	public void editThanhPho() throws InterruptedException {
		WebElement Input = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/div/input"));
		Input.clear();
		Input.sendKeys("Thành phố Hồ Chí Minh") ;
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[20]/button")).click();

		Thread.sleep(5000);
		
		assertAll("Sửa Thành Phố",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/tai-khoan")),
				() -> assertEquals("Thành phố Hồ Chí Minh",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/div/input"))
						.getAttribute("value"))				
				);
	}
	@Test
	//Test thay đổi thông tin quận huyện
	public void editQuanHuyen() throws InterruptedException {
		WebElement Input = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[15]/div/div/div/input"));
		Input.clear();
		Input.sendKeys("Quận 1") ;
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[20]/button")).click();

		Thread.sleep(5000);
		
		assertAll("Sửa Quận huyện",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/tai-khoan")),
				() -> assertEquals("Quận 1",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[15]/div/div/div/input"))
						.getAttribute("value"))				
				);
	}
	@Test
	//Test thay đổi thông tin xã phương
	public void editXaPhuong() throws InterruptedException {
		WebElement Input = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[16]/div/div/div/input"));
		Input.clear();
		Input.sendKeys("Phường Nguyễn Trung Trực") ;
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[20]/button")).click();

		Thread.sleep(5000);
		
		assertAll("Sửa xã phường",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/tai-khoan")),
				() -> assertEquals("Phường Nguyễn Trung Trực",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[16]/div/div/div/input"))
						.getAttribute("value"))				
				);
	}
	@Test
	//Test thay đổi thông tin số nhà
	public void editSoNha() throws InterruptedException {
		WebElement soNhaInput = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[17]/div/div/div/input"));
		soNhaInput.clear();
		soNhaInput.sendKeys("10") ;
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[20]/button")).click();

		Thread.sleep(5000);
		
		assertAll("Sửa số nhà",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/tai-khoan")),
				() -> assertEquals("10",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[17]/div/div/div/input"))
						.getAttribute("value"))				
				);
	}
	
	@Test
	//Test thay đổi thông tin Số điện thoại
	public void editSoDT() throws InterruptedException {
		WebElement soDTInput = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[18]/div/div/div/input"));
		soDTInput.clear();
		soDTInput.sendKeys("0999999977") ;
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[20]/button")).click();

		Thread.sleep(5000);
		
		assertAll("Sửa sdt",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/tai-khoan")),
				() -> assertEquals("0999999977",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[18]/div/div/div/input"))
						.getAttribute("value"))				
				);
	}
	
	@Test
	//Test thay đổi thông tin Email
	public void editEmail() throws InterruptedException {
		WebElement emailInput = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[19]/div/div/div/input"));
		emailInput.clear();
		emailInput.sendKeys("test1@gmail.com") ;
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[20]/button")).click();

		Thread.sleep(5000);
		
		assertAll("Sửa email",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/tai-khoan")),
				() -> assertEquals("test1@gmail.com",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div/div/div/div/form/div/div[19]/div/div/div/input"))
						.getAttribute("value"))			
				);
	}
}
