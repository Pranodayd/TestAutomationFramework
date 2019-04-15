package com.UIAutomation.TestAutomation.Pages;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.UIAutomation.TestAutomation.TestTypes.AndroidTest;
import com.UIAutomation.TestAutomation.Utilities.Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AndroidPage extends MobileNativePage 
{

	//AndroidTest T;

	public AndroidPage()
	{
		
		//P=new Sub1();
		T=new AndroidTest();
		
		
	}

}
