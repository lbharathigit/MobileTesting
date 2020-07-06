package mobiletest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AmazonAddProduct {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability("deviceName", "abc");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "abc");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//Code for browser application
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	    cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Projects\\Selenium\\chromedriver_win32\\chromedriver.exe");

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Code for browser application
		driver.get("http://amazon.in");
		driver.findElement(By.xpath("//input[@id='nav-search-keywords']")).sendKeys("iphone 7");
		driver.findElement(By.xpath("//input[@class='nav-input']")).click();
		driver.findElement(By.xpath("//*[@id=\"issDiv0\"]/div/span")).click();
		driver.findElement(By.xpath("//*[@id=\"search\"]/span[3]/div[2]/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"color_name-button\"]/span/input")).click();		
		driver.findElement(By.xpath("//*[@id=\"color_name_1\"]/span/input")).click();
     	driver.findElement(By.xpath("//span[@class='a-sheet-close a-focus-hidden']")).click(); 
     	driver.findElement(By.xpath("//*[@id=\"a-autoid-13-announce\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"mobileQuantityDropDown_4\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-wishlist-button-submit\"]")).click();
	
			
	}

}