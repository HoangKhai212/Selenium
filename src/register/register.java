package register;

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

public class register {
	String siteUrl = "https://sqa-bhxh.web.app";
	WebDriver driver;
	JavascriptExecutor js;

	
	@BeforeEach
	public void init() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

		driver = new ChromeDriver(options);
		js = (JavascriptExecutor) driver;

		driver.get(siteUrl + "/register");
		Thread.sleep(3000);
	}
	
	@AfterEach
	public void afterTest() {
		driver.close();
	}
	
	@Test
    public void registerDisplay() {
		assertAll("Đăng ký tài khoản",
				//URL and navigation bar
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/register")),

				() -> assertEquals("https://sqa-bhxh.web.app/assets/images/logo_text.svg",
						driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/div[1]/div/a/img[1]"))
						.getAttribute("src")),
				() -> assertEquals("ĐĂNG NHẬP",
						driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/div[2]/div/div/a[1]/span[1]"))
						.getText()),
				() -> assertEquals("ĐĂNG KÝ",
						driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/div[2]/div/div/a[2]/span[1]"))
						.getText()),
				
				//header
				() -> assertEquals("Home",
						driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/ul/li[1]/a"))
						.getText()),
				() -> assertEquals("Đăng ký tài khoản",
						driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/ul/li[2]/a"))
						.getText()),
				
				//register form
				() -> assertEquals("Đăng ký tài khoản sử dụng Bảo hiểm xã hội",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div[1]/div/div/div/div/h1"))
						.getText()),
				() -> assertEquals("Bạn là:",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/legend"))
						.getText()),
				() -> assertEquals("Lao động hợp đồng",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/div/label[1]/span[2]"))
						.getText()),
				() -> assertEquals("Lao động tự do",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/div/label[2]/span[2]"))
						.getText()),
				() -> assertEquals("*Mã số bảo hiểm xã hội",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[2]/div/div/label/span"))
						.getText()),
				() -> assertEquals("*Số CMND/HC/CC",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[3]/div/div/label/span"))
						.getText()),
				() -> assertEquals("*Họ Tên",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/label/span"))
						.getText()),
				() -> assertEquals("*Ngày sinh",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/label/span"))
						.getText()),
				() -> assertEquals("Địa chỉ liên hệ",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[6]/label"))
						.getText()),
				() -> assertEquals("*Thành phố",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[7]/div/div/label"))
						.getText()),
				() -> assertEquals("*Quận/Huyện",
						driver.findElement(By.xpath("//html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[8]/div/div/label"))
						.getText()),
				() -> assertEquals("*Xã/Phường",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[9]/div/div/label"))
						.getText()),
				() -> assertEquals("*Số nhà, ngõ (ngách, hẻm), đường phố, tổ (thôn, xóm, ấp)",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[10]/div/div/label/span"))
						.getText()),
				() -> assertEquals("*Số điện thoại",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/label/span"))
						.getText()),
				() -> assertEquals("*Email",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/label/span"))
						.getText()),
				() -> assertEquals("*Mật khẩu",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[13]/div/div/label/span"))
						.getText()),
				() -> assertEquals("*Xác nhận mật khẩu",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/label/span"))
						.getText()),
				() -> assertEquals("ĐĂNG KÝ",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[15]/button/span[1]"))
						.getText()),
				() -> assertEquals("Đã có tài khoản?Đăng nhập",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[17]/p"))
						.getText()),
				() -> assertEquals("Đăng nhập",
						driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[17]/p/a"))
						.getText())					
		);
    }
	@Test
	//Đăng ký lao động hợp đồng thành công
	public void registerContractLaborValid() throws InterruptedException {
		//input info
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/div/label[1]/span[1]/span[1]/input")).click();
		WebElement mstInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		mstInput.sendKeys("0000000005");
		WebElement cccdInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[3]/div/div/div/input"));
		cccdInput.sendKeys("123456789323");
		WebElement hoTenInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/div/input"));
		hoTenInput.sendKeys("Nguyễn Văn B");
		WebElement dobInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/div/input"));
		dobInput.sendKeys("01/01/1999");
		WebElement cityInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[7]/div/div/div/input"));
		dobInput.sendKeys("Thành phố Hà Nội");
		WebElement districtInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[8]/div/div/div/input"));
		dobInput.sendKeys("Thanh Xuân");
		WebElement wardsInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[9]/div/div/div/input"));
		dobInput.sendKeys("Nhân Chính");
		WebElement stressInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[10]/div/div/div/input"));
		stressInput.sendKeys("1");
		WebElement phoneNumberInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/div/input"));
		phoneNumberInput.sendKeys("033705931");
		WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/div/input"));
		emailInput.sendKeys("khaihoang1@gmail.com");
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[13]/div/div/div/input"));
		passwordInput.sendKeys("#Sqa2021");
		WebElement confirmPwInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/div/input"));
		confirmPwInput.sendKeys("#Sqa2021");
		//click register
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[15]/button")).click();

		Thread.sleep(5000);
		
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/div[2]/div/div/a[1]/span[1]")).click();
		Thread.sleep(5000);
		
		//check lại bằng đăng nhập
		
		WebElement userInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[1]/div/div/div/input"));
		userInput.sendKeys("0000000003");
		
		WebElement pwInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		passwordInput.sendKeys("#Sqa2021");
		
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[4]/button")).click();

		Thread.sleep(5000);

		assertAll("Đăng nhập thành công", () -> assertEquals(siteUrl + "/", (String) driver.getCurrentUrl()),
				() -> assertEquals("0000000003 - NGUYỄN VĂN B",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/button/span[1]")).getText()));
		
				
	}
	
	
	@Test
	//Đăng ký lao động tự do thành công
	public void registerFreelanceWorkersValid() throws InterruptedException {
		//input info
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/div/label[2]/span[1]/span[1]/input")).click();
		WebElement mstInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		mstInput.sendKeys("0000000003");
		WebElement cccdInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[3]/div/div/div/input"));
		cccdInput.sendKeys("123456789123");
		WebElement hoTenInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/div/input"));
		hoTenInput.sendKeys("Nguyễn Văn B");
		WebElement dobInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/div/input"));
		dobInput.sendKeys("01/01/1999");		
		WebElement stressInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[10]/div/div/div/input"));
		stressInput.sendKeys("1");
		WebElement phoneNumberInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/div/input"));
		phoneNumberInput.sendKeys("0337059931");
		WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/div/input"));
		emailInput.sendKeys("khaihoang@gmail.com");
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[13]/div/div/div/input"));
		passwordInput.sendKeys("#Sqa2021");
		WebElement confirmPwInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/div/input"));
		confirmPwInput.sendKeys("#Sqa2021");
		//click register
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[15]/button")).click();

		Thread.sleep(5000);
		
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/div[2]/div/div/a[1]/span[1]")).click();
		Thread.sleep(5000);
		
		//check lại bằng đăng nhập
		
		WebElement userInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[1]/div/div/div/input"));
		userInput.sendKeys("0000000003");
		
		WebElement pwInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		passwordInput.sendKeys("#Sqa2021");
		
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div/div/form/div/div[4]/button")).click();

		Thread.sleep(5000);

		assertAll("Đăng nhập thành công", () -> assertEquals(siteUrl + "/", (String) driver.getCurrentUrl()),
				() -> assertEquals("0000000003 - NGUYỄN VĂN B",
						driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div[2]/div/div/div/button/span[1]")).getText()));
		
	}
	
	@Test
	//Để trống mã số bhxh
	public void emptyMaSoBHXH() throws InterruptedException {
		//input info
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/div/label[2]/span[1]/span[1]/input")).click();
		WebElement cccdInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[3]/div/div/div/input"));
		cccdInput.sendKeys("123456789123");
		WebElement hoTenInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/div/input"));
		hoTenInput.sendKeys("Nguyễn Văn B");
		WebElement dobInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/div/input"));
		dobInput.sendKeys("01/01/1999");		
		WebElement stressInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[10]/div/div/div/input"));
		stressInput.sendKeys("1");
		WebElement phoneNumberInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/div/input"));
		phoneNumberInput.sendKeys("0337059931");
		WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/div/input"));
		emailInput.sendKeys("khaihoang@gmail.com");
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[13]/div/div/div/input"));
		passwordInput.sendKeys("#Sqa2021");
		WebElement confirmPwInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/div/input"));
		confirmPwInput.sendKeys("#Sqa2021");
		//click register
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[15]/button")).click();
		Thread.sleep(5000);	
		String msg = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[2]/div/div/p")).getText();
		assertAll("Đăng ký không thành công",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/register")),
				() -> assertEquals("Mã BHXH không được để trống", msg));
	}
	
	@Test
	//Để trống số cccd
	public void emptyCCCD() throws InterruptedException {
		//input info
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/div/label[2]/span[1]/span[1]/input")).click();
		WebElement mstInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		mstInput.sendKeys("0000000003");
		WebElement hoTenInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/div/input"));
		hoTenInput.sendKeys("Nguyễn Văn B");
		WebElement dobInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/div/input"));
		dobInput.sendKeys("01/01/1999");		
		WebElement stressInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[10]/div/div/div/input"));
		stressInput.sendKeys("1");
		WebElement phoneNumberInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/div/input"));
		phoneNumberInput.sendKeys("0337059931");
		WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/div/input"));
		emailInput.sendKeys("khaihoang@gmail.com");
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[13]/div/div/div/input"));
		passwordInput.sendKeys("#Sqa2021");
		WebElement confirmPwInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/div/input"));
		confirmPwInput.sendKeys("#Sqa2021");
		//click register
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[15]/button")).click();
		Thread.sleep(5000);	
		String msg = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[3]/div/div/p")).getText();
		assertAll("Đăng ký không thành công",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/register")),
				() -> assertEquals("CMND/CCCD không được để trống", msg));
	}
	
	@Test
	//Để trống họ tên
	public void emptyHoTen() throws InterruptedException {
		//input info
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/div/label[2]/span[1]/span[1]/input")).click();
		WebElement mstInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		mstInput.sendKeys("0000000003");
		WebElement cccdInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[3]/div/div/div/input"));
		cccdInput.sendKeys("123456789123");
		WebElement dobInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/div/input"));
		dobInput.sendKeys("01/01/1999");		
		WebElement stressInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[10]/div/div/div/input"));
		stressInput.sendKeys("1");
		WebElement phoneNumberInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/div/input"));
		phoneNumberInput.sendKeys("0337059931");
		WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/div/input"));
		emailInput.sendKeys("khaihoang@gmail.com");
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[13]/div/div/div/input"));
		passwordInput.sendKeys("#Sqa2021");
		WebElement confirmPwInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/div/input"));
		confirmPwInput.sendKeys("#Sqa2021");
		//click register
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[15]/button")).click();
		Thread.sleep(5000);	
		String msg = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/p")).getText();
		assertAll("Đăng ký không thành công",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/register")),
				() -> assertEquals("Tên không được để trống", msg));
	}
	
	@Test
	//Để trống ngày sinh
	public void emptyDoB() throws InterruptedException {
		//input info
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/div/label[2]/span[1]/span[1]/input")).click();
		WebElement mstInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		mstInput.sendKeys("0000000003");
		WebElement cccdInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[3]/div/div/div/input"));
		cccdInput.sendKeys("123456789123");
		WebElement hoTenInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/div/input"));
		hoTenInput.sendKeys("Nguyễn Văn B");		
		WebElement stressInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[10]/div/div/div/input"));
		stressInput.sendKeys("1");
		WebElement phoneNumberInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/div/input"));
		phoneNumberInput.sendKeys("0337059931");
		WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/div/input"));
		emailInput.sendKeys("khaihoang@gmail.com");
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[13]/div/div/div/input"));
		passwordInput.sendKeys("#Sqa2021");
		WebElement confirmPwInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/div/input"));
		confirmPwInput.sendKeys("#Sqa2021");
		//click register
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[15]/button")).click();
		Thread.sleep(5000);	
		String msg = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/p")).getText();
		assertAll("Đăng ký không thành công",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/register")),
				() -> assertEquals("Ngày sinh không được để trống", msg));
	}
	
	@Test
	//Để trống số nhà
	public void emptySoNha() throws InterruptedException {
		//input info
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/div/label[2]/span[1]/span[1]/input")).click();
		WebElement mstInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		mstInput.sendKeys("0000000003");
		WebElement cccdInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[3]/div/div/div/input"));
		cccdInput.sendKeys("123456789123");
		WebElement hoTenInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/div/input"));
		hoTenInput.sendKeys("Nguyễn Văn B");
		WebElement dobInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/div/input"));
		dobInput.sendKeys("01/01/1999");		
		WebElement phoneNumberInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/div/input"));
		phoneNumberInput.sendKeys("0337059931");
		WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/div/input"));
		emailInput.sendKeys("khaihoang@gmail.com");
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[13]/div/div/div/input"));
		passwordInput.sendKeys("#Sqa2021");
		WebElement confirmPwInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/div/input"));
		confirmPwInput.sendKeys("#Sqa2021");
		//click register
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[15]/button")).click();
		Thread.sleep(5000);	
		String msg = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[10]/div/div/p")).getText();
		assertAll("Đăng ký không thành công",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/register")),
				() -> assertEquals("Số nhà không được để trống", msg));
	}
	@Test
	//Để trống số điện thoại
	public void emptySoDT() throws InterruptedException {
		//input info
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/div/label[2]/span[1]/span[1]/input")).click();
		WebElement mstInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		mstInput.sendKeys("0000000003");
		WebElement cccdInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[3]/div/div/div/input"));
		cccdInput.sendKeys("123456789123");
		WebElement hoTenInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/div/input"));
		hoTenInput.sendKeys("Nguyễn Văn B");
		WebElement dobInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/div/input"));
		dobInput.sendKeys("01/01/1999");		
		WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/div/input"));
		emailInput.sendKeys("khaihoang@gmail.com");
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[13]/div/div/div/input"));
		passwordInput.sendKeys("#Sqa2021");
		WebElement confirmPwInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/div/input"));
		confirmPwInput.sendKeys("#Sqa2021");
		//click register
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[15]/button")).click();
		Thread.sleep(5000);	
		String msg = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/p")).getText();
		assertAll("Đăng ký không thành công",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/register")),
				() -> assertEquals("Số điện thoại không được để trống", msg));
	}
	
	@Test
	//Để trống email
	public void emptyEmail() throws InterruptedException {
		//input info
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/div/label[2]/span[1]/span[1]/input")).click();
		WebElement mstInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		mstInput.sendKeys("0000000003");
		WebElement cccdInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[3]/div/div/div/input"));
		cccdInput.sendKeys("123456789123");
		WebElement hoTenInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/div/input"));
		hoTenInput.sendKeys("Nguyễn Văn B");
		WebElement dobInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/div/input"));
		dobInput.sendKeys("01/01/1999");		
		WebElement stressInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[10]/div/div/div/input"));
		stressInput.sendKeys("1");
		WebElement phoneNumberInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/div/input"));
		phoneNumberInput.sendKeys("0337059931");
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[13]/div/div/div/input"));
		passwordInput.sendKeys("#Sqa2021");
		WebElement confirmPwInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/div/input"));
		confirmPwInput.sendKeys("#Sqa2021");
		//click register
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[15]/button")).click();
		Thread.sleep(5000);	
		String msg = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/p")).getText();
		assertAll("Đăng ký không thành công",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/register")),
				() -> assertEquals("Email không được để trống", msg));
	}
	
	@Test
	//Để trống mật khẩu
	public void emptyPassword() throws InterruptedException {
		//input info
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/div/label[2]/span[1]/span[1]/input")).click();
		WebElement mstInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		mstInput.sendKeys("0000000003");
		WebElement cccdInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[3]/div/div/div/input"));
		cccdInput.sendKeys("123456789123");
		WebElement hoTenInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/div/input"));
		hoTenInput.sendKeys("Nguyễn Văn B");
		WebElement dobInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/div/input"));
		dobInput.sendKeys("01/01/1999");		
		WebElement stressInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[10]/div/div/div/input"));
		stressInput.sendKeys("1");
		WebElement phoneNumberInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/div/input"));
		phoneNumberInput.sendKeys("0337059931");
		WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/div/input"));
		emailInput.sendKeys("khaihoang@gmail.com");
		WebElement confirmPwInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/div/input"));
		confirmPwInput.sendKeys("#Sqa2021");
		//click register
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[15]/button")).click();
		Thread.sleep(5000);	
		String msg = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[13]/div/div/p")).getText();
		assertAll("Đăng ký không thành công",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/register")),
				() -> assertEquals("Mật khẩu không được để trống", msg));
	}
	
	@Test
	//Để trống xác nhận mk
	public void emptyConfirmPasword() throws InterruptedException {
		//input info
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/div/label[2]/span[1]/span[1]/input")).click();
		WebElement mstInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		mstInput.sendKeys("0000000003");
		WebElement cccdInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[3]/div/div/div/input"));
		cccdInput.sendKeys("123456789123");
		WebElement hoTenInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/div/input"));
		hoTenInput.sendKeys("Nguyễn Văn B");
		WebElement dobInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/div/input"));
		dobInput.sendKeys("01/01/1999");		
		WebElement stressInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[10]/div/div/div/input"));
		stressInput.sendKeys("1");
		WebElement phoneNumberInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/div/input"));
		phoneNumberInput.sendKeys("0337059931");
		WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/div/input"));
		emailInput.sendKeys("khaihoang@gmail.com");
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[13]/div/div/div/input"));
		passwordInput.sendKeys("#Sqa2021");
		//click register
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[15]/button")).click();
		Thread.sleep(5000);	
		String msg = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/p")).getText();
		assertAll("Đăng ký không thành công",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/register")),
				() -> assertEquals("Mật khẩu không được để trống", msg));
	}
	
	@Test
	//trùng mã số bhxh đã tồn tại
	public void existMaBHXH() throws InterruptedException {
		//input info
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/div/label[2]/span[1]/span[1]/input")).click();
		WebElement mstInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		mstInput.sendKeys("0000000003");
		WebElement cccdInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[3]/div/div/div/input"));
		cccdInput.sendKeys("123456789123");
		WebElement hoTenInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/div/input"));
		hoTenInput.sendKeys("Nguyễn Văn B");
		WebElement dobInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/div/input"));
		dobInput.sendKeys("01/01/1999");		
		WebElement stressInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[10]/div/div/div/input"));
		stressInput.sendKeys("1");
		WebElement phoneNumberInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/div/input"));
		phoneNumberInput.sendKeys("0337059931");
		WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/div/input"));
		emailInput.sendKeys("khaihoang@gmail.com");
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[13]/div/div/div/input"));
		passwordInput.sendKeys("#Sqa2021");
		WebElement confirmPwInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/div/input"));
		confirmPwInput.sendKeys("#Sqa2021");
		//click register
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[15]/button")).click();
		Thread.sleep(5000);	
		assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/register"));
	}
	
	@Test
	//trùng số cccd đã tồn tại
	public void existCCCD() throws InterruptedException {
		//input info
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/div/label[2]/span[1]/span[1]/input")).click();
		WebElement mstInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		mstInput.sendKeys("0000000003");
		WebElement cccdInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[3]/div/div/div/input"));
		cccdInput.sendKeys("123456789123");
		WebElement hoTenInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/div/input"));
		hoTenInput.sendKeys("Nguyễn Văn B");
		WebElement dobInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/div/input"));
		dobInput.sendKeys("01/01/1999");		
		WebElement stressInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[10]/div/div/div/input"));
		stressInput.sendKeys("1");
		WebElement phoneNumberInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/div/input"));
		phoneNumberInput.sendKeys("0337059931");
		WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/div/input"));
		emailInput.sendKeys("khaihoang@gmail.com");
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[13]/div/div/div/input"));
		passwordInput.sendKeys("#Sqa2021");
		WebElement confirmPwInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/div/input"));
		confirmPwInput.sendKeys("#Sqa2021");
		//click register
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[15]/button")).click();
		Thread.sleep(5000);	
		assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/register"));
	}
	
	@Test
	//trùng số điện thoại đã đăng ký
	public void existSoDt() throws InterruptedException {
		//input info
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/div/label[2]/span[1]/span[1]/input")).click();
		WebElement mstInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		mstInput.sendKeys("0000000003");
		WebElement cccdInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[3]/div/div/div/input"));
		cccdInput.sendKeys("123456789123");
		WebElement hoTenInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/div/input"));
		hoTenInput.sendKeys("Nguyễn Văn B");
		WebElement dobInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/div/input"));
		dobInput.sendKeys("01/01/1999");		
		WebElement stressInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[10]/div/div/div/input"));
		stressInput.sendKeys("1");
		WebElement phoneNumberInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/div/input"));
		phoneNumberInput.sendKeys("0337059931");
		WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/div/input"));
		emailInput.sendKeys("khaihoang@gmail.com");
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[13]/div/div/div/input"));
		passwordInput.sendKeys("#Sqa2021");
		WebElement confirmPwInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/div/input"));
		confirmPwInput.sendKeys("#Sqa2021");
		//click register
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[15]/button")).click();
		Thread.sleep(5000);	
		assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/register"));
	}
	
	@Test
	//nhập mật khẩu sai format
	public void wrongFormatPW() throws InterruptedException {
		//input info
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/div/label[2]/span[1]/span[1]/input")).click();
		WebElement mstInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		mstInput.sendKeys("0000000003");
		WebElement cccdInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[3]/div/div/div/input"));
		cccdInput.sendKeys("123456789123");
		WebElement hoTenInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/div/input"));
		hoTenInput.sendKeys("Nguyễn Văn B");
		WebElement dobInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/div/input"));
		dobInput.sendKeys("01/01/1999");		
		WebElement stressInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[10]/div/div/div/input"));
		stressInput.sendKeys("1");
		WebElement phoneNumberInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/div/input"));
		phoneNumberInput.sendKeys("0337059931");
		WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/div/input"));
		emailInput.sendKeys("khaihoang@gmail.com");
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[13]/div/div/div/input"));
		passwordInput.sendKeys("wrongPw");
		WebElement confirmPwInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/div/input"));
		confirmPwInput.sendKeys("#Sqa2021");
		//click register
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[15]/button")).click();
		Thread.sleep(5000);	
		assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/register"));
		String msg = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[13]/div/div/p")).getText();
		assertAll("Đăng ký không thành công",
				() -> assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/register")),
				() -> assertEquals("Mật khẩu tối thiểu 6 ký tự, chứa cả chữ hoa, chữ thường, số và ký tự đặc biệt", msg));
	}
	@Test
	//Xác nhận mật khẩu khác mật khẩu
	public void WrongConfirmPW() throws InterruptedException {
		//input info
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/form/div/div[1]/fieldset/div/label[2]/span[1]/span[1]/input")).click();
		WebElement mstInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[2]/div/div/div/input"));
		mstInput.sendKeys("0000000003");
		WebElement cccdInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[3]/div/div/div/input"));
		cccdInput.sendKeys("123456789123");
		WebElement hoTenInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[4]/div/div/div/input"));
		hoTenInput.sendKeys("Nguyễn Văn B");
		WebElement dobInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[5]/div/div/div/input"));
		dobInput.sendKeys("01/01/1999");		
		WebElement stressInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[10]/div/div/div/input"));
		stressInput.sendKeys("1");
		WebElement phoneNumberInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[11]/div/div/div/input"));
		phoneNumberInput.sendKeys("0337059931");
		WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[12]/div/div/div/input"));
		emailInput.sendKeys("khaihoang@gmail.com");
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[13]/div/div/div/input"));
		passwordInput.sendKeys("#Sqa2021");
		WebElement confirmPwInput = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[14]/div/div/div/input"));
		confirmPwInput.sendKeys("1");
		//click register
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/div/div/div/div/div/form/div/div[15]/button")).click();
		Thread.sleep(5000);	
		assertEquals(true, ((String) driver.getCurrentUrl()).contains(siteUrl + "/register"));
	}
}
