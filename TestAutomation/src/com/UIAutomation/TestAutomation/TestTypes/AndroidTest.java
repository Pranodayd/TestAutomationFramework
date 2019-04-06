package com.UIAutomation.TestAutomation.TestTypes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.UIAutomation.TestAutomation.Utilities.Utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AndroidTest extends MobileNativeTest {
	String AndroidAppiumServerPort;
	String UDIDOfDevice;
	public static Dictionary<String, String> Android_dict = new Hashtable<String, String>();

	static {
		String csvFile = "";
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(Utilities.dict.get("AndroidEnvVars").toString()));
			String VariableName;
			String VariableValue;
			String[] parts = null;
			String line;

			line = br.readLine();
			while (line != null) {
				// System.out.println(line);
				parts = line.split(",");
				VariableName = parts[0]; // 004
				try {
					VariableValue = parts[1]; // 034556

					Android_dict.put(VariableName, VariableValue);
					line = br.readLine();
					System.out.println("value of " + VariableName + " is " + Android_dict.get(VariableName).toString());
				} catch (ArrayIndexOutOfBoundsException ArrExc) {
					VariableValue = ""; // 034556
					VariableName = parts[0];
					Android_dict.put(VariableName, VariableValue);
					System.out.println("value of " + VariableName + " is " + Android_dict.get(VariableName).toString());
					try {
						line = br.readLine();
					} catch (IOException IOE) {
						System.out.println("Thrown IOException while reading file :" + IOE.getMessage());
					}
					// System.out.println("Value is blank");
				}
			}

		} catch (FileNotFoundException ex) {
			System.out.println("Csv file is not found : " + ex.getMessage());
		} catch (IOException IOexce) {
			System.out.println("IO Exception occured : " + IOexce.getMessage());
		}

		// Initialise_Android_Locator_String_ToTokens_Dictionary();
	}

	public void SetupTest(String Port, String UDID) {

		Utilities.StartAppiumServerForAndroid(Port, UDID);
		DesiredCapabilities Capability = new DesiredCapabilities();
		Capability.setCapability("platformName", "Android");
		Capability.setCapability("deviceName", "AndroidDevice");
		Capability.setCapability("app",
				Android_dict.get("AndroidApplicationDirectoryPath") + "\\" + Android_dict.get("AndroidAPKFileName"));
		Capability.setCapability("appPackage", Android_dict.get("ApplicationPackage"));
		Capability.setCapability("appActivity", Android_dict.get("ApplicationLaunchActivity"));
		Capability.setCapability("fullReset", true);
		Capability.setCapability("noReset", false);
		Capability.setCapability("rotatable", true);
		Capability.setCapability("automationName", "uiautomator2");
		/*
		 * Capability.setCapability("useKeystore",true);
		 * Capability.setCapability("keystorePath",
		 * "C:\\Framework\\Snehal\\AutomationFramework\\TestAutomation\\Repositories\\Nebory-keystore\\nebory.keystore"
		 * ); Capability.setCapability("keyAlias","nebory");
		 * Capability.setCapability("keystorePassword","yinyang12");
		 */

		try {
			Driver = new AndroidDriver(
					new URL("http://" + Android_dict.get("AndroidAppiumServer") + ":" + Port + "/wd/hub"), Capability);

		} catch (MalformedURLException Exc) {
			System.out.println("Problem in URL");

		}

	}

	@Override
	public void StopTest() {
		// TODO Auto-generated method stub

	}
	public  void ClickonElementinList(String Locator_Stratergy,String Locator)
	{
		List<MobileElement> ElementToBeClicked=GetListofElements(Driver, Locator_Stratergy, Locator);
		Utilities.ClickElementinList(ElementToBeClicked);
	}

}
