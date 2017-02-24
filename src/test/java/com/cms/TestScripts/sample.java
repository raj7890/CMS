package com.cms.TestScripts;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class sample {
	
	WebDriver driver;
 
	 
	@SuppressWarnings("unchecked")
	@Test (priority=1)
	public void Login(){
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver =new ChromeDriver();
		
		//driver =new FirefoxDriver();
		
		driver.get("https://www.linkedin.com/");
		System.out.println("Login Page called...");	
		
		driver.findElement(By.id("login-email")).sendKeys("kirankumar3054@gmail.com");
		driver.findElement(By.id("login-password")).sendKeys("linkKiran9$");
		driver.findElement(By.id("login-password")).sendKeys(Keys.ENTER);
		
		
	     }//Login-end
	
	    @Test (priority=2) 
		public void LinkConnect() throws InterruptedException{
		//driver.manage().windows
		// People with hr manager titles in United States
		
		driver.findElement(By.xpath("html/body/div[2]/div[1]/div/div[1]/form/fieldset/div[1]/span/span")).click();
		driver.findElement(By.xpath("html/body/div[2]/div[1]/div/div[1]/form/fieldset/div[1]/ul/li[2]/div")).click();
		
		driver.findElement(By.id("main-search-box")).clear();
		driver.findElement(By.id("main-search-box")).sendKeys("QA vice president" + Keys.ENTER);
				
		System.out.println("Search results READY to connect");
		 
		driver.findElement(By.xpath("html/body/div[3]/div/div[2]/div[1]/div[4]/form/div/ul/li[1]/fieldset/div/ol/li[3]/input")).click();
		System.out.println("Cliked on 2nd Connections...");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='us:0-G-ffs']")).click();
		// random mouse click
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
		WebElement toElement = driver.findElement(By.id("pivot-bar"));
		Actions builder = new Actions(driver);   
		builder.moveToElement(toElement, 50, 50).click().build().perform(); 
		System.out.println("Random mouse click completed...");
		By next = By.linkText("Next >");
		page(next);		
				 
		}//LinkConnect-end
		
	    
		/*
		@Test (priority=3)
		public void LogOut(){
			System.out.println(" In logout...");
			WebElement ele1 = driver.findElement(By.xpath("//*[@id='account-nav']/ul/li[4]/a/img"));
			Actions act1 =new Actions(driver);
			act1.moveToElement(ele1).perform();
			driver.findElement(By.xpath("//*[@id='account-sub-nav']/div/div[2]/ul/li[1]/div/span/span[3]/a")).click();
			
		}//logout-end   */
	    
	    
	    public void page(By element) throws InterruptedException
	    {
	    	if(!driver.findElement(element).isEnabled()){
	    		connect();
	    		
	    	}else{
	    		connect();
	    		driver.findElement(element).click();
	    		page(element);
	    	}
			
	    	
	    }
	    
	    public void connect() throws InterruptedException{
	    	int j = driver.findElements(By.linkText("Connect")).size();
			 for(int i=1;i<=j;i++) {
				
				Thread.sleep(5000); 
				driver.findElement(By.linkText("Connect")).click();
				System.out.println("Cliked on Connect # :"+i);
				
				//Scroll down page
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,50)", "");					 
				System.out.println("Scroll down  # :"+i);
				
			}
	    }

}//main class-end
