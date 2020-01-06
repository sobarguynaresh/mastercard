package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	
	public static Properties OR= new Properties();
	
	public static Properties config= new Properties();
	
	public static FileInputStream fis;
	
	public static WebDriver driver;
	
	
	public static void click(String key) {
		
		if(key.endsWith("_XPATH")) {
			
			driver.findElement(By.xpath(OR.getProperty(key))).click();
			
		}
		
		else if(key.endsWith("_CSS")) {
			
			driver.findElement(By.cssSelector(OR.getProperty(key))).click();
			
		}
		
		else if(key.endsWith("_ID")) {
			
			
			driver.findElement(By.id(OR.getProperty(key))).click();
		}
		
		
	}
	
	
	public static void Type(String key, String value) {
		
		if(key.endsWith("_XPATH")) {
			
			driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
			
		}
		
		else if(key.endsWith("_CSS")) {
			
			driver.findElement(By.cssSelector(OR.getProperty(key))).sendKeys(value);
			
		}
		
		else if(key.endsWith("_ID")) {
			
			
			driver.findElement(By.id(OR.getProperty(key))).sendKeys(value);
		}
		
		
	}
	
	@BeforeSuite
	public void setUp() {
		
		if(driver==null) {
			
			try {
				fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			try {
				fis= new FileInputStream("C:\\Users\\NareshS\\eclipse-workspace\\automation\\src\\test\\resources\\properties\\or.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\driver\\chromedriver.exe");
				
				driver= new ChromeDriver();
				
				
				driver.manage().window().maximize();
				
				driver.get(config.getProperty("testsiteurl"));
				
				driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
				
				
			}
			
			
			
		}
		
		
		
		
	}
	
	@AfterSuite
	public void tearDown() {
		
		if(driver!=null) {
			
			driver.quit();
		}
		
	}
	
	
	
	

}
