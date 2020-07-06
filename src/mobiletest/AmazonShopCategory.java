package mobiletest;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AmazonShopCategory {
	
		
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "abc");
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	//	cap.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
	cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Projects\\Selenium\\chromedriver_win32\\chromedriver.exe");
	AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("http://amazon.in");
	driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();
	driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[6]/a")).click();
	driver.findElement(By.xpath("//span[contains(text(),'Fire')]")).click();
	driver.findElement(By.xpath("//span[contains(text(),'Remote')]")).click();
	driver.findElement(By.xpath("/html/body/div[6]/div/span[2]")).click();
	driver.findElement(By.xpath("//*[@id=\"configuration-button\"]/span/input")).click();
	driver.findElement(By.xpath("//*[@id=\"configuration_1-announce\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"sfl-button\"]")).click();

	
	
	//driver.quit();
	

}

}