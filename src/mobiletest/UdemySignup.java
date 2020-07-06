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

public class UdemySignup {
	
	@Test
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "abc");
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	//	cap.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
	cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.udemy.android");
	cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.udemy.android.SplashActivity");
	AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
	driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in with Facebook\")")).click();
	
	driver.findElement(MobileBy.AccessibilityId("Username")).sendKeys("<username>");
	driver.findElement(MobileBy.AccessibilityId("Password")).sendKeys("<password>");
	driver.findElement(MobileBy.AccessibilityId("Log In")).click();
	driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"CONTINUE AS BHARATHIDHASAN\")")).click();
	
	
	//driver.quit();
	

}

}