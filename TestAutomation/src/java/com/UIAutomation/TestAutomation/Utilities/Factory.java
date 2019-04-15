package com.UIAutomation.TestAutomation.Utilities;

import com.UIAutomation.TestAutomation.Pages.AndroidPage;
import com.UIAutomation.TestAutomation.Pages.NativePage;

public class Factory {

	public static NativePage FactoryMethod(String Platform) {

		switch (Platform) {
		case "IOS":
			// return new IOSPage();

		case "Android":
			/// return new AndroidPage(Browser,ClassName);
			return new AndroidPage();
		}
		return null;

	}
}
