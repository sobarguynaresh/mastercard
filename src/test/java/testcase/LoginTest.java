package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;

public class LoginTest extends TestBase {
	
	@Test
	public void loginAsBankManager() throws Exception {
		
		
		driver.findElement(By.xpath(OR.getProperty("bml"))).click();
		
		Thread.sleep(5000);
		
		
		
	}

}
 