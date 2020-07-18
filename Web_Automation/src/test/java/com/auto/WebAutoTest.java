package com.auto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebAutoTest {
	
	WebDriver driver;
	//try with another user credentials to perform registration
	String email="alicebobdoos123@gmail.com";
	String password="123456";
	String firstname="Alice";
	String lastname="Keren";
	String phone="9876543210";
	
	@BeforeMethod
	public void openBrowser() throws InterruptedException	{
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	    driver.get("http://automationpractice.com/index.php");
	}
	
	@Test
	public void automateTest()  {
		
		//Register
		
	driver.findElement(By.linkText("Sign in")).click();
	System.out.println("We are currently on the following URL" +driver.getCurrentUrl());
	driver.findElement(By.cssSelector("[name='email_create']")).sendKeys(email);
	driver.findElement(By.xpath("//button[@id='SubmitCreate'][@type='submit']")).click();
	driver.findElement(By.xpath("//input[@id=\"id_gender1\"]")).click();
	driver.findElement(By.id("customer_firstname")).sendKeys(firstname);
	driver.findElement(By.id("customer_lastname")).sendKeys(lastname);
	driver.findElement(By.id("email")).clear();
	driver.findElement(By.id("email")).sendKeys(email);
	driver.findElement(By.id("passwd")).sendKeys(password);
	driver.findElement(By.xpath("//input[@id='address1'][@type='text']")).sendKeys("2nd avenue");
	driver.findElement(By.xpath("//input[@id='city'][@type='text']")).sendKeys("California");
	driver.findElement(By.xpath("//select[@id='id_state']")).sendKeys("California");
	driver.findElement(By.id("postcode")).sendKeys("90201");
	driver.findElement(By.xpath("//select[@id='id_country']")).sendKeys("United States");
	driver.findElement(By.id("phone_mobile")).sendKeys(phone);
	driver.findElement(By.xpath("//input[@name=\"alias\"]")).clear();
	driver.findElement(By.xpath("//input[@name=\"alias\"]")).sendKeys("Office");
	driver.findElement(By.xpath("//button[@id='submitAccount'][@type='submit']")).click();
		
		String userText=driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();
		  
		  //User validation whether the user is created or not
		  
		  if(userText.contains("Alice")) {
		   System.out.println("User Verified,Test case Passed");
		  }
		  else {
		   System.out.println("User Verification Failed,Test case Failed");
		  }
	
	    //login if you want only when after the user has been created 
	
//	driver.findElement(By.linkText("Sign in")).click();
//	System.out.println("We are currently on the following URL" +driver.getCurrentUrl());
//	  driver.findElement(By.id("email")).sendKeys(email);
//	  driver.findElement(By.id("passwd")).sendKeys(password);
//	  driver.findElement(By.id("SubmitLogin")).click();
	
	//Click on Women
	  
	  driver.findElement(By.linkText("WOMEN")).click();
	  WebElement SecondImg=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img"));
	  WebElement MoreBtn=driver.findElement(By.xpath("/html/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul/li[2]/div[1]/div[2]/div[2]/a[2]"));
	  Actions actions=new Actions(driver);
	  actions.moveToElement(SecondImg).moveToElement(MoreBtn).click().perform();

	  //Change quantity by 2
	  
	  driver.findElement(By.id("quantity_wanted")).clear();
	  driver.findElement(By.id("quantity_wanted")).sendKeys("1");
	  
	  //size
	  
	  driver.findElement(By.xpath("//select[@id='group_1']")).sendKeys("M");

	  //Select Color
	  
	  driver.findElement(By.id("color_11")).click();

	   //add to cart
	  
	  driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();
	
	}
	
		
  @AfterMethod
  public void closeBrowser() {
	  driver.quit();
  }
}
