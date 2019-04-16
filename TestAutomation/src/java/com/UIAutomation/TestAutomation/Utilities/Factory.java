package com.UIAutomation.TestAutomation.Utilities;

import com.UIAutomation.TestAutomation.Pages.AndroidPage;
import com.UIAutomation.TestAutomation.Pages.Page;
import com.UIAutomation.TestAutomation.Pages.WebPage;

public class Factory {

	public static Page FactoryMethod(String Platform) {

		switch (Platform) {
		case "IOS":
			// return new IOSPage();

		case "Android":
			/// return new AndroidPage(Browser,ClassName);
			return new AndroidPage();

		case "Desktop":
			return new WebPage();
		}
		return null;

	}
}
