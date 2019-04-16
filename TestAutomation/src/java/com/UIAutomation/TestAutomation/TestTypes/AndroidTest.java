package com.UIAutomation.TestAutomation.TestTypes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Dictionary;
import java.util.Hashtable;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.UIAutomation.TestAutomation.Utilities.Utilities;

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
		// Get path of Nebory App path
		Capability.setCapability("app",
				Android_dict.get("AndroidApplicationDirectoryPath") + "\\" + Android_dict.get("AndroidAPKFileName"));
		Capability.setCapability("appPackage", Android_dict.get("ApplicationPackage"));
		Capability.setCapability("appActivity", Android_dict.get("ApplicationLaunchActivity"));
		// FullReset means uninstall app and again install app
		Capability.setCapability("fullReset", true);
		// noReset means clear app data and open app
		Capability.setCapability("noReset", false);
		Capability.setCapability("rotatable", true);
		// Used because of new appium
		Capability.setCapability("automationName", "uiautomator2");

		try {
			// Start session of app
			Driver = new AndroidDriver(
					new URL("http://" + Android_dict.get("AndroidAppiumServer") + ":" + Port + "/wd/hub"), Capability);
			// OTP is not autofilling so need to just clear data
			// Driver.resetApp();

		} catch (MalformedURLException Exc) {
			System.out.println("Problem in URL");

		}

	}

	public void LaunchApp() {

		DesiredCapabilities Capability = new DesiredCapabilities();
		Capability.setCapability("platformName", "Android");
		Capability.setCapability("deviceName", "AndroidDevice");
		Capability.setCapability("app",
				Android_dict.get("AndroidApplicationDirectoryPath") + "\\" + Android_dict.get("AndroidAPKFileName"));
		Capability.setCapability("appPackage", Android_dict.get("ApplicationPackage"));
		Capability.setCapability("appActivity", Android_dict.get("ApplicationLaunchActivity"));
		Capability.setCapability("fullReset", false);
		Capability.setCapability("noReset", true);
		Capability.setCapability("rotatable", true);
		Capability.setCapability("automationName", "uiautomator2");
		try {
			// Start session of app
			Driver = new AndroidDriver(
					new URL("http://" + Android_dict.get("AndroidAppiumServer") + ":" + Port + "/wd/hub"), Capability);

		} catch (MalformedURLException Exc) {
			System.out.println("Problem in URL");

		}

	}

	@Override
	public void SetupTest() {
		// TODO Auto-generated method stub
		
	}

}
