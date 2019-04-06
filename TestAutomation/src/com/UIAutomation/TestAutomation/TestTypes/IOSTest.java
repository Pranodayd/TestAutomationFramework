package com.UIAutomation.TestAutomation.TestTypes;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.MobileElement;

public class IOSTest extends MobileNativeTest 
{

	public void SetupTest(String Port,String UDID)
	{
		
		
	}

	@Override
	public void StopTest() 
	{
		
		
	}
	
	public void EnterText(MobileElement E,String Str)
	{
		
		E.clear();
		E.sendKeys(Str);
		
	}

	@Override
	public String GetWebElementText(MobileElement Element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ClickonElementinList(String LocatorStratergy, String Locator) {
		// TODO Auto-generated method stub
		
	}

	
}
