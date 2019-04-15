package com.UIAutomation.TestAutomation.TestTypes;

import com.UIAutomation.TestAutomation.Utilities.Utilities;

//public abstract class NativeTest implements AutomationTest 
public abstract class NativeTest extends AutomationTest {

	String Port, UDID;

	public void StartAppiumServer() {

		Utilities.StartAppiumServerForAndroid(Port, UDID);
	}

}
