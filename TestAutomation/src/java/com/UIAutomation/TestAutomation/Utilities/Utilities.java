package com.UIAutomation.TestAutomation.Utilities;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

import com.UIAutomation.TestAutomation.TestTypes.AndroidTest;
import com.UIAutomation.TestAutomation.TestTypes.WebTest;

public class Utilities {
	// Read config file, give project file path in environment variables,read csv
	// file using that path
	public static Dictionary<String, String> dict = new Hashtable<String, String>();

	static Runtime rt = Runtime.getRuntime();

	static {
		String Server = "";
		try {
			Server = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {

			e.printStackTrace();
		}
		dict.put("AndroidAppiumServer", Server);
		String csvFile = "";
		BufferedReader br;
		try {
			// Give path of Config csv file in this file reader
			br = new BufferedReader(
					new FileReader("C:\\Brainizen\\brainizen-ui-automation\\AutomationAPI\\Repositories\\Config.csv"));
			String VariableName;
			String VariableValue;
			String[] parts = null;
			String line;
			try {

				line = br.readLine();
				while (line != null) {

					parts = line.split(",");
					VariableName = parts[0]; // 004
					try {
						VariableValue = parts[1]; // 034556

						dict.put(VariableName, VariableValue);
						line = br.readLine();
						System.out.println("value of " + VariableName + " is " + dict.get(VariableName).toString());
					} catch (ArrayIndexOutOfBoundsException ArrExc) {
						VariableValue = ""; // 034556
						VariableName = parts[0];
						dict.put(VariableName, VariableValue);
						System.out.println("value of " + VariableName + " is " + dict.get(VariableName).toString());
						try {
							line = br.readLine();
						} catch (IOException IOE) {
							System.out.println("Thrown IOException while reading file");

						}

					}
				}
			} catch (IOException IOexce) {

				System.out.println("IO Exception occured");
			}

		}

		catch (FileNotFoundException ex) {

			System.out.println("Csv file is not found");
		}
	}

	public static void StartAppiumServerForAndroid(String Port, String UDID) {
		Utilities.StopAppiumServer();
		System.out.println("Starting Appium server");
		CommandLine command = new CommandLine("cmd");
		command.addArgument("/c");
		command.addArgument("appium");
		command.addArgument("--address");
		command.addArgument(AndroidTest.Android_dict.get("AndroidAppiumServer").toString());
		command.addArgument("--port");
		command.addArgument(Port);
		command.addArgument("--command-timeout");
		command.addArgument("120000");
		command.addArgument("--udid");
		command.addArgument(UDID);
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			Thread.sleep(20000);
			executor.execute(command, resultHandler);
			Thread.sleep(20000);
			Utilities.WaitForProcessStart("node.exe");
		} catch (IOException Exc) {
			Exc.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Started Appium server");

	}

	public static void StartAppiumServerForIOS()

	{

	}

	public static void WaitForProcessStart(String ProcessName) throws IOException {
		String RunningProcessesList;
		do {
			Process p = rt.exec(System.getenv("windir") + "\\system32\\tasklist.exe");
			InputStream in = new BufferedInputStream(p.getInputStream());
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {

				sb.append(read);
				read = br.readLine();

			}

			RunningProcessesList = sb.toString();
			p.destroy();
		} while (RunningProcessesList.indexOf(ProcessName) == -1);

	}

	private static void StopAppiumServer() {
		try {
			// End appium using task manager
			rt.exec("taskkill /F /IM node.exe");
		} catch (IOException e) {

			System.out.println("Problem in stopping Appium Server");
		}

	}

	public static void StartSeleniumServer()

	{
		try {
			StopSeleniumServer();
		} catch (Exception e) {
			System.out.print("Problem in stopping Appium Server");
		}

		System.out.println("Starting Selenium server");
		CommandLine command = new CommandLine("cmd");
		command.addArgument("/c");
		command.addArgument("java -jar " + WebTest.Web_dict.get("SeleniumInstallationDir").toString() + "\\"+ WebTest.Web_dict.get("SeleniumStandaloneserverFileName").toString());
		command.addArgument("-host");
		command.addArgument(WebTest.Web_dict.get("SeleniumServerMachine").toString());
		command.addArgument("-port");
		command.addArgument(WebTest.Web_dict.get("SeleniumServerPort").toString());
		command.addArgument("-Dwebdriver.chrome.driver=");
		command.addArgument(WebTest.Web_dict.get("ChromeDriverPath").toString());
		command.addArgument("--command-timeout");
		command.addArgument("120000");

		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			Thread.sleep(20000);
			executor.execute(command, resultHandler);
			Thread.sleep(20000);
			///// Utilities.WaitForProcessStart("node.exe");
		} catch (IOException Exc) {
			Exc.printStackTrace();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Started Selenium server");
	}

	private static void StopSeleniumServer() {
		// TODO Auto-generated method stub

	}
	public static void WaitinMiliseconds(int Milliseconds) {
		try {
			Thread.sleep(Milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
