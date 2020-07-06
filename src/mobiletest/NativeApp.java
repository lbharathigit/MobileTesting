package mobiletest;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class NativeApp {
	
	@Test
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "abc");
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	//	cap.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
	cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
	cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
	AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
	driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
	driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
	driver.findElement(MobileBy.AccessibilityId("Continue with Facebook")).click();
	
	driver.findElement(MobileBy.AccessibilityId("Username")).sendKeys("test");
	driver.findElement(MobileBy.AccessibilityId("Password")).sendKeys("test");
	driver.findElement(MobileBy.AccessibilityId("Log In")).click();
	//System.out.println(driver.getContextHandles());
	//driver.context(driver.getContextHandles().toArray()[1].toString());
	//System.out.println(driver.getContext());
	//driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"m_login_email\")")).sendKeys("test");
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"com.facebook.katana:id/(name removed)\")")).getText(), "It looks like test doesn't match an existing account. If you don't have a Facebook account, you can create one now.");
	
	

}

}