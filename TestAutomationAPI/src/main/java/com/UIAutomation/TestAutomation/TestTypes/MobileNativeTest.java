package com.UIAutomation.TestAutomation.TestTypes;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.UIAutomation.TestAutomation.Pages.NativePage;
import com.UIAutomation.TestAutomation.Utilities.Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public abstract class MobileNativeTest extends NativeTest
{
	
	public enum Directions
	{
		
		UP,
		DOWN,
		LEFT,
		RIGHT
		
	}
	public abstract void LaunchApp();
	
	/*
	public void ClickElement(MobileElement E) 
	{
		E.click();

	}
	public void EnterText(MobileElement E,String value)
	{
		
		E.sendKeys(value);
		
	}
	public void ClearElement(MobileElement Element)
	{
		Element.clear();
	}
	*/
	
	public void SwipeElement(MobileElement Element,Directions direction) 
	{		
		switch(direction)
		{
			case UP:
				SwipeUP(Element);
				break;
			case DOWN:
				SwipeDown(Element);
				break;
			case LEFT:
				SwipeLeft(Element);
				break;
			case RIGHT:	
				SwipeRight(Element);
				break;
		
		}
		
		
	
	}
	
	private void SwipeUP(MobileElement Element)
	{
		TouchAction Act=new TouchAction((AppiumDriver)Driver);
		int Width=GetDimensions(Element, Dimensions.WIDTH);
		int MidWidth=Width/2;
		
		int X=GetCoordinates(Element, Coordinates.X);
		int StartPointX=X+MidWidth;
		
		//Get height of mobile screen
		int Height=GetDimensions(Element, Dimensions.HEIGHT);
		int MidHeight=Height/2;
		
		int Y=GetCoordinates(Element, Coordinates.Y);
		int StartPointY=Y+MidHeight;
		
		Act.press(PointOption.point(StartPointX,StartPointY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(StartPointX,0)).release().perform();
		
	}
	
	private void SwipeDown(MobileElement Element)
	{
		
		TouchAction Act=new TouchAction((AppiumDriver)Driver);
		int Width=GetDimensions(Element, Dimensions.WIDTH);
		int MidWidth=Width/2;
		
		int X=GetCoordinates(Element, Coordinates.X);
		int StartPointX=X+MidWidth;
		
		//Get height of mobile screen
		int Height=GetDimensions(Element, Dimensions.HEIGHT);
		int MidHeight=Height/2;
		
		int Y=GetCoordinates(Element, Coordinates.Y);
		int StartPointY=Y+MidHeight;
		
		Act.press(PointOption.point(StartPointX,StartPointY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(StartPointX,Height)).release().perform();
	}
	private void SwipeLeft(MobileElement Element)
	{
		
		TouchAction Act=new TouchAction((AppiumDriver)Driver);
		int Width=GetDimensions(Element, Dimensions.WIDTH);
		int MidWidth=Width/2;
		
		int X=GetCoordinates(Element, Coordinates.X);
		int StartPointX=X+MidWidth;
		
		//Get height of mobile screen
		int Height=GetDimensions(Element, Dimensions.HEIGHT);
		int MidHeight=Height/2;
		
		int Y=GetCoordinates(Element, Coordinates.Y);
		int StartPointY=Y+MidHeight;
		
		Act.press(PointOption.point(StartPointX,StartPointY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(0,StartPointY)).release().perform();
	}
	private void SwipeRight(MobileElement Element)
	{
		
		TouchAction Act=new TouchAction((AppiumDriver)Driver);
		int Width=GetDimensions(Element, Dimensions.WIDTH);
		int MidWidth=Width/2;
		
		int X=GetCoordinates(Element, Coordinates.X);
		int StartPointX=X+MidWidth;
		
		//Get height of mobile screen
		int Height=GetDimensions(Element, Dimensions.HEIGHT);
		int MidHeight=Height/2;
		
		int Y=GetCoordinates(Element, Coordinates.Y);
		int StartPointY=Y+MidHeight;
		
		Act.press(PointOption.point(0,StartPointY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(StartPointX,StartPointY)).release().perform();
	}
		
	
	public void CloseKeyboard() 
	{
		
			
			Driver.navigate().back();
		
		
	}


	}
