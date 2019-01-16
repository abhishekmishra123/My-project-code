package aircon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class aircon_Login {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Jar\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://stage-aircon.dexbytes.in");
		driver.manage().window().maximize();
		
		//Check test for validation without enter credentials.  
		driver.findElement(By.xpath("//input[@id='email']"));
		driver.findElement(By.xpath("//input[@id='password']"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualMsg = driver.findElement(By.xpath("//span[@class='invalid-feedback']")).getText();
		String errorMsg = "Please enter your email address";
		if (actualMsg.equals(errorMsg)) {
			System.out.println("Test Case Passed");
		} else {
			System.out.println("Test Case Failed");
		}
		
		//Check test for validation enter invalid credentials.  
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Admin@admin.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualMsg1 = driver.findElement(By.xpath("//span[@class='invalid-feedback']")).getText();
		String errorMsg1 = "This combination of email address and password is incorrect. Please try again";
		
		if (actualMsg1.equals(errorMsg1)) {
			System.out.println("Test Case Passed");
		} else {
			System.out.println("Test Case Failed");
		}
		
		//Enter valid credentials for login. 
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Admin@admin.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	   
	   String url = driver.getCurrentUrl();
	    System.out.println("Url");
	    try{
	    	Thread.sleep(5000);
	    	}
	    	catch(InterruptedException ie){
	    	}
	    
	    if (url.contains("/home/")) {
			System.out.println("0");
		} else {
			System.out.println("1");
		}
	    
		driver.close();
	}	

}
