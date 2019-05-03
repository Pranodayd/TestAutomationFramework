package com.UIAutomation.TestAutomation.TestTypes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.UIAutomation.TestAutomation.Utilities.Utilities;

//public abstract class WebTest implements AutomationTest
public  class WebTest extends AutomationTest {

	public static Dictionary<String, String> Web_dict = new Hashtable<String, String>();

	static {
		String csvFile = "";
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(Utilities.dict.get("WebEnvvars").toString()));
			String VariableName;
			String VariableValue;
			String[] parts = null;
			String line;

			line = br.readLine();
			while (line != null) {

				parts = line.split(",");
				VariableName = parts[0]; // 004
				try {
					VariableValue = parts[1]; // 034556

					Web_dict.put(VariableName, VariableValue);
					line = br.readLine();
					System.out.println("value of " + VariableName + " is " + Web_dict.get(VariableName).toString());
				} catch (ArrayIndexOutOfBoundsException ArrExc) {
					VariableValue = ""; // 034556
					VariableName = parts[0];
					Web_dict.put(VariableName, VariableValue);
					System.out.println("value of " + VariableName + " is " + Web_dict.get(VariableName).toString());
					try {
						line = br.readLine();
					} catch (IOException IOE) {
						System.out.println("Thrown IOException while reading file :" + IOE.getMessage());
					}

				}
			}

		} catch (FileNotFoundException ex) {
			System.out.println("Csv file is not found : " + ex.getMessage());
		} catch (IOException IOexce) {
			System.out.println("IO Exception occured : " + IOexce.getMessage());
		}

		// Initialise_Android_Locator_String_ToTokens_Dictionary();
	}
	public void SetupTest(String Platform,String BrowserName) 
	{

		Utilities.StartSeleniumServer();
		StartBrowser(BrowserName);
		Driver.get(Web_dict.get("ApplicationURL").toString());
	}

	
	//public void SetupTest(String Port, String UDID) {}

	void StartBrowser(String BrowserName)
	{
		switch(BrowserName)
		{
		
		
			case "Chrome":
				File file = new File(Web_dict.get("ChromeDriverPath").toString());
				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
				
				DesiredCapabilities Capability = DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--load-extension="+Web_dict.get("ExtensionPath"));
				options.addArguments("--disable-notifications");
				
				options.addArguments("--start-maximized");	
				
				Capability.setCapability(ChromeOptions.CAPABILITY, options);
				
				Driver=new ChromeDriver();
				break;
		
		}
		
	}


	@Override
	public void SelectItemFromMenu(String MenuIdentificationSTratergy, String MenuIdentificationLocator,
			String MenuItem) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void InvokePulldownMenu(String MenuIdentificationSTratergy, String MenuIdentificationLocator) {
		// TODO Auto-generated method stub
		
	}


	


	@Override
	public void SelectDatefromDatePicker(String DateIdentificationStratergy, String DateIdentificationLocator,
			String Date) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void SelectMonthfromDatePicker(String MonthIdentificationStratergy, String MonthIdentificationLocator,
			String Month) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void SelectYearfromDatePicker(String YearIdentificationStratergy, String YearsIdentificationLocator,
			String Year) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void ScrolltillElemntFound(WebElement Element) {
		JavascriptExecutor je = (JavascriptExecutor) Driver;
		je.executeScript("arguments[0].scrollIntoView(true);",Element);
	
	}


	@Override
	public void ClickonSwitchButtonifOFF(WebElement Element) {
		// TODO Auto-generated method stub
		
	}
}
