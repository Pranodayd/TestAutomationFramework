package com.UIAutomation.TestAutomation.Pages;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

import com.UIAutomation.TestAutomation.TestTypes.AutomationTest;

public abstract class Page 
{

	
	AutomationTest T;
	HashMap<String,WebElement>ObjectRepo=new HashMap<String,WebElement>();
	public abstract void CreateObjectRepository(String RepositoryFileName);
}
