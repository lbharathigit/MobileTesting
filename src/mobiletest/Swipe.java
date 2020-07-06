package mobiletest;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

public class Swipe {
	
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
	//driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
	
	driver.findElement(MobileBy.AccessibilityId("Search tab")).click();
	driver.findElement(MobileBy.AccessibilityId("Search")).sendKeys("Math");
	driver.hideKeyboard();
	
	Thread.sleep(3000);
//	driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Doodling in math: Stars\")")).click();
//	driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Doodling in math: Stars\")"));
	
	TouchAction act = new TouchAction(driver);
	Dimension d = driver.manage().window().getSize();
	int width = d.width;
	int height = d.height;
	int x1 = width/2;
	int y1 = 4*height/5;
	int x2 = width/2;
	int y2 = height/5;
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	while(driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"Math patterns: table\")")).size()==0)
	{
		act.press(PointOption.point(x1,y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x2,y2)).release().perform();
		//driver.executeScript("mobile:shell", ImmutableMap.of("command", "input swipe "+x1+" "+y1+" "+x2+" "+y2));
	}
//	driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Math patterns: table\")")).click();
//	Assert.assertEquals(driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Math patterns: table\")")).getText(), "Math patterns: table");
	driver.openNotifications();
	driver.pressKey(new KeyEvent(AndroidKey.HOME));
	

}

}