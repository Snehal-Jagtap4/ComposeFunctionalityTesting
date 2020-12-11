package seleniumwebdriverscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ComposeFunctionalityYahoo {

	WebDriver driver;
	WebDriverWait wait;
  @Test
  public void sendMail() throws InterruptedException {
	  
	 
	  driver.get("https://login.yahoo.com/");
	  
	  driver.findElement(By.id("login-username")).sendKeys("Enter ID here");
	  driver.findElement(By.id("login-signin")).click();
	  
	  WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-passwd")));
	  				element.sendKeys("Enter Password here");
	  
	
	    driver.findElement(By.id("login-signin")).click();
	   

	    //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	    WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Mail')]")));
	    	    
	    element1.click();
	    
	  
	    WebElement element2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-test-id='compose-button']")));
	    element2.click();
	    
	    WebElement element3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message-to-field")));
	    	element3.sendKeys("snehaljagtap051@gmail.com");
	   
	    driver.findElement(By.cssSelector("input[data-test-id='compose-subject']")).sendKeys("Hi, I am Snehal");
	    
	    
	    driver.findElement(By.cssSelector("div[data-test-id='rte']")).sendKeys("I have done my assignment.");
	    
	    driver.findElement(By.cssSelector("span[role='presentation']")).click();
	    WebElement element4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test-id=\"compose-send-button\"]")));
	    element4.click();
	  
	    //driver.findElement(By.id("compose-send-button")).click();
	    
	    		 
  } 
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		driver= new ChromeDriver();
		wait=new WebDriverWait(driver,30);
		 
			//System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver.exe");
			//driver=new FirefoxDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	driver.quit();
	 
  }

}
