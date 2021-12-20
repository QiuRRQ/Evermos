package automationtask.tugas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseWeb implements IDriverManager {

	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();
	basicFunction commonPage = new basicFunction(driver, explicitWait);
	
	@BeforeMethod
	public void createChromeDriver() {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("enable-popup-blocking");
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver(options));	
		
		commonPage.openUrl("https://evermos.com/");

		commonPage.clickButton(By.xpath("//section[@class='elementor-section elementor-inner-section elementor-element elementor-element-689e8e1 elementor-section-boxed elementor-section-height-default elementor-section-height-default jet-parallax-section']//ul[@id='menu-1-b1a0ff7']//a[@class='elementor-item'][normalize-space()='Masuk']"));
		
		commonPage.setIputText(By.xpath("//input[@placeholder='Nomor Telepon Anda']"), "6281223334444");
		commonPage.setIputText(By.xpath("//input[@placeholder='Kata Sandi Anda']"), "password");
		
		commonPage.clickButton(By.xpath("//button[@type='button']"));
	}

	@AfterMethod
	public void quitChromeDriver() {
		// TODO Auto-generated method stub
//		driver.quit();
		driver.get().quit();
	}

}
