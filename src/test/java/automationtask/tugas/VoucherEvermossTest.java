
package automationtask.tugas;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.errorprone.annotations.Var;


public class VoucherEvermossTest extends BaseWeb {
	basicFunction commonPage = new basicFunction(driver, explicitWait);

	@Test(testName = "kategori semua", description = "semua voucher kategori")
	public void allVoucher() {
		commonPage.clickButton(By.xpath("//button[@id='onesignal-slidedown-cancel-button']"));
		commonPage.clickButton(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[4]/div[1]/a[2]"));
		List<WebElement> elems = commonPage.selectElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div"));
		int index = 1;
		String pcName = "";
		int c = 0;
		System.out.println(elems.size());
		for (WebElement ele : elems) {
			String cName = commonPage.extractColor(By.xpath("//*[@id=\"__layout\"]/div/div[4]/div/div[2]/div["+Integer.toString(index)+"]/div"));
			System.out.println(cName);
			
			if(pcName != cName) {
				pcName = cName;
				c++;
			}
			pcName = cName;
			index++;
			if(index==6) break;
		}
		if(c > 1) {
			assertEquals(true, true);
		}else {
			assertEquals(false, true);
		}
	}
	
	@Test(testName = "kategori cashback", description = "hanya voucher kategori cashback")
	public void cashbackVoucher() {
		commonPage.clickButton(By.xpath("//button[@id='onesignal-slidedown-cancel-button']"));
		commonPage.clickButton(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[4]/div[1]/a[2]"));
		try {
		    TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		commonPage.clickButton(By.cssSelector("#__layout > div > div:nth-child(4) > div > div:nth-child(1) > div > div:nth-child(3)"));
		List<WebElement> elems = commonPage.selectElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div"));
		int index = 1;
		boolean fPromo = true;
		System.out.println(elems.size());
		for (WebElement ele : elems) {
			String cName = commonPage.extractColor(By.xpath("//*[@id=\"__layout\"]/div/div[4]/div/div[2]/div["+Integer.toString(index)+"]/div"));
			System.out.println(cName);
			
			if(cName.equals("voucher__list--purple")) {
				fPromo = false;
			}
			index++;
			if(index == 2) break;
		}
		if(fPromo == false) {
			assertEquals(true, true);
		}else {
			assertEquals(false, true);
		}
	}

	
	@Test(testName = "kategori potongan ongkir", description = "hanya voucher kategori potongan ongkir")
	public void ongkirVoucher() {
		commonPage.clickButton(By.xpath("//button[@id='onesignal-slidedown-cancel-button']"));
		commonPage.clickButton(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[4]/div[1]/a[2]"));
		try {
		    TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		commonPage.clickButton(By.xpath("//div[contains(text(),'Potongan Ongkir')]"));
		List<WebElement> elems = commonPage.selectElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div"));
		int index = 1;
		boolean fPromo = true;
		System.out.println(elems.size());
		for (WebElement ele : elems) {
			String cName = commonPage.extractColor(By.xpath("//*[@id=\"__layout\"]/div/div[4]/div/div[2]/div["+Integer.toString(index)+"]/div"));
			System.out.println(cName);
			
			if(cName.equals("voucher__list--blue")) {
				fPromo = false;
			}else {
				fPromo = true;
				break;
			}
			index++;
			if(index == 6) break;
		}
		if(fPromo == false) {
			assertEquals(true, true);
		}else {
			assertEquals(false, true);
		}
	}
	
	@Test(testName = "kategori potongan belanja", description = "hanya voucher kategori potongan belanja")
	public void belanjaVoucher() {
		commonPage.clickButton(By.xpath("//button[@id='onesignal-slidedown-cancel-button']"));
		commonPage.clickButton(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[4]/div[1]/a[2]"));
		try {
		    TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		commonPage.clickButton(By.xpath("//*[@id=\"__layout\"]/div/div[4]/div/div[1]/div/div[5]"));
		List<WebElement> elems = commonPage.selectElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div"));
		int index = 1;
		boolean fPromo = true;
		System.out.println(elems.size());
		for (WebElement ele : elems) {
			String cName = commonPage.extractColor(By.xpath("//*[@id=\"__layout\"]/div/div[4]/div/div[2]/div["+Integer.toString(index)+"]/div"));
			System.out.println(cName);
			
			if(cName.equals("voucher__list--red")) {
				fPromo = false;
			}else {
				fPromo = true;
				break;
			}
			index++;
			if(index == 2) break;
		}
		if(fPromo == false) {
			assertEquals(true, true);
		}else {
			assertEquals(false, true);
		}
	}
	
	@Test(testName = "kategori potongan belanja dan ongkir", description = "hanya voucher kategori potongan ongkir")
	public void belanjaAndOngkirVoucher() {
		commonPage.clickButton(By.xpath("//button[@id='onesignal-slidedown-cancel-button']"));
		commonPage.clickButton(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[4]/div[1]/a[2]"));
		try {
		    TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		commonPage.clickButton(By.xpath("//div[contains(text(),'Potongan Belanja & Ongkir')]"));
		List<WebElement> elems = commonPage.selectElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div"));
		int index = 1;
		boolean fPromo = true;
		System.out.println(elems.size());
		for (WebElement ele : elems) {
			String cName = commonPage.extractColor(By.xpath("//*[@id=\"__layout\"]/div/div[4]/div/div[2]/div["+Integer.toString(index)+"]/div"));
			System.out.println(cName);
			
			if(cName.equals("voucher__list--yellow")) {
				fPromo = false;
			}else {
				fPromo = true;
				break;
			}
			index++;
			if(index == 2) break;
		}
		if(fPromo == false) {
			assertEquals(true, true);
		}else {
			assertEquals(false, true);
		}
	}
}