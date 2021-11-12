package tasks;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import helperlass.Functions;

//this class to test all tasks 
public class WebGUI extends Functions {
protected static WebDriver driver;

		
	public static void secondtTask() {
		
		//here to make a report
		 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\HP\\Desktop\\m\\extent.html");

	        // create ExtentReports and attach reporter(s)
	      ExtentReports extent = new ExtentReports();
	      extent.attachReporter(htmlReporter);
	        
	     ExtentTest test2 = extent.createTest("Web GUI Test Automation: Second Task", "Navigate URL and do steps");	
        
        test2.log(Status.INFO, "Navigate the Second Task URL");

        //Navigate the URL
		startBrowsing(secondtTaskURL);
		test2.pass("Open the URL");	
		
		//click to file upload
		clickk(fileUploadXpath);
		test2.pass("file Upload is done");	

		
		//wait function to load the page 
		 Wait_xpath(15 , chooseFile);
		 
		 //send the location to the picture
		sendkey(chooseFile,sendSmallPic);
		
		//click upload
		clickk(uploadPic);

		//check the photo is uploaded or not
		Assersion( checkFileUploadSuccessfully, "File Uploaded!"); 
		test2.pass("picture Upload is done");	
		
	
        test2.log(Status.INFO, "End test case second task");
        
        extent.flush();
	
	}
	 //Third task
	public static void thirdtTask() {
		
		//here to make a report
		 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\HP\\Desktop\\m\\extent.html");

	        // create ExtentReports and attach reporter(s)
	      ExtentReports extent = new ExtentReports();
	      extent.attachReporter(htmlReporter);
	       
	     
	     ExtentTest test3 = extent.createTest("Web GUI Test Automation: Third Task", "Navigate URL and do steps");	
     
	      test3.log(Status.INFO, "Navigate the Third Task URL");

	      //Navigate the URL
		startBrowsing(thirdtTaskURL);
		test3.pass("Open the URL");	

		//click to Dynamic loading link
		clickk(DynamicLoading);
		test3.pass("Click on Dynamic Loading");	

		//click to Example2 link
		clickk(example2);
		test3.pass("Click on Example2");	

		//click to Start button 
		clickk(startButton);	
		test3.pass("Click on Start botton");	

		//wait function until finishing loading
		 Wait_xpath(30 , finalCheck);
		 
	    //check the final check
		Assersion( finalCheck, "Hello World!"); 	
		test3.pass("Hello World! appears");
		
	    test3.log(Status.INFO, "End test case third task");

	    extent.flush();
		

	}
	
	public static void APITest() {
		//here to make a report
		 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\HP\\Desktop\\m\\extent.html");

	        // create ExtentReports and attach reporter(s)
	      ExtentReports extent = new ExtentReports();
	      extent.attachReporter(htmlReporter);
	        
	     ExtentTest test1 = extent.createTest("API Test Automation", "Navigate URL and do steps");	

	      test1.log(Status.INFO, "Navigate API Test Automation Task URL");

	    //Navigate to URL
		startBrowsing(APITest);
        
		 try {
			 //take the API to retrieve the data
			 URL u = new URL("https://cat-fact.herokuapp.com/facts"); 
				test1.pass("Retrieve data in json form");	

			 HttpURLConnection hr = (HttpURLConnection)u.openConnection();
			 //if condition to check is right retreive the data or not
			 if(hr.getResponseCode() == 200) {
				 InputStream im = hr.getInputStream();
				 StringBuffer sb = new StringBuffer();
				 BufferedReader br= new BufferedReader(new InputStreamReader(im));
				 String line = br.readLine();
				 //Attach the response body into file.txt
			      FileWriter myWriter = new FileWriter("output.txt");
			      //to write into the text
			      myWriter.write(line);
			      myWriter.close();

			      
			      /**
			       here i have to convert the data that retrieve from the API because it retrieve in json form, then
			       i have to convert this to array to meke it easier to work with this data
			       
			       **/
				 JSONArray array = new JSONArray(line);

				test1.pass("convert the data from json to array form");	
				

				//to retrieve random data
				 JSONObject object1 =  array.getJSONObject(0);  
					test1.pass("Get Random fact");	

			//Get one element
				// System.out.println(object1); 
				 //and check the text is empty or not	 
				 String textcheck = object1.getString("text");
					test1.pass("Have the text");	

				 if(textcheck.isEmpty()) {
					 System.out.println("It' empty");  

				 }
				 else {
					 System.out.println("It's not empty");
				 }

		 }}
			 catch( Exception e){
			 
			System.out.println(e); 
		 }
		 		
		 test1.log(Status.INFO, "End test case API Test");

		    extent.flush();

	
	}
	
	//First Task
	public static void FirstTask1() {
		
		//here to make a report
		 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\HP\\Desktop\\m\\extent.html");

	        // create ExtentReports and attach reporter(s)
	      ExtentReports extent = new ExtentReports();
	      extent.attachReporter(htmlReporter);
	        
	     ExtentTest test1 = extent.createTest("Web GUI Test Automation: First Task", "Navigate URL and do steps");	
  
	      test1.log(Status.INFO, "Navigate the Third Task URL");

		WebDriver driver;
		
		//Navigate the URL
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Desktop\\chromedriver.exe");
		    driver = new ChromeDriver();		    
		    driver.get("https://www.google.com/");
		    
			test1.pass("Open the URL");	

			 //put in input the search sentence

			  driver.findElement(By.xpath("//input[@class = \"gLFyf gsfi\"]")).sendKeys("selenium webdriver");
			  
				test1.pass("Enter input to search input");	

				 //using implicit wait to wait until finish writing the search sentence
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				//to retrieve all data that appear in search 
			   List<WebElement> parentElements = driver.findElements(By.xpath("//ul[@class=\"G43f7e\"]/li"));
			 
			 //to check size
			// System.out.println(parentElements.size());
			   
			 //get third search result
			 WebElement b = parentElements.get(2);
			 
			 //get text to check is that result that give me or not
			 String testt = b.getText();
			test1.pass("Get the text to check");	

		//	 System.out.println(testt);
			 
			 Assersion1("What is Selenium WebDriver?", testt);
			 test1.fail("its not equals");
		     try {
				test1.addScreenCaptureFromPath("screenshot.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("not sc");

				e.printStackTrace();
			}

			    test1.log(Status.INFO, "End test case First task");

			    extent.flush();

	}
	 
		 
		
		    
}
