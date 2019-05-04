package com.UIAutomation.TestAutomation.TestTypes;

import java.time.Duration;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public abstract class MobileNativeTest extends NativeTest {

	public enum Directions {

		UP, DOWN, LEFT, RIGHT

	}

	public abstract void LaunchApp();

	public void SwipeElement(MobileElement Element, Directions direction) {
		switch (direction) {
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

	private void SwipeUP(MobileElement Element) {
		TouchAction Act = new TouchAction((AppiumDriver) Driver);
		int Width = GetDimensions(Element, Dimensions.WIDTH);
		int MidWidth = Width / 2;

		int X = GetCoordinates(Element, Coordinates.X);
		int StartPointX = X + MidWidth;

		// Get height of mobile screen
		int Height = GetDimensions(Element, Dimensions.HEIGHT);
		int MidHeight = Height / 2;

		int Y = GetCoordinates(Element, Coordinates.Y);
		int StartPointY = Y + MidHeight;

		Act.press(PointOption.point(StartPointX, StartPointY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(StartPointX, 0))
				.release().perform();

	}

	private void SwipeDown(MobileElement Element) {

		TouchAction Act = new TouchAction((AppiumDriver) Driver);
		int Width = GetDimensions(Element, Dimensions.WIDTH);
		int MidWidth = Width / 2;

		int X = GetCoordinates(Element, Coordinates.X);
		int StartPointX = X + MidWidth;

		// Get height of mobile screen
		int Height = GetDimensions(Element, Dimensions.HEIGHT);
		int MidHeight = Height / 2;

		int Y = GetCoordinates(Element, Coordinates.Y);
		int StartPointY = Y + MidHeight;

		Act.press(PointOption.point(StartPointX, StartPointY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(StartPointX, Height)).release().perform();
	}

	private void SwipeLeft(MobileElement Element) {

		TouchAction Act = new TouchAction((AppiumDriver) Driver);
		int Width = GetDimensions(Element, Dimensions.WIDTH);
		int MidWidth = Width / 2;

		int X = GetCoordinates(Element, Coordinates.X);
		int StartPointX = X + MidWidth;

		// Get height of mobile screen
		int Height = GetDimensions(Element, Dimensions.HEIGHT);
		int MidHeight = Height / 2;

		int Y = GetCoordinates(Element, Coordinates.Y);
		int StartPointY = Y + MidHeight;

		Act.press(PointOption.point(StartPointX, StartPointY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(0, StartPointY))
				.release().perform();
	}

	private void SwipeRight(MobileElement Element) {

		TouchAction Act = new TouchAction((AppiumDriver) Driver);
		int Width = GetDimensions(Element, Dimensions.WIDTH);
		int MidWidth = Width / 2;

		int X = GetCoordinates(Element, Coordinates.X);
		int StartPointX = X + MidWidth;

		// Get height of mobile screen
		int Height = GetDimensions(Element, Dimensions.HEIGHT);
		int MidHeight = Height / 2;

		int Y = GetCoordinates(Element, Coordinates.Y);
		int StartPointY = Y + MidHeight;

		Act.press(PointOption.point(0, StartPointY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(StartPointX, StartPointY)).release().perform();
	}

	public void CloseKeyboard() {

		Driver.navigate().back();

	}
	 public void SwipeElementTillElementFoundandClick(MobileElement ElementToBeSwiped,String ElementTobeFoundLocatorStratergy,String ElementTobeFoundLocator,WebElement ElementtobeClicked, Directions direction)
	  {
		
	  if (IsElementFound(ElementTobeFoundLocatorStratergy, ElementTobeFoundLocator)==false) 
	  {
		  
		SwipeElement(ElementToBeSwiped, direction);
						 
		  try 
		  {
			  
			  	Thread.sleep(3000);
			  				  	
		  } 
		  catch (InterruptedException e) 
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		
	} else 
	{
		ClickElement(ElementtobeClicked);
	}
		 
		  
		  
	  }
	
}
