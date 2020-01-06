package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;

public class AddCustomer extends TestBase {
	
	@Test
	public void loginAsBankManager() throws Exception {
		
		
		driver.findElement(By.xpath(OR.getProperty("bml"))).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(OR.getProperty("addcustomer"))).click();
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath(OR.getProperty("fname"))).sendKeys("test");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(OR.getProperty("lname"))).sendKeys("test");
		
		driver.findElement(By.xpath(OR.getProperty("postcode"))).sendKeys("test");
		
		driver.findElement(By.xpath(OR.getProperty("Addcustomerbtn"))).click();
		
		Thread.sleep(5000);
		
		
		
	}

}
 