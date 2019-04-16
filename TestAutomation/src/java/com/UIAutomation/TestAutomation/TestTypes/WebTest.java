package com.UIAutomation.TestAutomation.TestTypes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.UIAutomation.TestAutomation.Utilities.Utilities;

//public abstract class WebTest implements AutomationTest
public abstract class WebTest extends AutomationTest {

	public RemoteWebDriver Driver;
	public String Browser;
	public String ApplicationURL;
	public static Dictionary Web_dict = new Hashtable();
	 //static Runtime rt;
	 static Runtime rt = Runtime.getRuntime();
	static
	{
		String csvFile="";
		BufferedReader br;
		try{
					br = new BufferedReader(new FileReader(Utilities.dict.get("WebEnvVars").toString()));
				
			String VariableName;
				String VariableValue;
				String[] parts = null;
				String line;
						 
						line=br.readLine();	
						while (line!=null)
							{
								//System.out.println(line);
								parts = line.split(",");
								VariableName = parts[0]; // 004
								try
								{
										VariableValue = parts[1]; // 034556
							
										Web_dict.put(VariableName,VariableValue);
										line=br.readLine();
										System.out.println("value of "+ VariableName +" is " + Web_dict.get(VariableName).toString());
								}		
								catch (ArrayIndexOutOfBoundsException ArrExc)
								{
									VariableValue = ""; // 034556
									VariableName=parts[0];
									Web_dict.put(VariableName,VariableValue);
									System.out.println("value of "+ VariableName +" is " + Web_dict.get(VariableName).toString());
									try{
											line=br.readLine();
									   }	
									catch(IOException IOE)
									{
										System.out.println("Thrown IOException while reading file :" +IOE.getMessage());
									}
									//System.out.println("Value is blank");
								}
							}
				
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("Csv file is not found : " + ex.getMessage());
		}
		catch(IOException IOexce)
		{
			System.out.println("IO Exception occured : " + IOexce.getMessage());
		}
		
		//Initialise_Web_Locator_String_ToTokens_Dictionary();
	}
	public WebTest(String BrowserName) {
		this.Browser=BrowserName;
	}
	public void SetupTest() {

		Utilities.StartSeleniumServer();
		File file = new File(Web_dict.get("ChromeDriverPath").toString());
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		DesiredCapabilities Capability = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--load-extension="+Web_dict.get("ExtensionPath"));
		options.addArguments("--disable-notifications");
		
		options.addArguments("--start-maximized");	
		
		Capability.setCapability(ChromeOptions.CAPABILITY, options);
		
			Driver=new ChromeDriver();
		
		Driver.get(Web_dict.get("ApplicationURL").toString());
	}

	public void StartApplication(String Browser) {

	}
	public void SetupTest(String Port, String UDID) {}
}
