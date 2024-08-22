package Seleniumvijay;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.datanucleus.store.types.wrappers.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Seleniumcodesnippets  {
	
	@Test
	public void practice1()  throws Exception {
	
	WebDriverManager.chromiumdriver().setup() ;
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.saucedemo.com/inventory.html");
	
	driver.manage().window().maximize();	
	Thread.sleep(3000);
	
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	Thread.sleep(3000);
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	Thread.sleep(3000);
	driver.findElement(By.id("login-button")).click();
	Thread.sleep(3000);
	java.util.List<WebElement> elements = driver.findElements(By.xpath("//div[@class ='inventory_item_price']"));
	
	int count = elements.size();
	System.out.println(count);
	
	Pattern decimalPattern = Pattern.compile("\\d+\\.\\d{3}");
	boolean allValid = true;
	
	for (WebElement e :elements ) {
		
		 String text = e.getText();
		 if (!decimalPattern.matcher(text).matches()) {
             allValid = false;
             System.out.println("Element with text '" + text + "' does not have two decimal places.");
		
	/*String Price = e.getText();
		
	//	String regex = "\\d+\\.\\d{1}";
	//	Pattern pattern = Pattern.compile(regex);
	//	Matcher matcher = pattern.matcher(Price);
			
			if (matcher.matches()) {
				
				System.out.println("validation is pass");
			}
			else{
				System.out.println("validation is failed");
			}*/
			
		
			
			
				
			}
		
		
	}
	 if (allValid) {
         System.out.println("All elements have exactly two decimal places.");
     }
	driver.quit();
	}
}

