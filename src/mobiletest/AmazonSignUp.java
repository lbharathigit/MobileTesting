package mobiletest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AmazonSignUp {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "abc");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	    cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Projects\\Selenium\\chromedriver_win32\\chromedriver.exe");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://amazon.in");
		driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();
		driver.findElement(By.xpath("//div[@id='hmenu-customer-name']")).click();
		driver.findElement(By.xpath("//a[@id='register_accordion_header']")).click();
		driver.findElement(By.xpath("//input[@id='ap_customer_name']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@id='ap_phone_number']")).sendKeys("9094020577");
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
		String Actual = driver.findElement(By.xpath("//*[@class='a-alert-heading']")).getText();
		System.out.println(Actual);
		String Expected = "You indicated you are a new customer, but an account already exists with the mobile number";
		if(Actual.contains(Expected))
		{
			System.out.println("Mobile number already in use");
		}
		else
		{
			System.out.println("Account created");
		}
		
		System.out.println("As Expected");
		

	}

}