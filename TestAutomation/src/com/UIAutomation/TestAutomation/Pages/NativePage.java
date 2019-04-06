package com.UIAutomation.TestAutomation.Pages;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.UIAutomation.TestAutomation.TestTypes.NativeTest;
import com.UIAutomation.TestAutomation.Utilities.Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public abstract class NativePage extends Page
{

	public NativeTest T;
    
	  public HashMap <String,MobileElement>ObjectRepo=new HashMap<String,MobileElement>();
	  public HashMap <String,String>Stratergy_Dict=new HashMap<String,String>();	
	  public HashMap <String,String>Locator_Dict=new HashMap<String,String>();
	  public void CreateObjectRepository(String RepositoryFileName)
	  	{
	  		
	  			MobileElement WebElemnt;
	  			String csvFile="";
	  			BufferedReader br;
	  			
	  			
	  			try{
	  					br = new BufferedReader(new FileReader(Utilities.dict.get("ObjectRepositoriesFolderPath").toString()+"\\"+RepositoryFileName+".csv"));
	  					System.out.println("Path of Repositories:"+Utilities.dict.get("ObjectRepositoriesFolderPath").toString()+"\\"+RepositoryFileName+".csv");
	  					String VariableName;
	  					MobileElement VariableValue;
	  					String[] parts = null;
	  					String line;
	  					try
	  						{
	  							 
	  							line=br.readLine();	
	  							while (line!=null)
	  							{
	  									
	  								parts = line.split(",");
	  								VariableName = parts[0];
	  								System.out.println(parts[0]);
	  								try
	  								{
	  										String Identification_Stratergy = parts[1]; 
	  										System.out.println(parts[1]);
	  										
	  										String Locator=parts[2];
	  										if (parts.length>3)
	  										{
	  											for (int len=3;len<parts.length;len++)
	  											{
	  												
	  												Locator=Locator+","+parts[len];
	  											}	
	  											
	  										}
	  										WebElemnt=(MobileElement)ReturnFoundElement(Identification_Stratergy,Locator);
	  										ObjectRepo.put(VariableName,WebElemnt);
	  										line=br.readLine();
	  										System.out.println("value of "+ VariableName +" is " + ObjectRepo.get(VariableName).toString());
	  								}		
	  								
	  								catch(NoSuchElementException Except)
	  								{
	  									System.out.println("Element presence may not be guaranteed");
	  									Stratergy_Dict.put(parts[0], parts[1]);
	  									Locator_Dict.put(parts[0], parts[2]);
	  									line=br.readLine();
	  								}
	  								catch (ArrayIndexOutOfBoundsException ArrExc)
	  								{
	  									VariableValue =null;
	  									VariableName=parts[0];
	  									ObjectRepo.put(VariableName,VariableValue);
	  									System.out.println("value of "+ VariableName +" is " + ObjectRepo.get(VariableName).toString());
	  									try{
	  											line=br.readLine();
	  									   }	
	  									catch(IOException IOE)
	  									{
	  										System.out.println("Thrown IOException while reading file");
	  										
	  									}
	  								}
	  							}//End of while
	  						}
	  						catch(IOException IOexce)
	  						{
	  						
	  							System.out.println("IO Exception occured");
	  						}	
	  									
	  					}
	  				catch(FileNotFoundException IOexce)
	  				{
	  				
	  					System.out.println("File not found");
	  				}
	  			}//CreateObjectRepository Method close
	      public WebElement ReturnFoundElement(String Stratergy, String Locator) {

	          switch (Stratergy) {

	              case "BY_ID":
	                  return (T.Driver.findElement(By.id(Locator)));

	              case "BY_XPATH":
	                  return (T.Driver.findElement(By.xpath(Locator)));
	              case "BY_ANDROIDUIAUTOMATOR":
	                  String[] SplitedLocator = Locator.split("=");
	                  String UiAutomatorLocator = "new UiSelector()." + SplitedLocator[0] + "(\"" + SplitedLocator[1] + "\");";
	                  return (((AndroidDriver) T.Driver).findElementByAndroidUIAutomator(UiAutomatorLocator));

	              case "BY_CLASSNAME":
	                  return (T.Driver.findElementByClassName(Locator));

	              case "BY_NAME":
	                  return (T.Driver.findElementByName(Locator));
	              case "BY_TAGNAME":
	                  return (T.Driver.findElementByTagName(Locator));


	          }


	          return null;


	      }


}
