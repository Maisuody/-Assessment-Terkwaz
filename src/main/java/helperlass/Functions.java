package helperlass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Functions extends Variables {
//THis class has all function that i need to test all my tasks
	protected static WebDriver driver;
	
	//To open the navigate URL 
	public static void startBrowsing(String URL) {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Desktop\\chromedriver.exe");
		    driver = new ChromeDriver();		    
		    driver.get(URL);
	  }	
	
	
	//To Write data into input by xpath
	public static void sendkey(String component, String Data) {
		
		  driver.findElement(By.xpath(component)).sendKeys(Data);
	  }
	
	
	//To Write data into input by id
	public static void sendkeybyid(String component, String Data) {
		
		  driver.findElement(By.id(component)).sendKeys(Data);
	  }
	
	//To press enter
	public static void submit(String component) {
		
		driver.findElement(By.xpath(component)).submit();
	}
	
	//click to the button
	public static void clickk(String component) {
		
		  driver.findElement(By.xpath(component)).click();
	  }
	
	//to check data i have the same to the data i retrieve
	public static void Assersion(String xpath, String key) {
		String returnval = driver.findElement(By.xpath(xpath)).getText();
	    Assert.assertEquals(key , returnval);
		System.out.println("test shown correctly");
	
		}
	
	
	//to check data i have NOT the same to the data i retrieve
	public static void Assersion1(String key, String returnval) {
		
		try{
		    Assert.assertNotEquals(key , returnval);
			System.out.println("test shown correctly");

		}catch(Exception e){
			
			System.out.println("test shown not correctly");

			
		}
	
      //  Assert.assertNotEquals(key, returnval,  "test shown correctly");

		}
	
	
	//wait function 
	public static void Wait_xpath(int x , String y) {
		
	       WebDriverWait wait = new WebDriverWait(driver, x);
		      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(y)));
	}
	
	
	//for API data retrieve to work with it
	public static List<WebElement> retvalues() {
			
		 List<WebElement> parentElements = driver.findElements(By.xpath("//ul/li[@class= \"sbct\"]"));
		 
		 if(parentElements.isEmpty()) {
			 System.out.println("It' empty");  

		 }
		 else {
			 System.out.println("It's not empty");
		 }
		 
	 return parentElements;

	}
	
	
	
		}
	
	

