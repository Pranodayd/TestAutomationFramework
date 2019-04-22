package com.UIAutomation.TestAutomation.TestTypes;

import org.openqa.selenium.WebElement;

import com.UIAutomation.TestAutomation.Utilities.Utilities;

//public abstract class NativeTest implements AutomationTest 
public abstract class NativeTest extends AutomationTest {

	String Port, UDID;

	public void StartAppiumServer() {

		Utilities.StartAppiumServerForAndroid(Port, UDID);
	}
	@Override
	public void SelectDateofBirthDate(String BirthDateIdentificationSTratergy, String BirthDateIdentificationLocator, String Date) {
		
		WebElement SelectDate=ReturnFoundElement(BirthDateIdentificationSTratergy, BirthDateIdentificationLocator);
		ClearElement(SelectDate);
		EnterText(SelectDate, Date);
		
	}
	 @Override
		public  void SelectMonthofBirthDate(String MonthIdentificationSTratergy,String  MonthIdentificationLocator,String Month) {
			WebElement SelectMonth=ReturnFoundElement(MonthIdentificationSTratergy, MonthIdentificationLocator);
			ClearElement(SelectMonth);
			EnterText(SelectMonth, Month);
		}
	 @Override
		public  void SelectYearofBirthDate(String YearIdentificationSTratergy,String  YearIdentificationLocator,String Year)
		{
			WebElement SelectYear=ReturnFoundElement(YearIdentificationSTratergy, YearIdentificationLocator);
			ClearElement(SelectYear);
			EnterText(SelectYear, Year);
		}
		
}
