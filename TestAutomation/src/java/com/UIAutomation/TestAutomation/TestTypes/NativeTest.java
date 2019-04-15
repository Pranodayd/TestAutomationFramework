package com.UIAutomation.TestAutomation.TestTypes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.UIAutomation.TestAutomation.Utilities.Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

//public abstract class NativeTest implements AutomationTest 
public abstract class NativeTest extends AutomationTest 
{


	
	
	String Port,UDID;
	
	
	public void StartAppiumServer()
	{
		
		Utilities.StartAppiumServerForAndroid(Port,UDID);
	}
	
		
	}
